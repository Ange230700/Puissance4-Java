package puissance4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Server {
    public static ArrayList<Client> clients = new ArrayList<Client>();
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
                Client client = new Client(clientSocket);
                clients.add(client);
                if (clients.size() == App.nbPlayers-1) {
                    for (Client _client : clients) {
                        PlayersNb(_client.clientSocket);
                    }
                    System.out.println("Game Starting");
                    App.game.DisplayGrid();
                    while(!Menu.gameOver) {
                        bytes.clear();
                        WinCond.CheckWin(App.game);
                        if (Menu.gameOver){
                            break;
                        }
                        for (Client playingClient : clients) {
                            YourTurn(playingClient.clientSocket);
                            int clientColumn = playingClient.clientSocket.read(bytes);
                            if (App.nbPlayers == 3){
                                if (playingClient == clients.get(0)) {
                                    Client.Turn(clients.get(1).clientSocket, clientColumn);
                                } else {
                                    Client.Turn(clients.get(0).clientSocket, clientColumn);
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
                        for (Client _client : clients) {
                            Client.Turn(_client.clientSocket, column);
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
