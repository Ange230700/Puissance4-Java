package puissance4;

import java.util.Scanner;
import java.nio.channels.SocketChannel;
import java.nio.channels.ServerSocketChannel;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class GameMode {
    public static int playMode;
    public static void choosePlayMode(){ //play on local or network
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play on local or network?");
        System.out.println(" Press 1 for local, 2 for network");
        playMode = sc.nextInt();
        while(playMode != 1 && playMode != 2)
        {
            System.out.println("Please enter 1 or 2");
            playMode = sc.nextInt();
        }
        if (playMode == 1)
        {
            System.out.println("You chose to play on local");
        }
        else if (playMode == 2)
        {
            System.out.println("You chose to play on network");
        }
    }
    public static void playOnNetwork(){
       //use same method as in Menu.java but instead of using System.out.println, use SocketChannel.write(ByteBuffer.wrap("".getBytes())); and instead of using Scanner,
       // use SocketChannel.read(ByteBuffer.wrap("".getBytes()));
       while (!Menu.gameOver){
            WinCond.CheckWin();
            if (Menu.gameOver){
                break;
            }
        }
    }
           

}
