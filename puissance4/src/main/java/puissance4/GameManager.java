package puissance4;

public class GameManager
{
   public static void CheckGrid(Grid grid)
   {
        //check if the grid is full
        int counter = 0;
        for (int i=0; i<grid.height;i++)
        {
            for (int j=1; j<grid.width+1;j++)
            {
                if(Grid.grid[i][j] != " ")
                {
                    counter++;
                }
            }
        }
        if(counter == grid.width*grid.height)
        {
            Menu.gameOver = true;
            if (Menu.notADraw == false && Menu.gameOver == true)
            {
                System.out.print("Game Over!\nThe grid is full. It's a draw.\n");
            }
        }
    }
    public static void CheckLigns(Grid grid)
    {
        for (int i=0; i<grid.height;i++)
        {
            for (int j=1; j<grid.width+1;j++)
            {
                if(Grid.grid[i][j] == Grid.grid[i][j+1] && Grid.grid[i][j] == Grid.grid[i][j+2] && Grid.grid[i][j] == Grid.grid[i][j+3] && Grid.grid[i][j] != " ")
                {
                    if (Grid.grid[i][j] == Menu.piece1)
                    {
                        System.out.print("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces horizontally.\n");
                    }
                    else if (Grid.grid[i][j] == Menu.piece2)
                    {
                        System.out.print("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces horizontally.\n");
                    }
                    else if (Grid.grid[i][j] == Menu.piece3)
                    {
                        System.out.print("Game Over!\nPlayer 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces horizontally.\n");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckColumns(Grid grid)
    {
        for (int i=0; i<grid.height;i++)
        {
            for (int j=1; j<grid.width+1;j++)
            {
                if(Grid.grid[i][j] == Grid.grid[i+1][j] && Grid.grid[i][j] == Grid.grid[i+2][j] && Grid.grid[i][j] == Grid.grid[i+3][j] && Grid.grid[i][j] != " ")
                {
                    if (Grid.grid[i][j] == Menu.piece1)
                    {
                        System.out.println("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces vertically.\n");
                    }
                    else if (Grid.grid[i][j] == Menu.piece2)
                    {
                        System.out.println("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces vertically.\n");
                    }
                    else if (Grid.grid[i][j] == Menu.piece3)
                    {  
                        System.out.println("Game Over!\nPlayer 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces vertically.\n");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    } 
    public static void CheckDiagonals(Grid grid)
    {
        for (int i=0; i<grid.height;i++)
        {
            for (int j=1; j<grid.width+1;j++)
            {
                if(Grid.grid[i][j] == Grid.grid[i+1][j+1] && Grid.grid[i][j] == Grid.grid[i+2][j+2] && Grid.grid[i][j] == Grid.grid[i+3][j+3] && Grid.grid[i][j] != " ")
                {
                    System.out.println("Game Over");
                    if (Grid.grid[i][j] == Menu.piece1)
                    {
                        System.out.println("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces diagonally.\n");
                    }
                    else if (Grid.grid[i][j] == Menu.piece2)
                    {
                        System.out.println("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces diagonally.\n");
                    }
                    else if (Grid.grid[i][j] == Menu.piece3)
                    {
                        System.out.println("Game Over!\nPlayer 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces diagonally.\n");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckDiagonals2(Grid grid)
    {
        for (int i=0; i<grid.height;i++)
        {
            for (int j=1; j<grid.width+1;j++)
            {
                if(Grid.grid[i][j] == Grid.grid[i+1][j-1] && Grid.grid[i][j] == Grid.grid[i+2][j-2] && Grid.grid[i][j] == Grid.grid[i+3][j-3] && Grid.grid[i][j] != " ")
                {
                    System.out.println("Game Over");
                    if (Grid.grid[i][j] == Menu.piece1)
                    {
                        System.out.println("Player 1 wins "+ "(" + Menu.piece1  + ")" + " by aligning 4 pieces diagonally");
                    }
                    else if (Grid.grid[i][j] == Menu.piece2)
                    {
                        System.out.println("Player 2 wins" + "(" + Menu.piece2  + ")" + " by aligning 4 pieces diagonally");
                    }
                    else if (Grid.grid[i][j] == Menu.piece3)
                    {
                        System.out.println("Game Over!\nPlayer 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces diagonally.\n");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckWin(Grid grid)
    {
        CheckLigns(grid);
        CheckColumns(grid);
        CheckDiagonals(grid);
        CheckDiagonals2(grid);
        CheckGrid(grid);
    }
}