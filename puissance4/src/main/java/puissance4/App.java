package puissance4;

public class App 
{
    /**
     * This is the game state.
     */ 
    static Grid game = new Grid();
    public static int nbPlayers = Menu.chooseNbPlayers();      

    public static void main(String[] args) throws Exception 
    {        
        game.grid(nbPlayers);
        game.BuildGrid();
        PlayersChoice.choosePiece(nbPlayers);
        if (PlayersChoice.isLocal())
        {
            PlayersChoice.choosePiece(nbPlayers);
            game.DisplayGrid();
            while(!Menu.gameOver)
            {
                GameManager.CheckWin(game);
                if (Menu.gameOver)
                {
                    break;
                }
                Menu.play(game, Menu.getColumn(game));
            }
        }
        else
        {
            if (PlayersChoice.isHost())
            {
                Server.main(args);
            }
            else
            {
                Client.main(args);
            }
        }
    }
}
