import java.util.Scanner;
public class Players {  
    public static String piece;
    public static void choosePiece(){
        Scanner sc = new Scanner(System.in);
        if (Menu.chooseNbPlayers()==2){
            System.out.println("Choose a piece: X or O");
            piece = sc.nextLine();
        }else if (Menu.chooseNbPlayers()==3){
            System.out.println("Choose a piece: X, O or V");
            piece = sc.nextLine();
        }
        while(piece != "X" && piece != "O" && piece != "V"){
            System.out.println("Please enter X, O or V");
            piece = sc.nextLine();
        }
    }
}
