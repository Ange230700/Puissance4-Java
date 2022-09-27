import java.util.*;

public class Grid{
    public List<Character> columns;
    private int nbPlayers;
    private int width;
    private int height;
    // for 2 players 8x6 grid, for 3 players 12x10 grid
    private void setGrid(int nbPlayers){
        if(nbPlayers == 2){
            this.width = 8;
            this.height = 6;
        }
        else if(nbPlayers == 3){
            this.width = 12;
            this.height = 10;
        }
    }
    public void fillGrid() {
        for (int x = 0; x < this.width; x++) {

        }
    }
}