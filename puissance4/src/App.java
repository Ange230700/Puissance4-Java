public class App {
    public static void main(String[] args) throws Exception {
        int nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        
        Grid grid = new Grid();
        grid.Grid(nbPlayers);
        grid.DisplayGrid();
    }

}
