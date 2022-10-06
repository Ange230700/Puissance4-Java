public class App {
    public static void main(String[] args) throws Exception {
        int nbPlayers = Menu.chooseNbPlayers();
        System.out.println("nbPlayers = " + nbPlayers);        
        Grid grid = new Grid();
        grid.grid(nbPlayers);
        System.out.println("grid.width = " + Grid.width);
        System.out.println("grid.height = " + Grid.height);
        Grid.BuildGrid();
        Grid.DisplayGrid();
        // Grid.MetO(1, 1);
        // Grid.PutPiece("O",1);
        // Grid.DisplayGrid();
        // Grid.PutPiece("X", 1);
        // Grid.DisplayGrid();
        Players.choosePiece(nbPlayers);
        if (nbPlayers==2){
            System.out.println("Menu.piece1 = " + Menu.piece1);
            System.out.println("Menu.piece2 = " + Menu.piece2);
        } else if (nbPlayers==3){
            System.out.println("Menu.piece1 = " + Menu.piece1);
            System.out.println("Menu.piece2 = " + Menu.piece2);
            System.out.println("Menu.piece3 = " + Menu.piece3);
        }
        Menu.play();
    }
    }

