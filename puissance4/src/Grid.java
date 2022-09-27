
public class Grid{
    int width;
    int height;
    // for 2 players 8x6 grid, for 3 players 12x10 grid
    public void Grid(int nbPlayers){
        if(nbPlayers == 2){
            this.width = 8;
            this.height = 6;
        }
        else if(nbPlayers == 3){
            this.width = 12;
            this.height = 10;
        }
    }
    //display grid with spaces for empty cells and # for contour, the upper part of the grid is empty
    public void DisplayGrid(){
        for(int i = 0; i < this.height + 2; i++){
            for(int j = 0; j < this.width +2; j++){
                if(  i == this.height || j==0 && i != this.height + 1|| j == this.width +1 && i != this.height + 1){
                    System.out.print("#");
                }else if (i == this.height + 1 && j!=0 && j!=this.width +1){
                    //print alphabet letters for the bottom of the grid to indicate the columns
                    System.out.print((char)(j+64));
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}