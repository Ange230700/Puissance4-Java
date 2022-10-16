import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 4004));
            // ClientHandler client = new ClientHandler(socket, null);
            while(true) {
                int turn = new DataInputStream(socket.getInputStream()).readInt();
                if ( turn == 1) {
                    try {
                        DataOutputStream columnToServer = new DataOutputStream(socket.getOutputStream());
                        App.game.DisplayGrid();
                        System.out.println("Your turn : ");
                        int column = Menu.getColumn(App.game);
                        columnToServer.writeInt(column);
                        turn--;
                    } catch (Exception e) {
                        System.err.println(e.toString());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.toString());
            return;
        }
    }

}