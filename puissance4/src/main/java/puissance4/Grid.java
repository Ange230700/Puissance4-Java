package puissance4;
import java.lang.String;
public class Grid
{
    public int width;
    public int height;
    /**
     * This property is a 2D strings'array. 
     */
    public static String[][] grid;

    public Grid()
    {
        width = 8;
        height = 6;
        grid = new String[height+2][width+2];
    }

    /**
     * This method allocates memory for the construction of the game grid.
     * @param nbPlayers : for 2 players 8x6 grid, for 3 players 12x10 grid
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
    * This method shapes the grid.
    */
    public void BuildGrid()
    {
        for (int i=0; i<height+2;i++)
        {
            for (int j=0; j<width+2;j++)
            {
                if(  i == height || j==0 && i != height + 1|| j == width +1 && i != height + 1)
                {
                    grid[i][j] = "#";
                }
                else if (i == height + 1 && j!=0 && j!=width +1)
                {
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
     * This method puts a piece in a chosen column.
     * @param piece is either X, O or V.
     * @param column is an integer to choose in a certain range according to the number of players
     * in the game. 
     */
    public void PutPiece(String piece, int column)
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
     * This method displays the game state.
     */
    public void DisplayGrid ()
    {
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
    }

    /**
     * To check if a column is full.
     * @param column represents the column index. 
     * @return
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