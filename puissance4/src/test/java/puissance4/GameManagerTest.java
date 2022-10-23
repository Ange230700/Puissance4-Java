package puissance4;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class GameManagerTest 
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
    public void ShouldCheckGrid()
    {
        try
        {
            if(Menu.gameOver)
            {
                puissance4.GameManager.CheckGrid(puissance4.App.game);
                assertEquals("Game Over!\nThe grid is full. It's a draw.\n", baos.toString());
            }
            
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
    }
    @Test
    public void ShouldCheckLigns()
    {
        try
        {
            if(Menu.gameOver)
            {
                GameManager.CheckLigns(App.game);
                switch(App.nbPlayers)
                {
                    case 2:
                        if(Menu.turnCounter % 2 == 0)
                        {
                            assertEquals("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces horizontally.\n", baos.toString());
                        }
                        assertEquals("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces horizontally.\n", baos.toString());
                    case 3:
                        if(Menu.turnCounter % 3 == 0)
                        {
                            assertEquals("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces horizontally.\n", baos.toString());
                        }
                        else if(Menu.turnCounter % 3 == 1)
                        {
                            assertEquals("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces horizontally.\n", baos.toString());
                        }
                        assertEquals("Game Over!\nPlayer 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces horizontally.\n", baos.toString());
                }
                assertTrue(Menu.notADraw);
            }
            
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
    }
    @Test
    public void ShouldCheckColumns()
    {
        try
        {
            if(Menu.gameOver)
            {
                GameManager.CheckColumns(App.game);
                switch(App.nbPlayers)
                {
                    case 2:
                        if(Menu.turnCounter % 2 == 0)
                        {
                            assertEquals("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces vertically.\n", baos.toString());
                        }
                        assertEquals("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces vertically.\n", baos.toString());
                    case 3:
                        if(Menu.turnCounter % 3 == 0)
                        {
                            assertEquals("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces vertically.\n", baos.toString());
                        }
                        else if(Menu.turnCounter % 3 == 1)
                        {
                            assertEquals("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces vertically.\n", baos.toString());
                        }
                        assertEquals("Game Over!\nPlayer 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces vertically.\n", baos.toString());
                }
                assertTrue(Menu.notADraw);
            }
            
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
    }
    @Test
    public void ShouldCheckDiagonals()
    {
        try
        {
            if(Menu.gameOver)
            {
                GameManager.CheckDiagonals(App.game);
                switch(App.nbPlayers)
                {
                    case 2:
                        if(Menu.turnCounter % 2 == 0)
                        {
                            assertEquals("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                        }
                        assertEquals("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                    case 3:
                        if(Menu.turnCounter % 3 == 0)
                        {
                            assertEquals("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                        }
                        else if(Menu.turnCounter % 3 == 1)
                        {
                            assertEquals("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                        }
                        assertEquals("Game Over!\nPlayer 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                }
                assertTrue(Menu.notADraw);
            }
            
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
    }
    @Test
    public void ShouldCheckDiagonals2()
    {
        try
        {
            if(Menu.gameOver)
            {
                GameManager.CheckDiagonals2(App.game);
                switch(App.nbPlayers)
                {
                    case 2:
                        if(Menu.turnCounter % 2 == 0)
                        {
                            assertEquals("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                        }
                        assertEquals("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                    case 3:
                        if(Menu.turnCounter % 3 == 0)
                        {
                            assertEquals("Game Over!\nPlayer 1 wins " + "(" + Menu.piece1 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                        }
                        else if(Menu.turnCounter % 3 == 1)
                        {
                            assertEquals("Game Over!\nPlayer 2 wins " + "(" + Menu.piece2 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                        }
                        assertEquals("Game Over!\nPlayer 3 wins " + "(" + Menu.piece3 + ")" + " by aligning 4 pieces diagonally.\n", baos.toString());
                }
                assertTrue(Menu.notADraw);
            }
            
        }
        catch(Exception e)
        {
            fail(e.getMessage());
        }
    }
}
