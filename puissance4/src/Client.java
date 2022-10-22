import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    static int ID = 10;
    public static void main(String[] args) {
        ByteBuffer bytes = ByteBuffer.allocate(20);
        try {
            SocketChannel socket = SocketChannel.open();
            socket.connect(new InetSocketAddress("localhost", 4004));
            while (true) {
                try {
                    System.out.println("Waiting for player(s) to connect...");
                    ID = socket.read(bytes);
                    int nbPlayers = socket.read(bytes);
                    Menu.nbPlayers = nbPlayers;
                    App.game.grid(nbPlayers);
                    App.game.BuildGrid();
                    App.game.DisplayGrid();
                    while(!Menu.gameOver) {
                        WinCond.CheckWin(App.game);
                        if (Menu.gameOver){
                            break;
                        }
                        bytes.clear();
                        int turn = socket.read(bytes);
                        bytes.clear();
                        Menu.turnCounter = turn-1;
                        System.out.println(turn + " turn");
                        if ( turn == ID) {
                            try {
                                System.out.println("Your turn : ");
                                Turn(socket,null, 0);
                                turn++;
                                WinCond.CheckWin(App.game);
                                if (Menu.gameOver){
                                    break;
                                }
                            } catch (Exception e) {
                                System.err.println(e.toString());
                            }
                        } if ( turn == nbPlayers) {
                            System.out.println("Server is playing...");
                            int column = socket.read(bytes);
                            bytes.clear();
                            System.out.println(column);
                            Menu.play(App.game, column);
                            turn = 1;
                        } 
                        // if (turn != ID && turn != nbPlayers){
                        //     System.out.println("oui");
                        //     int column = socket.read(bytes);
                        //     System.out.println(column);
                        //     Menu.play(App.game, column);
                        //     turn++;
                        // }
                    }
                } catch (IOException e) {
                    System.err.println(e.toString());
                    return;
                } if (Menu.gameOver) {
                    break;
                }
            }
        } catch (IOException e ){
            System.err.println(e.toString());
        }
    }
    public static void Turn(SocketChannel sChannel, SocketChannel sChannel2, int columnClient){
        try {
            if (columnClient == 0) {
                int column = Menu.getColumn(App.game);
                ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)column]);
                sChannel.write(bytes);
                if (sChannel2 != null) {
                    ByteBuffer bytes2 = ByteBuffer.wrap(new byte[(byte)column]);
                    sChannel2.write(bytes2);
                }
                Menu.play(App.game, column);
            } else {
                ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)columnClient]);
                sChannel.write(bytes);
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}