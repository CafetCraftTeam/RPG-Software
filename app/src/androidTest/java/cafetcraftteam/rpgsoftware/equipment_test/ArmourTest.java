package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.EnumMap;
import java.util.Map;

import cafetcraftteam.rpgsoftware.BodyPart;
import cafetcraftteam.rpgsoftware.equipment.Armour;
import cafetcraftteam.rpgsoftware.equipment.Equipment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Gautier on 14/02/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ArmourTest
{
    private String mName = "Leather Jerkin";
    private int mEncumbering = 40;
    private int mPrice = 100;
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple leather jerkin";

    private int mArmourPoint = 1;
    private BodyPart mBodyPart = BodyPart.TORSO;
    private Map<BodyPart, Integer> mProtectedParts = new EnumMap<>(BodyPart.class);

    private Armour mArmour;

    @Before
    public void init() {
        mProtectedParts.put(mBodyPart, mArmourPoint);

        mArmour = new Armour(mName, mEncumbering, mPrice, mQuality, mDescription, mProtectedParts);
    }

    @Test
    public void creationTest() {
        Equipment equipment = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        assertEquals(equipment, mArmour);
        assertEquals(mArmourPoint, mArmour.getArmourPoint(mBodyPart));
        assertEquals(0, mArmour.getArmourPoint(BodyPart.HEAD));
        assertTrue(mArmour.isProtected(mBodyPart));
    }

    @Test(expected = InstantiationError.class)
    public void cannotCreateWithEmptyProtectedParts() {
        Map<BodyPart, Integer> emptyProtectedParts = new EnumMap<>(BodyPart.class);

        new Armour(mName, mEncumbering, mPrice, mQuality, mDescription, emptyProtectedParts);
    }
}
