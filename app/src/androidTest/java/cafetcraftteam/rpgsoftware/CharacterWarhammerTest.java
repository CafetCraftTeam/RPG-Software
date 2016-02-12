package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import static junit.framework.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacterWarhammerTest {

    private CharacterWarhammer Pujima = new CharacterWarhammer("Pujima","cerschae","Warhammer",1662,"Human",36,"M","blue");
    private Dice D100 = new Dice(100);

    @Before
    public void init() {
    }

    @Test
    public void DiceBoundaryTest() {
        assertEquals(6,D6.getMax());
        assertEquals(100,D100.getMax());
    }
}


