import java.nio.channels.SocketChannel;

public class ClientHandler {
    public SocketChannel socket = null;
    public int ID = 0;

    public ClientHandler(SocketChannel socket, int ID){
        this.socket = socket;
        this.ID = ID;
    }

}
