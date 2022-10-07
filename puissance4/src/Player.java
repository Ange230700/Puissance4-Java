import java.util.Scanner;

public class Player {

    public String symbol;

    public void setSymbol(int PlayerNB) {
        switch (PlayerNB) {
            case 0:
            this.symbol = "X";
            case 1:
            this.symbol = "O";
            case 2:
            this.symbol = "V";
        }
    }

    public char getColumn(int width) {
        System.out.println("Which column do you want to choose ?");
        System.out.println(">");
        Scanner input = new Scanner(System.in);
        if(input.nextLine().length() == 1 || input.nextLine().charAt(0) > (char)(width+64)) {
            input.close();
            return input.nextLine().charAt(0);
        } else {
            System.out.println("Please enter a valid column name");
            getColumn(width);
        }
        input.close();
        return 'E';
    }
}
