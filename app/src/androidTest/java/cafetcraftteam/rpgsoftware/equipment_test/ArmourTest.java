package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;
import java.util.Set;

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
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple leather jerkin";

    private int mArmourPoint = 1;
    private Set<BodyPart> mProtectedParts = new HashSet<>();

    private Armour mArmour;

    @Before
    public void init() {
        mProtectedParts.add(BodyPart.TORSO);

        mArmour = new Armour(mName, mEncumbering, mQuality, mDescription, mArmourPoint,
                mProtectedParts);
    }

    @Test
    public void creationTest() {
        assertEquals(mName, mArmour.getName());
        assertEquals(mEncumbering, mArmour.getEncumbering());
        assertEquals(mQuality, mArmour.getQuality());
        assertEquals(mDescription, mArmour.getDescription());
        assertEquals(mArmourPoint, mArmour.getArmourPoint());
        assertEquals(mProtectedParts, mArmour.getProtectedParts());
        assertTrue(mArmour.isProtected(BodyPart.TORSO));
    }
}
