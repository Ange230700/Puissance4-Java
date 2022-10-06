import java.util.Scanner;

public class Menu {
    public static boolean gameOver = false;
    public static boolean notADraw = false;
    public static String piece1;
    public static String piece2;
    public static String piece3;
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
    public static void play(){
        while(!gameOver){
            GameManager.CheckWin();
            if (gameOver){
                break;
            }
            Scanner sc = new Scanner(System.in);
            WhoPlays(nbPlayers, turnCounter);
            System.out.println("Choose a column");
            String columnStr = sc.nextLine();
            while (columnStr == null || columnStr.isEmpty()){
                WhoPlays(nbPlayers, turnCounter);
                System.out.println("Please enter a column");
                columnStr = sc.nextLine();
            }
            int column = StringToInt(columnStr);
            while(column < 1 || column > Grid.width){
                if (nbPlayers == 2){
                    WhoPlays(nbPlayers, turnCounter);
                    System.out.println("Please select a column between A and H");
                } else if (nbPlayers == 3){
                    WhoPlays(nbPlayers, turnCounter);
                    System.out.println("Please select a column between A and L" );
                }
                columnStr = sc.nextLine();
                column = StringToInt(columnStr);
            }
            if (nbPlayers == 2){
                if (turnCounter % 2 == 0){
                    Grid.PutPiece(piece1, column);
                    turnCounter++;
                } else {
                    Grid.PutPiece(piece2, column);
                    turnCounter++;
                }
            } else if (nbPlayers == 3){
                if (turnCounter % 3 == 0){
                    Grid.PutPiece(piece1, column);
                    turnCounter++;
                } else if (turnCounter % 3 == 1){
                    Grid.PutPiece(piece2, column);
                    turnCounter++;
                } else {
                    Grid.PutPiece(piece3, column);
                    turnCounter++;
                }
            }
        }
    }
    public static int StringToInt(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                char initialCharacter = Character.isUpperCase(ch) ? 'A' : 'a';
                result = result.concat(String.valueOf((ch - initialCharacter + 1)));
            } else result = result + ch;
        }

        return Integer.parseInt(result);
    }
        public static void WhoPlays(int nbPlayers, int turnCounter){
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

        }
    }
