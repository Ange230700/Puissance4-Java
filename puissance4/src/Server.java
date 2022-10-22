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
        ByteBuffer bytes = ByteBuffer.allocate(30);
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
                    for (ClientHandler _client : clients) {
                        PlayersNb(_client.socket);
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
                            YourTurn(playingClient.socket);
                            int clientColumn = playingClient.socket.read(bytes);
                            if (App.nbPlayers == 3){
                                if (playingClient == clients.get(0)) {
                                    Client.Turn(clients.get(1).socket, null, clientColumn);
                                } else {
                                    Client.Turn(clients.get(0).socket, null, clientColumn);
                                }
                            }
                            Menu.play(App.game, clientColumn);
                            WinCond.CheckWin(App.game);
                            if (Menu.gameOver){
                                break;
                            }
                        }
                        if (Menu.gameOver){
                            break;
                        }
                        int column = Menu.getColumn(App.game);
                        if (App.nbPlayers == 3) {
                            Client.Turn(clients.get(0).socket, clients.get(1).socket, column);
                        } else {
                            Client.Turn(clients.get(0).socket, null, column);
                        }
                        Menu.play(App.game, column);
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
            ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)14]);
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
