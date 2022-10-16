import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    public Grid grid = App.game;
    public static int turn = 1;
    public static void main(String[] args) {
        Server server = new Server();
        server.launch();
    }
    public void launch() {
        try {
            ServerSocket sS = new ServerSocket(4004);
            while(true) {
                Socket clientSocket = sS.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                if (clients.size() == App.nbPlayers-1) {
                    System.out.println("Game Starting");
                    App.game.DisplayGrid();
                    while(true) {
                        for (ClientHandler playingClient : clients) {
                            DataOutputStream giveTurn = new DataOutputStream(clientSocket.getOutputStream());
                            giveTurn.writeInt(turn);
                            if (turn == playingClient.ID) {
                                DataInputStream clientColumn = new DataInputStream(client.socket.getInputStream());
                                Menu.play(App.game, clientColumn.readInt());
                                turn++;
                                System.out.println(turn + "ouioui");
                            } else {
                                Menu.play(App.game, Menu.getColumn(grid));
                                turn--;
                                System.out.println(turn + "oui");
                            }
                        }
                        if(Menu.gameOver) {
                            break;
                        }
                    }
                }

            }
         } catch(IOException e) {
            System.err.println(e.toString());
        }
    }
}
