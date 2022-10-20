package puissance4;

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
                while(!Menu.gameOver) {
                    WinCond.CheckWin(App.game);
                    if (Menu.gameOver){
                        break;
                    }
                    DataInputStream serverData = new DataInputStream(socket.getInputStream());
                    int turn = serverData.readInt();
                    App.game.DisplayGrid();
                    if ( turn == 1) {
                        try {
                            DataOutputStream columnToServer = new DataOutputStream(socket.getOutputStream());
                            System.out.println("Your turn : ");
                            int column = Menu.getColumn(App.game);
                            columnToServer.writeInt(column);
                            Menu.play(App.game, column);
                            turn--;
                        } catch (Exception e) {
                            System.err.println(e.toString());
                        }
                    } else if (turn == 0 ) {
                        System.out.println("Player 1 is playing...");
                        int column = serverData.readInt();
                        System.out.println(column);
                        Menu.play(App.game, column);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.toString());
            return;
        }
    }

}