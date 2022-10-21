import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    static int ID = 10;
    public static void main(String[] args) {
        ByteBuffer bytes = ByteBuffer.allocate(10);
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
                        Menu.turnCounter = turn-1;
                        System.out.println(turn + " turn");
                        if ( turn == ID) {
                            try {
                                System.out.println("Your turn : ");
                                Turn(socket);
                                turn++;
                                WinCond.CheckWin(App.game);
                                if (Menu.gameOver){
                                    break;
                                }
                            } catch (Exception e) {
                                System.err.println(e.toString());
                            }
                        } if ( turn == nbPlayers) {
                            System.out.println("Someone else is playing...");
                            int column = socket.read(bytes);
                            Menu.play(App.game, column);
                            turn--;
                        }
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
    public static void Turn(SocketChannel sChannel){
        try {
            int column = Menu.getColumn(App.game);
            ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)column]);
            sChannel.write(bytes);
            Menu.play(App.game, column);
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}