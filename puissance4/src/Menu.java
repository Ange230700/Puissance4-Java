import java.util.Scanner;

public class Menu {
    public static boolean gameOver = false;
    public static int chooseNbPlayers(){
        int nbPlayers = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players will play?");
        System.out.println("2 or 3?");
        nbPlayers = sc.nextInt();
        while(nbPlayers != 2 && nbPlayers != 3){
            System.out.println("Please enter 2 or 3");
            nbPlayers = sc.nextInt();
        }
        sc.close();
        return nbPlayers;
    }
    public static void play(){
        while(!gameOver){
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose a column");
        }
    }
}
