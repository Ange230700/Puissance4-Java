package puissance4;

import java.lang.String;
/**
 * @author Yassine
 */
public class Grid{
    /**
     * the grid's width
     */
    public int width;
    /**
     * the grid's height
     */
    public int height = 0;
    /**
     * the grid's containing
     */
    public String[][] grid;
    /**
     * set the grid with the correct height and width regarding the number of players set
     * @param nbPlayers the number of players
     */
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

     /**
      * Build the grid correctly with blank spaces
      */
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
    /**
     * Replace a blank space by the symbol of the current player
     * @param piece is the symbol of the current player
     * @param column is where the player wants to put is piece
     */
    public void PutPiece(String piece, int column){
        for(int i=height-1; i>=0; i--){
                if(grid[i][column] == " "){
                    grid[i][column] = piece;
                    break;
                }
        }
        DisplayGrid();
    }
    /**
     * Print the grid
     */
    public void DisplayGrid (){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                String color = "";
                switch (grid[i][j]){
                    case "X":
                        color = "\u001B[96m";
                        break;
                    case "V":
                        color = "\u001B[92m";
                        break;
                    case "O":
                        color = "\u001B[93m";
                        break;
                    default :
                        color = "\u001B[0m";
                        break;
                }
                System.out.print(color + grid[i][j]);
            }
            System.out.println();
        }
    }
}