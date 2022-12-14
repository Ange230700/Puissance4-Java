package puissance4;

public class WinCond {
    public static void Checkgrid(Grid grid){
        //check if the grid is full
        int counter = 0;
        for (int i=0; i<grid.height;i++){
            for (int j=1; j<grid.width+1;j++){
                if(grid.grid[i][j] != " "){
                    counter++;
                }
            }
        }
        if(counter == grid.width*grid.height){
            System.out.println("The grid is full");
            Menu.gameOver = true;
            if (Menu.notADraw == false && Menu.gameOver == true){
                System.out.println("It's a draw");
            }
        }
    }
    public static void CheckLigns(Grid grid){
        for (int i=0; i<grid.height;i++){
            for (int j=1; j<grid.width+1;j++){
                if(grid.grid[i][j] == grid.grid[i][j+1] && grid.grid[i][j] == grid.grid[i][j+2] && grid.grid[i][j] == grid.grid[i][j+3] && grid.grid[i][j] != " "){
                    System.out.println("Game Over");
                    if (grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + "by aligning 4 pieces horizontally");
                    }else if (grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + "by aligning 4 pieces horizontally");
                    }else if (grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + "by aligning 4 pieces horizontally");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckColumns(Grid grid){
        for (int i=0; i<grid.height;i++){
            for (int j=1; j<grid.width+1;j++){
                if(grid.grid[i][j] == grid.grid[i+1][j] && grid.grid[i][j] == grid.grid[i+2][j] && grid.grid[i][j] == grid.grid[i+3][j] && grid.grid[i][j] != " "){
                    System.out.println("Game Over");
                    if (grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + "by aligning 4 pieces vertically");
                    }else if (grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + "by aligning 4 pieces vertically");
                    }else if (grid.grid[i][j] == Menu.piece3){  
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + "by aligning 4 pieces vertically");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    } 
    public static void CheckDiagonals(Grid grid){
        for (int i=0; i<grid.height;i++){
            for (int j=1; j<grid.width+1;j++){
                if(grid.grid[i][j] == grid.grid[i+1][j+1] && grid.grid[i][j] == grid.grid[i+2][j+2] && grid.grid[i][j] == grid.grid[i+3][j+3] && grid.grid[i][j] != " "){
                    System.out.println("Game Over");
                    if (grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + "by aligning 4 pieces diagonally");
                    }else if (grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + "by aligning 4 pieces diagonally");
                    }else if (grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + "by aligning 4 pieces diagonally");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckDiagonals2(Grid grid){
        for (int i=0; i<grid.height;i++){
            for (int j=1; j<grid.width+1;j++){
                if(grid.grid[i][j] == grid.grid[i+1][j-1] && grid.grid[i][j] == grid.grid[i+2][j-2] && grid.grid[i][j] == grid.grid[i+3][j-3] && grid.grid[i][j] != " "){
                    System.out.println("Game Over");
                    if (grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins "+ "(" + Menu.piece1  + ")" + "by aligning 4 pieces diagonally");
                    }else if (grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins" + "(" + Menu.piece2  + ")" + "by aligning 4 pieces diagonally");
                    }else if (grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins" + "(" + Menu.piece3  + ")" + "by aligning 4 pieces diagonally");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckWin(Grid grid){
        CheckLigns(grid);
        CheckColumns(grid);
        CheckDiagonals(grid);
        CheckDiagonals2(grid);
        Checkgrid(grid);
    }
}
