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
import static junit.framework.Assert.fail;

/**
 * Class that test the Armour class
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
    public void init()
    {
        mProtectedParts.put(mBodyPart, mArmourPoint);

        mArmour = new Armour(mName, mEncumbering, mPrice, mQuality, mDescription, mProtectedParts);
    }

    @Test
    public void creationTest()
    {
        Equipment equipment = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        assertEquals(equipment, mArmour);
        assertEquals(mArmourPoint, mArmour.getArmourPoint(mBodyPart));
        assertEquals(0, mArmour.getArmourPoint(BodyPart.HEAD));
        assertTrue(mArmour.isProtected(mBodyPart));
    }

    @Test
    public void contractRespectProtectedParts() {
        // protectedParts must not be null
        try
        {
            new Armour(mName, mEncumbering, mPrice, mQuality, mDescription, null);
        }
        catch (InstantiationError e){
            // success
        }

        // protected parts must not be empty
        Map<BodyPart, Integer> emptyProtectedParts = new EnumMap<>(BodyPart.class);
        try
        {
            new Armour(mName, mEncumbering, mPrice, mQuality, mDescription, emptyProtectedParts);
            fail("Null protected parts don't generate an error");
        }
        catch (InstantiationError e){
            // success
        }

        // protectedParts must not contains negative values
        Map<BodyPart, Integer> negativeProtectedParts =
                new EnumMap<>(BodyPart.class);
        negativeProtectedParts.put(BodyPart.RIGHT_ARM, -1);
        try {
            new Armour(mName, mEncumbering, mPrice, mQuality, mDescription, negativeProtectedParts);
            fail("A negative value of protection in protected parts have not generate an error");
        }
        catch (InstantiationError e) {
            // success
        }

        // protectedParts can contains zero values but this will be deleted
        Map<BodyPart, Integer> onlyZeroProtectedParts =
                new EnumMap<>(BodyPart.class);
        onlyZeroProtectedParts.put(BodyPart.LEFT_ARM, 0);
        try
        {
            new Armour(mName, mEncumbering, mPrice, mQuality, mDescription,
                    onlyZeroProtectedParts);
            fail("Zero as protection value will be remove, leading to an empty map");
        }
        catch (InstantiationError e) {
            // success error generated
        }

        Map<BodyPart, Integer> zeroProtectedParts =
                new EnumMap<>(BodyPart.class);
        zeroProtectedParts.put(BodyPart.RIGHT_LEG, 0);
        zeroProtectedParts.put(BodyPart.RIGHT_ARM, 1);
        Armour zeroArmour = new Armour(mName, mEncumbering, mPrice, mQuality, mDescription,
                zeroProtectedParts);
        assertEquals(false, zeroArmour.isProtected(BodyPart.LEFT_ARM));
    }
}
