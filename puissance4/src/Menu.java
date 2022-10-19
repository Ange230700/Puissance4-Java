import java.util.Scanner;

public class Menu {
    public static boolean gameOver = false;
    public static boolean notADraw = false;
    public static String piece1 = "X";
    public static String piece2 = "O";
    public static String piece3 = "V";
    public static int nbPlayers;
    public static int turnCounter = 0;

    public static int chooseNbPlayers(){
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

    public static void play(Grid grid, int column){
            if (nbPlayers == 2){
                if (turnCounter % 2 == 0){
                    grid.PutPiece(piece1, column);
                    turnCounter++;
                } else {
                    grid.PutPiece(piece2, column);
                    turnCounter--;
                }
            } else if (nbPlayers == 3){
                if (turnCounter % 3 == 0){
                    grid.PutPiece(piece1, column);
                    turnCounter++;
                } else if (turnCounter % 3 == 1){
                    grid.PutPiece(piece2, column);
                    turnCounter++;
                } else {
                    grid.PutPiece(piece3, column);
                    turnCounter-=2;
                }
            }
        }

    public static int getColumn(Grid grid) {   
        Scanner sc = new Scanner(System.in);
            Menu.WhoPlays();
            System.out.println("Choose a column");
            String columnStr = sc.nextLine();
            while (columnStr == null || columnStr.isEmpty()){
                Menu.WhoPlays();
                System.out.println("Please enter a column");
                columnStr = sc.nextLine();
            }
            int column = Menu.StringToInt(columnStr);
            while(column < 1 || column > grid.width){
                if (nbPlayers == 2){
                    Menu.WhoPlays();
                    System.out.println("Please select a column between A and H");
                    columnStr = sc.nextLine();
                    column = StringToInt(columnStr);
                } else if (nbPlayers == 3){
                    Menu.WhoPlays();
                    System.out.println("Please select a column between A and L" );
                    columnStr = sc.nextLine();
                    column = StringToInt(columnStr);
                }
                // columnStr = sc.nextLine();
                // column = StringToInt(columnStr);
            }
            return column;
    }

    public static int StringToInt(String str) {

        String result = "";
        if (str == null || str.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                char initialCharacter = Character.isUpperCase(ch) ? 'A' : 'a';
                result = result.concat(String.valueOf((ch - initialCharacter + 1)));
            } else result = result + ch;
        }

        return Integer.parseInt(result);
    }

<<<<<<< HEAD
        } 
=======
    public static void WhoPlays(){
        switch (nbPlayers){
            case 2:
                if (turnCounter % 2 == 0){
                    System.out.println("Player 1 plays " + "("+ piece1 + ")");
                } else {
                    System.out.println("Player 2 plays " + "("+ piece2 + ")");
                }
                break;
            case 3:
                if (turnCounter % 3 == 0){
                    System.out.println("Player 1 plays " + "("+ piece1 + ")");
                } else if (turnCounter % 3 == 1){
                    System.out.println("Player 2 plays " + "("+ piece2 + ")");
                } else {
                    System.out.println("Player 3 plays " + "("+ piece3 + ")");
                }
                break;
        }
>>>>>>> 3eead19822b5971d0ea6fe65c2b5c725f5b7b90e
    }
}
