public class App {
    static int nbPlayers = 2;
    static Grid game = new Grid();
    static Player[] players = new Player[nbPlayers];
    public static void main(String[] args) throws Exception {
        InitialiseGrid();
        SetPlayers();
        Play();
    }
    public static void InitialiseGrid() {
        nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        
        game.grid(nbPlayers);
        game.BuildGrid();
    }
    public static void SetPlayers() {
        for (int ii = 0; ii < nbPlayers; ii++){
                players[ii] = new Player();
                players[ii].setSymbol(ii);
        }
    }
    public static void Play() {
        for (int ii = 0; ii < players.length; ii++) {
            game.DisplayGrid();
            char column  = players[ii].getColumn(game.width);
            game.PutPiece(players[ii].symbol, column-64);
        }
    }
}
