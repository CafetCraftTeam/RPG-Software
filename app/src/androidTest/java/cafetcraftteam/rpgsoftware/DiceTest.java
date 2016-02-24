package cafetcraftteam.rpgsoftware;

/**
 * Created by defig on 10.02.2016.
 */

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DiceTest
{
    private Dice D6 = new Dice(6);
    private Dice D100 = new Dice(2, 100);

    @Test
    public void DiceBoundaryTest() {
        assertEquals(6, D6.getMax());
        assertEquals(1, D6.getInf());
        assertEquals(100, D100.getMax());
        assertEquals(2, D100.getInf());
    }

    @Test
    public void DiceOverflowTest() {
        for (int i = 0; i < 1000; i++)
        {
            int number = D6.diceGenerator();
            assertTrue(number <= 6 && number >= 1);
        }
        for (int i = 0; i < 1000; i++)
        {
            int number = D100.diceGenerator();
            assertTrue(number <= 100 && number >= 2);
        }
    }

    @Test
    public void DiceOneTest(){
        Dice D1 = new Dice(1);
        try{
            int number = D1.diceGenerator();
        }
        catch(Exception error){
            fail("Un dés de 1 n'a pas pu être créé");
        }

    }
}
