import java.util.Scanner;

public class Menu {
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
        return nbPlayers;
    }
}
