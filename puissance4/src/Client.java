import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        ByteBuffer bytes = ByteBuffer.allocate(30);
        try {
            SocketChannel socket = SocketChannel.open();
            socket.connect(new InetSocketAddress("localhost", 4004));
            while (true) {
                try {
                    System.out.println("Waiting for player(s) to connect...");
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
                        int message = socket.read(bytes);
                        if (message == 14) {
                            int column = Menu.getColumn(App.game);
                            Turn(socket, null, column);
                            Menu.play(App.game, column);
                        } else {
                            Menu.play(App.game, message);
                        }
                        bytes.clear();
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
    public static void Turn(SocketChannel sChannel, SocketChannel sChannel2, int column){
        try {
            ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)column]);
            sChannel.write(bytes);
            if (sChannel2 != null) {
                ByteBuffer bytes2 = ByteBuffer.wrap(new byte[(byte)column]);
                sChannel2.write(bytes2);
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}