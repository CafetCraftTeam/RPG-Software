package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Gautier on 11/02/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EquipmentTest
{
    private String mName = "Bottle";
    private int mEncumbering = 10;
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple bottle";

    private Equipment equipment = new Equipment(mName, mEncumbering, mQuality, mDescription);

    @Test
    public void creationTest() {
        assertEquals(mName, equipment.getName());
        assertEquals(mEncumbering, equipment.getEncumbering());
        assertEquals(mQuality, equipment.getQuality());
        assertEquals(mDescription, equipment.getDescription());
    }
}
