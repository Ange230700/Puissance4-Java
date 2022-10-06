public class GameManager {
   public static void CheckGrid(){
        //check if the grid is full
        int counter = 0;
        for (int i=0; i<Grid.height;i++){
            for (int j=1; j<Grid.width+1;j++){
                if(Grid.grid[i][j] != " "){
                    counter++;
                }
            }
        }
        if(counter == Grid.width*Grid.height){
            System.out.println("The grid is full");
            Menu.gameOver = true;
            if (Menu.notADraw == false && Menu.gameOver == true){
                System.out.println("It's a draw");
            }
        }
    }
    public static void CheckLigns(){
        for (int i=0; i<Grid.height;i++){
            for (int j=1; j<Grid.width+1;j++){
                if(Grid.grid[i][j] == Grid.grid[i][j+1] && Grid.grid[i][j] == Grid.grid[i][j+2] && Grid.grid[i][j] == Grid.grid[i][j+3] && Grid.grid[i][j] != " "){
                    System.out.println("Game Over");
                    if (Grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")");
                    }else if (Grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")");
                    }else if (Grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckColumns(){
        for (int i=0; i<Grid.height;i++){
            for (int j=1; j<Grid.width+1;j++){
                if(Grid.grid[i][j] == Grid.grid[i+1][j] && Grid.grid[i][j] == Grid.grid[i+2][j] && Grid.grid[i][j] == Grid.grid[i+3][j] && Grid.grid[i][j] != " "){
                    System.out.println("Game Over");
                    if (Grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")");
                    }else if (Grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")");
                    }else if (Grid.grid[i][j] == Menu.piece3){  
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    } 
    public static void CheckDiagonals(){
        for (int i=0; i<Grid.height;i++){
            for (int j=1; j<Grid.width+1;j++){
                if(Grid.grid[i][j] == Grid.grid[i+1][j+1] && Grid.grid[i][j] == Grid.grid[i+2][j+2] && Grid.grid[i][j] == Grid.grid[i+3][j+3] && Grid.grid[i][j] != " "){
                    System.out.println("Game Over");
                    if (Grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins " + "(" + Menu.piece1 + ")");
                    }else if (Grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins " + "(" + Menu.piece2 + ")");
                    }else if (Grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins " + "(" + Menu.piece3 + ")");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckDiagonals2(){
        for (int i=0; i<Grid.height;i++){
            for (int j=1; j<Grid.width+1;j++){
                if(Grid.grid[i][j] == Grid.grid[i+1][j-1] && Grid.grid[i][j] == Grid.grid[i+2][j-2] && Grid.grid[i][j] == Grid.grid[i+3][j-3] && Grid.grid[i][j] != " "){
                    System.out.println("Game Over");
                    if (Grid.grid[i][j] == Menu.piece1){
                        System.out.println("Player 1 wins "+ "(" + Menu.piece1  + ")");
                    }else if (Grid.grid[i][j] == Menu.piece2){
                        System.out.println("Player 2 wins" + "(" + Menu.piece2  + ")");
                    }else if (Grid.grid[i][j] == Menu.piece3){
                        System.out.println("Player 3 wins" + "(" + Menu.piece3  + ")");
                    }
                    Menu.notADraw = true;
                    Menu.gameOver = true;
                }
            }
        }
    }
    public static void CheckWin(){
        CheckLigns();
        CheckColumns();
        CheckDiagonals();
        CheckDiagonals2();
        CheckGrid();
    }
}
