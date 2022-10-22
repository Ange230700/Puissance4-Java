package puissance4;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void winWhen4alignedLign()
    {
        int startingPoint = 3;
        Grid game = new Grid();
        game.grid(2);
        game.BuildGrid();
        for (int i = startingPoint; i < startingPoint+4; i++) {
            game.grid[2][i] = "X";
        }
        WinCond.CheckLigns(game);
        assertTrue(Menu.notADraw);
    }
    @Test
    public void winWhen4alignedColumn() {
        int startingPoint = 2;
        Grid game = new Grid();
        game.grid(2);
        game.BuildGrid();
        for (int i = startingPoint; i < startingPoint+4; i++) {
            game.grid[i][3] = "X";
        }
        WinCond.CheckColumns(game);
        assertTrue(Menu.notADraw);
    }
    @Test
    public void winWhenDiagonals() {
        Grid game = new Grid();
        game.grid(2);
        game.BuildGrid();
        for (int i=0; i<game.height+2;i++){
            for (int j=0; j<game.width+2;j++){
                if(  i == game.height || j==0 && i != game.height + 1|| j == game.width +1 && i != game.height + 1){
                    game.grid[i][j] = "#";
            }else if (i == game.height + 1 && j!=0 && j!=game.width +1){
                    //add alphabet letters to the bottom of the grid
                    game.grid[i][j] = String.valueOf((char)(j+64));
                }else{
                    if (i%2==0 && j%2 != 0 || i%2 !=0 && j%2 ==0) {
                        game.grid[i][j] = "X";
                    } else {
                        game.grid[i][j] = "Y";
                    }
                }
            }
        }
        WinCond.CheckDiagonals(game);
        assertTrue(Menu.notADraw);
    }
    @Test
    public void egality() {
        Grid game = new Grid();
        game.grid(2);
        game.BuildGrid();
        for (int i=0; i<game.height+2;i++){
            for (int j=0; j<game.width+2;j++){
                if(  i == game.height || j==0 && i != game.height + 1|| j == game.width +1 && i != game.height + 1){
                    game.grid[i][j] = "#";
            }else if (i == game.height + 1 && j!=0 && j!=game.width +1){
                    //add alphabet letters to the bottom of the grid
                    game.grid[i][j] = String.valueOf((char)(j+64));
                }else{
                    if (i%2==0 && j%2 != 0) {
                        game.grid[i][j] = "X";
                    } else if (i%2 !=0 && j%2 ==0){
                        game.grid[i][j] = "O";
                        game.grid[i-1][j] = "N";
                    } else if (game.grid[i][j] == " "){
                        game.grid[i][j] = "Y";
                    }
                }
            }
        }
        WinCond.CheckWin(game);
        assertTrue(!Menu.notADraw);
    }
}
