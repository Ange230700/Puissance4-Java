package puissance4;
import java.lang.String;
public class Grid
{
    public static int width;
    public static int height;
    public static String[][] grid;
    // for 2 players 8x6 grid, for 3 players 12x10 grid

    /**
     * This is the grid constructor bound to the number of player.
     * @param nbPlayers
     */
    public Grid(int nbPlayers)
    {
        grid(nbPlayers);
    }

    /**
     * This method creates a 2-dimensional array of strings, characters in our case,
     * whether it is 2 or 3 players.
     * It is used in the constructor.
     * @param nbPlayers
     */
    public void grid(int nbPlayers)
    {
        if(nbPlayers == 2)
        {
            width = 8;
            height = 6;
            grid = new String[height+2][width+2];
        }
        else if(nbPlayers == 3)
        {
            width = 12;
            height = 10;
            grid = new String[height+2][width+2];
        }
    }

     /**
      * This method allows us to build the grid.
      */
     public void BuildGrid(){
        for (int i=0; i<height+2;i++){
            for (int j=0; j<width+2;j++){
                if(  i == height || j==0 && i != height + 1|| j == width +1 && i != height + 1){
                    grid[i][j] = "#";
                }
                else if (i == height + 1 && j!=0 && j!=width +1)
                {
                    //add alphabet letters to the bottom of the grid
                    grid[i][j] = String.valueOf((char)(j+64));
                }
                else
                {
                    grid[i][j] = " ";
                }
            }
        }
    }

    /**
     * This method allows us to put a piece in a chosen column.
     * @param piece can be X, O or V.
     * @param column number to choose between 1 and 8 if it is 2 players, 
     * or between 1 and 12 otherwise.
     */
    public static void PutPiece(String piece, int column)
    {
        for(int i=height-1; i>=0; i--)
        {
            if(grid[i][column] == " ")
            {
                grid[i][column] = piece;
                break;
            }
        }
        DisplayGrid();
    }

    /**
     * This method allows us to show the grid.
     */
    public static void DisplayGrid ()
    {
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * This method checks if a column is full of pieces.
     * @param column number to choose between 1 and 8 if it is 2 players, 
     * or between 1 and 12 otherwise.
     * @return a boolean.
     */
    public static boolean CheckColumnFull(int column)
    {
        if(grid[0][column] != " ")
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}