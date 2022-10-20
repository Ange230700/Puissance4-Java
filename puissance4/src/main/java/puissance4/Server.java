package puissance4;

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
                    while(!Menu.gameOver) {
                        WinCond.CheckWin(App.game);
                        if (Menu.gameOver){
                            break;
                        }
                        for (ClientHandler playingClient : clients) {
                            DataOutputStream dataToClient = new DataOutputStream(clientSocket.getOutputStream());
                            dataToClient.writeInt(turn);
                            dataToClient.flush();
                            if (turn == playingClient.ID) {
                                System.out.println("Player 2 is playing...");
                                DataInputStream clientColumn = new DataInputStream(client.socket.getInputStream());
                                Menu.play(App.game, clientColumn.readInt());
                                turn--;
                            } else {
                                int column = Menu.getColumn(grid);
                                Menu.play(App.game, column);
                                dataToClient.writeInt(column);
                                turn++;
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
