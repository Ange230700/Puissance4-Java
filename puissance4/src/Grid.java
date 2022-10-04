import java.lang.String;
public class Grid{
    public static int width;
    public static int height;
    public static String[][] grid;
    // for 2 players 8x6 grid, for 3 players 12x10 grid
    public void grid(int nbPlayers){
        if(nbPlayers == 2){
            width = 8;
            height = 6;
            grid = new String[height][width];
        }
        else if(nbPlayers == 3){
            width = 12;
            height = 10;
            grid = new String[height][width];
        }
    }

     //build a grid with spaces for empty cells and # for contour, the upper part of the grid is empty without using print
     public static void BuildGrid(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(i == 0 || i == height - 1){
                    grid[i][j] = "#";
                }
                else if(j == 0 || j == width - 1){
                    grid[i][j] = "#";
                }
                else{
                    grid[i][j] = " ";
                }
            }
        }
    }
    public static void MetO(int x, int y){
        grid[y][x] = "O";
    }


    //display grid with spaces for empty cells and # for contour, the upper part of the grid is empty
    // public void DisplayGrid(){
    //     for(int i = 0; i < this.height + 2; i++){
    //         for(int j = 0; j < this.width +2; j++){
    //             if(  i == this.height || j==0 && i != this.height + 1|| j == this.width +1 && i != this.height + 1){
    //                 System.out.print("#");
    //             }else if (i == this.height + 1 && j!=0 && j!=this.width +1){
    //                 //print alphabet letters for the bottom of the grid to indicate the columns
    //                 System.out.print((char)(j+64));
    //             }else{
    //                 System.out.print(" ");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
    public static void DisplayGrid (String [][]grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}