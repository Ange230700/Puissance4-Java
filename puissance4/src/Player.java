import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    public char symbol;

    public void setSymbol(int PlayerNB) {
        switch (PlayerNB) {
            case 0:
            this.symbol = 'X';
            case 1:
            this.symbol = 'O';
            case 2:
            this.symbol = 'V';
        }
    }

    public char getColumn() {
        System.out.println("Which column do you want to choose ?");
        System.out.println(">");
        InputStreamReader bis = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(bis);
        try {
            return br.readLine().charAt(0);
        }
        catch(IOException e) {
            System.err.println("Please retry : ");
            return getColumn();
        }
    }
}
