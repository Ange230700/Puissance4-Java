package puissance4;

import java.util.*;

public class PlayersChoice 
{  
    public static String piece;
    public static Scanner sc = new Scanner(System.in);

    /**
     * This method allows the players to choose the symbol they want to play with.
     * @param nbPlayers is the number of players involved in the game.
     */
    public static void choosePiece(int nbPlayers)
    {
        if (nbPlayers == 2) 
        {
            System.out.println("Player 1, choose your piece (X or O)");
            Menu.piece1 = sc.next().toUpperCase();
            while (!Menu.piece1.equals("X") && !Menu.piece1.equals("O")) 
            {
                System.out.println("Please enter X or O");
                Menu.piece1 = sc.nextLine().toUpperCase();
            }
            if (Menu.piece1.equals("X")) 
            {
                Menu.piece2 = "O";
            } 
            else 
            {
                Menu.piece2 = "X";
            }
            System.out.println("Player 1 will play with " + Menu.piece1);
            System.out.println("Player 2 will play with " + Menu.piece2);

        } 
        else if (nbPlayers == 3) 
        {
            System.out.println("Player 1, choose your piece (X, O or V)");
            Menu.piece1 = sc.nextLine().toUpperCase();
            while (!Menu.piece1.equals("X") && !Menu.piece1.equals("O") && !Menu.piece1.equals("V")) 
            {
                System.out.println("Please enter X, O or V");
                Menu.piece1 = sc.nextLine().toUpperCase();
            }
            System.out.println("Player 2, choose your piece (X, O or V)");

            Menu.piece2 = sc.nextLine().toUpperCase();
            while (!Menu.piece2.equals("X") && !Menu.piece2.equals("O") && !Menu.piece2.equals("V")) 
            {
                System.out.println("Please enter X, O or V");
                Menu.piece2 = sc.nextLine().toUpperCase();
            }
            if (Menu.piece1.equals("X") && Menu.piece2.equals("O")) 
            {
                Menu.piece3 = "V";
            } 
            else if (Menu.piece1.equals("X") && Menu.piece2.equals("V")) 
            {
                Menu.piece3 = "O";
            } 
            else if (Menu.piece1.equals("O") && Menu.piece2.equals("X")) 
            {
                Menu.piece3 = "V";
            } 
            else if (Menu.piece1.equals("O") && Menu.piece2.equals("V")) 
            {
                Menu.piece3 = "X";
            } 
            else if (Menu.piece1.equals("V") && Menu.piece2.equals("X")) 
            {
                Menu.piece3 = "O";
            } 
            else if (Menu.piece1.equals("V") && Menu.piece2.equals("O")) 
            {
                Menu.piece3 = "X";
            }
            System.out.println("Player 1 will play with " + Menu.piece1);
            System.out.println("Player 2 will play with " + Menu.piece2);
            System.out.println("Player 3 will play with " + Menu.piece3);
        }
    }

    /**
     * This method checks if the game is happening in local or online.
     */
    public static boolean isLocal() 
    {
        System.out.println("Do you want to play : \n 1. Online \n 2. Locally");
        int choice = sc.nextInt();
        while(choice != 1 && choice != 2)
        {
            System.out.println("Please enter 1 or 2");
            choice = sc.nextInt();
        } 
        if (choice == 1) 
        {
            return false;
        }
        return true;
    }

    /**
     * This method checks if the game is hosted or they have been connected to a server.
     */
    public static boolean isHost() 
    {
        System.out.println("Do you want to : \n 1. Host \n 2. Connect to server");
        int choice = sc.nextInt();
        while(choice != 1 && choice != 2)
        {
            System.out.println("Please enter 1 or 2");
            choice = sc.nextInt();
        } 
        if (choice == 1) 
        {
            return true;
        }
        return false;
    }
}
