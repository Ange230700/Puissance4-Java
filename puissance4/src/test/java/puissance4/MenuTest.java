package puissance4;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MenuTest 
{
    private final PrintStream ps = System.out;
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    @Before
    public void SetUpStreams()
    {
        System.setOut(new PrintStream(baos));
    }
    @After
    public void RestoreStreams()
    {
        System.setOut(ps);
    }
    @Test
    public void ShouldIdentifyCorrectlyWhoIsPlaying()
    {
        try
        {            
            if (Menu.gameOver)
            {
                Menu.WhoPlays();
                switch(App.nbPlayers)
                {
                    case 2:
                        if(Menu.turnCounter % 2 == 0)
                        {
                            assertEquals("Player 1 plays " + "("+ Menu.piece1 + ")\n", baos.toString());
                        }
                        assertEquals("Player 2 plays " + "("+ Menu.piece2 + ")\n", baos.toString());
                    case 3:
                        if(Menu.turnCounter % 3 == 0)
                        {
                            assertEquals("Player 1 plays " + "("+ Menu.piece1 + ")\n", baos.toString());
                        }
                        else if(Menu.turnCounter % 3 == 1)
                        {
                            assertEquals("Player 2 plays " + "("+ Menu.piece2 + ")\n", baos.toString());
                        }
                        assertEquals("Player 3 plays " + "("+ Menu.piece3 + ")\n", baos.toString());
                }
            }
            
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
    }
    @Test
    public void ShouldGetValidColumn()
    {
        try
        {
            if(Menu.gameOver)
            {
                Menu.getColumn(App.game);
                String input = String.format("X");
                ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
                System.setIn(bais);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                System.setOut(ps);
                if(!Menu.gameOver)
                {
                    assertEquals((int) input.charAt(0) - 64 + 1, Menu.getColumn(App.game));
                }
            }
            
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
    }
}
