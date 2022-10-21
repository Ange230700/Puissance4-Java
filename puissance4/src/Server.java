import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Server {
    public static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    public Grid grid = App.game;
    public static int turn = 1;
    public static int ID = 1;
    public static void main(String[] args) {
        Server server = new Server();
        server.launch();
    }
    public void launch() {
        ByteBuffer bytes = ByteBuffer.allocate(9);
        try {
            ServerSocketChannel ssChan = ServerSocketChannel.open();
            ssChan.bind(new InetSocketAddress(4004));
            while(true) {
                SocketChannel clientSocket = ssChan.accept();
                ClientHandler client = new ClientHandler(clientSocket, ID);
                clients.add(client);
                ID++;
                ID(clientSocket);
                PlayersNb(clientSocket);
                if (clients.size() == App.nbPlayers-1) {
                    System.out.println("Game Starting");
                    App.game.DisplayGrid();
                    while(!Menu.gameOver) {
                        bytes.clear();
                        WinCond.CheckWin(App.game);
                        if (Menu.gameOver){
                            break;
                        }
                        for (ClientHandler playingClient : clients) {
                            if (turn == playingClient.ID) {
                                System.out.println("Another player is playing...");
                                YourTurn(clientSocket);
                                int clientColumn = clientSocket.read(bytes);
                                Menu.play(App.game, clientColumn);
                                turn++;
                                WinCond.CheckWin(App.game);
                                if (Menu.gameOver){
                                    break;
                                }
                            } if (turn == clients.size()+1) {
                                break;
                            }
                        }
                        if (turn == clients.size()+1 && !Menu.gameOver){
                            Client.Turn(clientSocket);
                            turn=1;
                        }
                    }
                }

            }
         } catch(IOException e) {
            System.err.println(e.toString());
        }
    }
    public static void YourTurn(SocketChannel sChannel) {
        try {
            ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)turn]);
            sChannel.write(bytes);
        } catch (IOException e){
            System.err.println(e.toString());
        }
    }
    public static void ID(SocketChannel sChannel) {
        try {
            ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)ID-1]);
            sChannel.write(bytes);
        } catch (IOException e){
            System.err.println(e.toString());
        }
    }
    public static void PlayersNb(SocketChannel sChannel) {
        try {
            ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)App.nbPlayers]);
            sChannel.write(bytes);
        } catch (IOException e){
            System.err.println(e.toString());
        }
    }
}
