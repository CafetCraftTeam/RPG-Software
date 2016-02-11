package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Comment;

import static junit.framework.Assert.assertEquals;


/**
 * Created by Pujima on 11/02/2016.
 */

public class CharacterTest {

    @RunWith(AndroidJUnit4.class)
    @LargeTest
    public class DiceTest {
        private Dice D6 = new Dice(6);
        private Dice D100 = new Dice(100);

        @Before
        public void init() {
        }

        @Test
        public void DiceBoundaryTest() {
            assertEquals(6,D6.getMax());
            assertEquals(100,D100.getMax());
        }
        @Test
        public void DiceOverflowTest() {
            for (int i=0; i<10000; i++){
                int number = D6.diceGenerator();
                assertTrue(number<=6 && number>=1);
            }
            for (int i=0; i<10000; i++){
                int number = D100.diceGenerator();
                assertTrue(number<=100 && number>=1);
            }
        }
    }

}
