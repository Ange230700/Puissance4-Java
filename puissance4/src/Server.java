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
        ByteBuffer bytes = ByteBuffer.allocate(20);
        try {
            ServerSocketChannel ssChan = ServerSocketChannel.open();
            ssChan.bind(new InetSocketAddress(4004));
            System.out.println("Waiting for player(s) to connect...");
            while(true) {
                SocketChannel clientSocket = ssChan.accept();
                ClientHandler client = new ClientHandler(clientSocket, ID);
                clients.add(client);
                ID++;
                if (clients.size() == App.nbPlayers-1) {
                    for (ClientHandler playingClient : clients) {
                        ID(playingClient.socket, playingClient.ID);
                        PlayersNb(playingClient.socket);
                    }
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
                                YourTurn(playingClient.socket);
                                System.out.println("Another player is playing...");
                                int clientColumn = playingClient.socket.read(bytes);
                                bytes.clear();
                                Menu.play(App.game, clientColumn);
                                WinCond.CheckWin(App.game);
                                turn++;
                                System.out.println(turn +" turn après client");
                                if (Menu.gameOver){
                                    break;
                                }
                            } 
                            // else {
                            //     YourTurn(playingClient.socket);
                            //     Client.Turn(playingClient.socket, null, 1);
                            // }
                                // break;
                            // }
                        }
                        if (turn == clients.size()+1 && !Menu.gameOver){
                            if (App.nbPlayers == 3) {
                                Client.Turn(clients.get(0).socket, clients.get(1).socket, 0);
                            } else {
                                Client.Turn(clients.get(0).socket, null, 0);
                            }
                            turn=1;
                        }
                    }
                }
                if (Menu.gameOver) {
                    break;
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
    public static void ID(SocketChannel sChannel, int clientID) {
        try {
            ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)clientID]);
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
