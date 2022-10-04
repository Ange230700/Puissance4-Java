public class App {
    public static void main(String[] args) throws Exception {
        int nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        
        Grid grid = new Grid();
        grid.grid(nbPlayers);
        grid.BuildGrid();
        Grid.DisplayGrid(Grid.grid);
        grid.replaceEmptyByInput(2, "X");
        grid.replaceEmptyByInput(2, "O");
        Grid.DisplayGrid(Grid.grid);
    }

}
