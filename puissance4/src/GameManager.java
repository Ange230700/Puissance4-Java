public class GameManager {
    Grid game = new Grid();
    int nbPlayers = Menu.chooseNbPlayers();
    Player[] players = new Player[nbPlayers];
    for (int ii = 0; ii < nbPlayers; ii++){
            players[ii].setSymbol(ii);
    }
    System.out.println("nbPlayers = " + nbPlayers);        
    game.grid(nbPlayers);
    game.BuildGrid();
}
