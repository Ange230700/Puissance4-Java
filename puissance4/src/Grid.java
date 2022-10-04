import java.util.*;

import javax.swing.text.AttributeSet.ColorAttribute;
import javax.xml.stream.events.Characters;

public class Grid{
    public Character[] columns = new Character[12];
    public Character[][] gridContainer = new Character[12][10];
    public int width;
    public int height;
    // for 2 players 8x6 grid, for 3 players 12x10 grid
    public void Grid(int nbPlayers){
        if(nbPlayers == 2){
            this.width = 8;
            this.height = 6;
        }
        else if(nbPlayers == 3){
            this.width = 12;
            this.height = 10;
        };
    }

    //display grid with spaces for empty cells and # for contour, the upper part of the grid is empty
    public void DisplayGrid(){
        for(int ii = 0; ii < columns.length-1; ii++){
            if (this.width == 8 ){
                for ( int aa = 9; aa < columns.length-1; aa++) {
                    columns[aa] = ' ';
                }
            }
            columns[ii] = ' ';
        }
        columns[0] = '#';
        columns[this.width-1] = '#';
        for (int xx = 0; xx < columns.length-1; xx++){
            System.out.print(columns[xx]);
        }
        // for(int i = 0; i < gridContainer.length; i++){
        //     for(int j = 0; j < gridContainer[i].length; j++){
        //         System.out.println(gridContainer[i][j]);
        //     }
        // }
    }
}