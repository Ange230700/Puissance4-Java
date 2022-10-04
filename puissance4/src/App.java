public class App {
    public static void main(String[] args) throws Exception {
        int nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        
        Grid grid = new Grid();
        grid.grid(nbPlayers);
        System.out.println("grid.width = " + Grid.width);
        System.out.println("grid.height = " + Grid.height);
        Grid.BuildGrid();
        Grid.DisplayGrid(Grid.grid);
        // Grid.MetO(1, 1);
        Grid.PutPiece("O",1);
        Grid.DisplayGrid(Grid.grid);
        Grid.PutPiece("X", 1);
        Grid.DisplayGrid(Grid.grid);
        Players.choosePiece();
        System.out.println("Players.piece = " + Players.piece);
    }

    }
}
