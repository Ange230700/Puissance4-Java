public class App {
    public static void main(String[] args) throws Exception {
        int nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        
        Grid grid = new Grid();
        grid.grid(nbPlayers);
        System.out.println("grid.width = " + grid.width);
        System.out.println("grid.height = " + grid.height);
        grid.BuildGrid();
        Grid.DisplayGrid(grid.grid);
        Grid.MetO(1, 1);
        Grid.DisplayGrid(grid.grid);
    }

}
