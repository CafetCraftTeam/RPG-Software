package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.equipment.Equipment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Gautier on 11/02/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EquipmentTest
{
    private String mName = "Bottle";
    private int mEncumbering = 10;
    private int mPrice = 100;
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple bottle";

    private Equipment equipment = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);

    @Test
    public void creationTest() {
        assertEquals(mName, equipment.getName());
        assertEquals(mEncumbering, equipment.getEncumbering());
        assertEquals(mPrice, equipment.getPrice());
        assertEquals(mQuality, equipment.getQuality());
        assertEquals(mDescription, equipment.getDescription());
    }

    @Test
    public void equalsTest() {
        Equipment same = equipment;
        Equipment deepCopy = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        Equipment otherName = new Equipment("Toto", mEncumbering, mPrice, mQuality, mDescription);
        Equipment otherEncumbering = new Equipment(mName, 1, mPrice, mQuality, mDescription);
        Equipment otherPrice = new Equipment(mName, mEncumbering, 1, mQuality, mDescription);
        Equipment otherQuality = new Equipment(mName, mEncumbering, mPrice, Equipment.Quality.BEST,
                mDescription);
        Equipment otherDescription = new Equipment(mName, mEncumbering, mPrice, mQuality, "Plop");

        assertTrue("x=x", equipment.equals(equipment));
        assertTrue("x = same", equipment.equals(same));
        assertTrue("x = deepCopy", equipment.equals(deepCopy));
        assertFalse("x = otherName", equipment.equals(otherName));
        assertFalse("otherName = x", otherName.equals(equipment));
        assertFalse("x = otherEncumbering", equipment.equals(otherEncumbering));
        assertFalse("x = otherPrice", equipment.equals(otherPrice));
        assertFalse("x = otherQuality", equipment.equals(otherQuality));
        assertTrue("x = otherDescription", equipment.equals(otherDescription));
    }

    @Test
    public void hashCodeTest() {
        Equipment same = equipment;
        Equipment deepCopy = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        Equipment otherName = new Equipment("Toto", mEncumbering, mPrice, mQuality, mDescription);
        Equipment otherEncumbering = new Equipment(mName, 1, mPrice, mQuality, mDescription);
        Equipment otherPrice = new Equipment(mName, mEncumbering, 1, mQuality, mDescription);
        Equipment otherQuality = new Equipment(mName, mEncumbering, mPrice, Equipment.Quality.BEST,
                mDescription);
        Equipment otherDescription = new Equipment(mName, mEncumbering, mPrice, mQuality, "Plop");

        assertEquals("x=x", equipment.hashCode(), equipment.hashCode());
        assertEquals("x = same", equipment.hashCode(), same.hashCode());
        assertEquals("x = deepCopy", equipment.hashCode(), deepCopy.hashCode());
        assertNotSame("x = otherName", equipment.hashCode(), otherName.hashCode());
        assertNotSame("x = otherEncumbering", equipment.hashCode(), otherEncumbering.hashCode());
        assertNotSame("x = otherPrice", equipment.hashCode(), otherPrice.hashCode());
        assertNotSame("x = otherQuality", equipment.hashCode(), otherQuality.hashCode());
        assertEquals("x = otherDescription", equipment.hashCode(), otherDescription.hashCode());
    }
}
