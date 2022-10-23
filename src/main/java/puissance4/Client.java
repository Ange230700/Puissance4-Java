package puissance4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Salomé
 */
public class Client {
    /**
     * the client socket that will permit the server to talk to a specific client
     */
    public SocketChannel clientSocket;
    /**
     * a regex to recognise if the IP entered by the client seems legit
     */
    private static Pattern IPpattern = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    /**
     * Constructor that permit to link a socket to a client
     * @param socket
     */
    public Client(SocketChannel socket) {
        clientSocket = socket;
    }
    /**
     * the main function :
     *  -Connect a client to a server
     *  -Listen to the number of players to build the grid
     *  -Listen to a message, if it's a specific message, it means that it's client's turn so client will send what it has played to the server
     *  -else, it will take what column has been played and put it in the grid
     * @param args
     * @exception IOException if the socket can't open, connect or read anything
     */
    public static void main(String[] args) {
        ByteBuffer bytes = ByteBuffer.allocate(30);
        try {
            SocketChannel socket = SocketChannel.open();
            socket.connect(new InetSocketAddress(getIPAddress(), 4004));
            while (true) {
                try {
                    System.out.println("Waiting for player(s) to connect...");
                    int nbPlayers = socket.read(bytes);
                    Menu.nbPlayers = nbPlayers;
                    App.game.grid(nbPlayers);
                    App.game.BuildGrid();
                    App.game.DisplayGrid();
                    while(!Menu.gameOver) {
                        WinCond.CheckWin(App.game);
                        if (Menu.gameOver){
                            break;
                        }
                        bytes.clear();
                        int message = socket.read(bytes);
                        if (message == 14) {
                            int column = Menu.getColumn(App.game);
                            Turn(socket, column);
                            Menu.play(App.game, column);
                        } else {
                            Menu.play(App.game, message);
                        }
                        bytes.clear();
                    }
                } catch (IOException e) {
                    System.err.println(e.toString());
                    return;
                } if (Menu.gameOver) {
                    break;
                }
            }
        } catch (IOException e ){
            System.err.println(e.toString());
        }
    }
    /**
     * Send the turn data (column played) in a socket channel
     * @param sChannel the socket you want to write the data in
     * @param column   the column that has been played
     */
    public static void Turn(SocketChannel sChannel, int column){
        try {
            ByteBuffer bytes = ByteBuffer.wrap(new byte[(byte)column]);
            sChannel.write(bytes);
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
    /**
     * Prompt the client for an IP address, the client should put the server's IP
     * @return the IP address
     */
    public static String getIPAddress() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an valid IP address");
        String IP = sc.nextLine();
        while (!IPpattern.matcher(IP).matches()) {
            getIPAddress();
        }
        return IP;
    }
}