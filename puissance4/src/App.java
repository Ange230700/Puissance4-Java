public class App {
<<<<<<< HEAD
    public static void main(String[] args) throws Exception 
    {
        int nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        
// <<<<<<< HEAD
        // Grid grid = new Grid(nbPlayers);
        // System.out.println("grid.width = " + grid.width);
        // System.out.println("grid.height = " + grid.height);
        // grid.DisplayGrid();
// =======
        Grid grid = new Grid(nbPlayers);
        grid.grid(nbPlayers);
        System.out.println("grid.width = " + Grid.width);
        System.out.println("grid.height = " + Grid.height);
        Grid.BuildGrid();
        Grid.DisplayGrid();
        // Grid.MetO(1, 1);
        // Grid.PutPiece("O",1);
        // Grid.DisplayGrid();
        // Grid.PutPiece("X", 1);
        // Grid.DisplayGrid();
        Players.choosePiece(nbPlayers);
        if (nbPlayers==2){
            System.out.println("Menu.piece1 = " + Menu.piece1);
            System.out.println("Menu.piece2 = " + Menu.piece2);
        } else if (nbPlayers==3){
            System.out.println("Menu.piece1 = " + Menu.piece1);
            System.out.println("Menu.piece2 = " + Menu.piece2);
            System.out.println("Menu.piece3 = " + Menu.piece3);
        }
        Menu.play();
    }
// >>>>>>> 304a4d076790556de15deba0e52c56b01f10ec05
    }
=======
    static Grid game = new Grid();
    public static int nbPlayers = Menu.chooseNbPlayers();
>>>>>>> 3eead19822b5971d0ea6fe65c2b5c725f5b7b90e

    public static void main(String[] args) throws Exception {
        game.grid(nbPlayers);
        game.BuildGrid();
        if (PlayersChoice.isLocal()) {
            PlayersChoice.choosePiece(nbPlayers);
            game.DisplayGrid();
            while(!Menu.gameOver){
                WinCond.CheckWin(game);
                if (Menu.gameOver){
                    break;
                }
                Menu.play(game, Menu.getColumn(game));
            }
        } else {
            if (PlayersChoice.isHost()) {
                Server.main(args);
            }  else {
                Client.main(args);
            }
        }
    }
}