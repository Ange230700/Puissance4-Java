package puissance4;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler {
    public Socket socket = null;
    private Server server = null;
    public int ID = 1;

    public ClientHandler(Socket socket, Server server){
        this.socket = socket;
        this.server = server;
    }

    public void Listen() {
        if ( Server.turn == ID) {
            try {
                DataOutputStream columnToServer = new DataOutputStream(socket.getOutputStream());
                server.grid.DisplayGrid();
                System.out.println("Your turn : ");
                int column = Menu.getColumn(server.grid);
                columnToServer.writeInt(column);
                server.turn++;
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }
}
