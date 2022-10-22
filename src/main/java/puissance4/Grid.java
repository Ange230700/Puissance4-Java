package puissance4;

import java.lang.String;
public class Grid{
    public int width;
    public int height = 0;
    public String[][] grid;
    // for 2 players 8x6 grid, for 3 players 12x10 grid
    public void grid(int nbPlayers){
        if(nbPlayers == 2){
            width = 8;
            height = 6;
            grid = new String[height+2][width+2];
        }
        else if(nbPlayers == 3){
            width = 12;
            height = 10;
            grid = new String[height+2][width+2];
        }
    }

     //build the grid
     public void BuildGrid(){
        for (int i=0; i<height+2;i++){
            for (int j=0; j<width+2;j++){
                if(  i == height || j==0 && i != height + 1|| j == width +1 && i != height + 1){
                    grid[i][j] = "#";
            }else if (i == height + 1 && j!=0 && j!=width +1){
                    //add alphabet letters to the bottom of the grid
                    grid[i][j] = String.valueOf((char)(j+64));
                }else{
                    grid[i][j] = " ";
                }
            }
        }
    }
    public void PutPiece(String piece, int column){
        for(int i=height-1; i>=0; i--){
                if(grid[i][column] == " "){
                    grid[i][column] = piece;
                    break;
                }
        }
        DisplayGrid();
    }
    public void DisplayGrid (){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}