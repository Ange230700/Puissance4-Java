public class App {
    static Grid game = new Grid();
    public static int nbPlayers = Menu.chooseNbPlayers();

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