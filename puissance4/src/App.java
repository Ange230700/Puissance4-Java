public class App {
    public static void main(String[] args) throws Exception {
        Grid game = new Grid();
        int nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        
        game.grid(nbPlayers);
        game.BuildGrid();
        for (int aa = 0; aa < 3; aa++){
                game.replaceEmptyByInput(2, "X");
                game.replaceEmptyByInput(3, "O");
                System.out.print(game.grid[2][game.height-1]);
                game.DisplayGrid();
        }


    }

}
