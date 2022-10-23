package puissance4;

import java.util.Scanner;

public class Menu 
{
    /**
     * This property tells if the game is over or not.
     */
    public static boolean gameOver = false;
    /**
     * This property tells if it is a draw or not.
     */
    public static boolean notADraw = false;

    public static String piece1 = "X";
    public static String piece2 = "O";
    public static String piece3 = "V";
    public static int nbPlayers;
    public static int turnCounter = 0;

    /**
     * This method allows them to choose the number of player.
     * @return an integer representing the number.
     */
    public static int chooseNbPlayers()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players will play?");
        System.out.println("2 or 3?");
        nbPlayers = sc.nextInt();
        while(nbPlayers != 2 && nbPlayers != 3)
        {
            System.out.println("Please enter 2 or 3");
            nbPlayers = sc.nextInt();
        }
        // sc.close();
        return nbPlayers;
    }

    /**
     * This method gives to the contestants the right to play on their turn.
     * @param grid on which all the operations are made.
     * @param column is an integer to choose in a certain range according to the number of players
     * in the game.
     */
    public static void play(Grid grid, int column)
    {
        if (nbPlayers == 2)
        {
            if (turnCounter % 2 == 0)
            {
                grid.PutPiece(piece1, column);
                turnCounter++;
            } 
            else
            {
                grid.PutPiece(piece2, column);
                turnCounter--;
            }
        } 
        else if (nbPlayers == 3)
        {
            if (turnCounter % 3 == 0)
            {
                grid.PutPiece(piece1, column);
                turnCounter++;
            } 
            else if (turnCounter % 3 == 1)
            {
                grid.PutPiece(piece2, column);
                turnCounter++;
            } 
            else 
            {
                grid.PutPiece(piece3, column);
                turnCounter-=2;
            }
        }
    }
    
    /**
     * This method gets the column number chosen.
     * @param grid
     * @return the integer.
     */
    public static int getColumn(Grid grid) 
    {   
        Scanner sc = new Scanner(System.in);
        Menu.WhoPlays();
        System.out.println("Choose a column");
        String columnStr = sc.nextLine();
        while (columnStr == null || columnStr.isEmpty())
        {
            Menu.WhoPlays();
            System.out.println("Please enter a column");
            columnStr = sc.nextLine();
        }
        int column = Menu.StringToInt(columnStr);
        while(column < 1 || column > grid.width)
        {
            if (nbPlayers == 2)
            {
                Menu.WhoPlays();
                System.out.println("Please select a column between A and H");
                columnStr = sc.nextLine();
                column = StringToInt(columnStr);
            } 
            else if (nbPlayers == 3)
            {
                Menu.WhoPlays();
                System.out.println("Please select a column between A and L" );
                columnStr = sc.nextLine();
                column = StringToInt(columnStr);
            }
        }
        // sc.close();
        return column;
    }

    /**
     * This method converts the character of the column chosen into an integer.
     * @param str
     * @return
     */
    public static int StringToInt(String str) 
    {

        String result = "";
        if (str == null || str.isEmpty()) 
        {
            return 0;
        }

        for (int i = 0; i < str.length(); i++) 
        {

            char ch = str.charAt(i);

            if (Character.isLetter(ch)) 
            {
                char initialCharacter = Character.isUpperCase(ch) ? 'A' : 'a';
                result = result.concat(String.valueOf((ch - initialCharacter + 1)));
            } 
            else result = result + ch;
        }

        return Integer.parseInt(result);
    }

    /**
     * This method identifies who is playing.
     */
    public static void WhoPlays()
    {
        switch (nbPlayers)
        {
            case 2:
                if (turnCounter % 2 == 0)
                {
                    System.out.print("Player 1 plays " + "("+ piece1 + ")\n");
                } 
                else 
                {
                    System.out.print("Player 2 plays " + "("+ piece2 + ")\n");
                }
                break;
            case 3:
                if (turnCounter % 3 == 0)
                {
                    System.out.print("Player 1 plays " + "("+ piece1 + ")\n");
                } 
                else if (turnCounter % 3 == 1)
                {
                    System.out.print("Player 2 plays " + "("+ piece2 + ")\n");
                } 
                else 
                {
                    System.out.print("Player 3 plays " + "("+ piece3 + ")\n");
                }
                break;
        }
    }
}
