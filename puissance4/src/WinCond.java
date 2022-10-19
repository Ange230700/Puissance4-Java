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
<<<<<<< HEAD:puissance4/src/GameManager.java
                    if (Grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces horizontally");
                    }else if (Grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces horizontally");
                    }else if (Grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces horizontally");
=======
                    if (grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + "by aligning 4 pieces horizontally");
                    }else if (grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + "by aligning 4 pieces horizontally");
                    }else if (grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + "by aligning 4 pieces horizontally");
>>>>>>> 3eead19822b5971d0ea6fe65c2b5c725f5b7b90e:puissance4/src/WinCond.java
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
<<<<<<< HEAD:puissance4/src/GameManager.java
                    if (Grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces vertically");
                    }else if (Grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces vertically");
                    }else if (Grid.grid[i][j] == Menu.piece3){  
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces vertically");
=======
                    if (grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + "by aligning 4 pieces vertically");
                    }else if (grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + "by aligning 4 pieces vertically");
                    }else if (grid.grid[i][j] == Menu.piece3){  
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + "by aligning 4 pieces vertically");
>>>>>>> 3eead19822b5971d0ea6fe65c2b5c725f5b7b90e:puissance4/src/WinCond.java
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
<<<<<<< HEAD:puissance4/src/GameManager.java
                    if (Grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces diagonally");
                    }else if (Grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces diagonally");
                    }else if (Grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces diagonally");
=======
                    if (grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")" + "by aligning 4 pieces diagonally");
                    }else if (grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")" + "by aligning 4 pieces diagonally");
                    }else if (grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")" + "by aligning 4 pieces diagonally");
>>>>>>> 3eead19822b5971d0ea6fe65c2b5c725f5b7b90e:puissance4/src/WinCond.java
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
<<<<<<< HEAD:puissance4/src/GameManager.java
                    if (Grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins "+ "(" + Menu.piece1  + ")" + " by aligning 4 pieces diagonally");
                    }else if (Grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins" + "(" + Menu.piece2  + ")" + " by aligning 4 pieces diagonally");
                    }else if (Grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins" + "(" + Menu.piece3  + ")" + " by aligning 4 pieces diagonally");
=======
                    if (grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins "+ "(" + Menu.piece1  + ")" + "by aligning 4 pieces diagonally");
                    }else if (grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins" + "(" + Menu.piece2  + ")" + "by aligning 4 pieces diagonally");
                    }else if (grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins" + "(" + Menu.piece3  + ")" + "by aligning 4 pieces diagonally");
>>>>>>> 3eead19822b5971d0ea6fe65c2b5c725f5b7b90e:puissance4/src/WinCond.java
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
