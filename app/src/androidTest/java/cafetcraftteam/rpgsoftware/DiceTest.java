package cafetcraftteam.rpgsoftware;

/**
 * Created by defig on 10.02.2016.
 */
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Comment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DiceTest {
    int Inf = 1;
    int Max = 100;
    private Dice D = new Dice(Inf,Max);

    @Before
    public void init() {
    }

    @Test
    public void DiceBoundaryTest() {
        assertEquals(Inf,D.getInf());
        assertEquals(Max,D.getMax());
    }
    @Test
    public void DiceOverflowTest() {
        for (int i=0; i<10000; i++){
            int number = D.diceGenerator();
            assertTrue(number<=Max && number>=Inf);
        }
    }
}
