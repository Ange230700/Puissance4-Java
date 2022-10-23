package puissance4;

import java.util.Scanner;

public class Player 
{
    public char symbol;
    /**
     * This method assigns a symbol to each player for playing with.
     * @param PlayerNB
     */
    public void setSymbol(int PlayerNB) 
    {
        switch (PlayerNB) 
        {
            case 0:
            this.symbol = 'X';
            case 1:
            this.symbol = 'O';
            case 2:
            this.symbol = 'V';
        }
    }

    /**
     * It is basically a conversion from the index chosen to the
     * column character that corresponds.
     * @param width being that index.
     * @return
     */
    public static char getColumn(int width) 
    {
        System.out.println("Which column do you want to choose ?");
        System.out.println(">");
        Scanner input = new Scanner(System.in);
        if(input.nextLine().length() == 1 || input.nextLine().charAt(0) > (char)(width+64)) 
        {
            char clmn = input.nextLine().charAt(0);
            // input.close();
            return clmn;
        } 
        else 
        {
            System.out.println("Please enter a valid column name");
            getColumn(width);
        }
        // input.close();
        return 'a';
    }
}
