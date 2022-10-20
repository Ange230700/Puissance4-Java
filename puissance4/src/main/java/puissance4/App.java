package puissance4;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        int nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        

        Grid grid = new Grid(nbPlayers);
        grid.grid(nbPlayers);
        System.out.println("grid.width = " + Grid.width);
        System.out.println("grid.height = " + Grid.height);
        grid.BuildGrid();
        Grid.DisplayGrid();
        if (nbPlayers==2){
            System.out.println("Menu.piece1 = " + Menu.piece1);
            System.out.println("Menu.piece2 = " + Menu.piece2);
        } else if (nbPlayers==3){
            System.out.println("Menu.piece1 = " + Menu.piece1);
            System.out.println("Menu.piece2 = " + Menu.piece2);
            System.out.println("Menu.piece3 = " + Menu.piece3);
        }
        // Menu.play();
    }
}
