import java.net.InetAddress;

public class App {
    static Grid game = new Grid();
    public static int nbPlayers = 0;

    public static void main(String[] args) throws Exception {
        if (PlayersChoice.isLocal()) {
            nbPlayers = Menu.chooseNbPlayers();
            game.grid(nbPlayers);
            game.BuildGrid();
            PlayersChoice.choosePiece(nbPlayers);
            game.DisplayGrid();
            while(!Menu.gameOver){
                WinCond.CheckWin(game);
                if (Menu.gameOver){
                    break;
                }
                int column = Menu.getColumn(App.game);
                Menu.play(game, column);
            }
        } else {
            if (PlayersChoice.isHost()) {
                nbPlayers = Menu.chooseNbPlayers();
                System.out.println("Your ip address is " + InetAddress.getLocalHost());
                game.grid(nbPlayers);
                game.BuildGrid();
                Server.main(args);
            }  else {
                Client.main(args);
            }
        }
    }
}