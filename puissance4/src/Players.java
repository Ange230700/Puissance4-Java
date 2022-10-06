import java.util.*;
public class Players {  
    public static String piece;
    public static void choosePiece(int nbPlayers){
        Scanner sc = new Scanner(System.in);
        if (nbPlayers == 2) {
            System.out.println("Player 1, choose your piece (X or O)");
            Menu.piece1 = sc.nextLine().toUpperCase();
            while (!Menu.piece1.equals("X") && !Menu.piece1.equals("O")) {
                System.out.println("Please enter X or O");
                Menu.piece1 = sc.nextLine().toUpperCase();
            }
            if (Menu.piece1.equals("X")) {
                Menu.piece2 = "O";
            } else {
                Menu.piece2 = "X";
            }
            System.out.println("Player 1 will play with " + Menu.piece1);
            System.out.println("Player 2 will play with " + Menu.piece2);

        } else if (nbPlayers == 3) {
            System.out.println("Player 1, choose your piece (X, O or V)");
            Menu.piece1 = sc.nextLine().toUpperCase();
            while (!Menu.piece1.equals("X") && !Menu.piece1.equals("O") && !Menu.piece1.equals("V")) {
                System.out.println("Please enter X, O or V");
                Menu.piece1 = sc.nextLine().toUpperCase();
            }
            System.out.println("Player 2, choose your piece (X, O or V)");

            Menu.piece2 = sc.nextLine().toUpperCase();
            while (!Menu.piece2.equals("X") && !Menu.piece2.equals("O") && !Menu.piece2.equals("V")) {
                System.out.println("Please enter X, O or V");
                Menu.piece2 = sc.nextLine().toUpperCase();
            }
            if (Menu.piece1.equals("X") && Menu.piece2.equals("O")) {
                Menu.piece3 = "V";
            } else if (Menu.piece1.equals("X") && Menu.piece2.equals("V")) {
                Menu.piece3 = "O";
            } else if (Menu.piece1.equals("O") && Menu.piece2.equals("X")) {
                Menu.piece3 = "V";
            } else if (Menu.piece1.equals("O") && Menu.piece2.equals("V")) {
                Menu.piece3 = "X";
            } else if (Menu.piece1.equals("V") && Menu.piece2.equals("X")) {
                Menu.piece3 = "O";
            } else if (Menu.piece1.equals("V") && Menu.piece2.equals("O")) {
                Menu.piece3 = "X";
            }
            System.out.println("Player 1 will play with " + Menu.piece1);
            System.out.println("Player 2 will play with " + Menu.piece2);
            System.out.println("Player 3 will play with " + Menu.piece3);
        }
    }
    }

        
