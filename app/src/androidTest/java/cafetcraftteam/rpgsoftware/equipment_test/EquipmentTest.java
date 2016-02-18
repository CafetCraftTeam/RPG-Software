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
import static junit.framework.Assert.fail;

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

    private Equipment mEquipment = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);

    @Test
    public void creationTest() {
        assertEquals(mName, mEquipment.getName());
        assertEquals(mEncumbering, mEquipment.getEncumbering());
        assertEquals(mPrice, mEquipment.getPrice());
        assertEquals(mQuality, mEquipment.getQuality());
        assertEquals(mDescription, mEquipment.getDescription());
    }

    @Test
    public void contractRespectName() {
        // name must not be null
        try {
            new Equipment(null, mEncumbering, mPrice, mQuality, mDescription);
            fail("Null name don't generate an exception");
        }
        catch (IllegalArgumentException e) {
            // success
        }

        // name must not be empty
        try {
            new Equipment("", mEncumbering, mPrice, mQuality, mDescription);
            fail("Empty name don't generate an exception");
        }
        catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void contractRespectEncumbering() {
        // encumbering must not be negative
        try {
            new Equipment(mName, -mEncumbering, mPrice, mQuality, mDescription);
            fail("Negative encumbering don't generate an exception");
        }
        catch (IllegalArgumentException e) {
            // success
        }

        // zero as encumbering is valid
        try {
            new Equipment(mName, 0, mPrice, mQuality, mDescription);
        }
        catch (IllegalArgumentException e) {
            fail("Zero encumbering generate an exception");
        }
    }

    @Test
    public void contractRespectPrice() {
        // price must not be negative
        try {
            new Equipment(mName, mEncumbering, -mPrice, mQuality, mDescription);
            fail("Negative price don't generate an exception");
        }
        catch (IllegalArgumentException e) {
            // success
        }

        // zero as price is valid
        try {
            new Equipment(mName, mEncumbering, 0, mQuality, mDescription);
        }
        catch (IllegalArgumentException e) {
            fail("Zero price generate an exception");
        }
    }

    @Test
    public void contractRespectQuality() {
        // quality must not be null
        try {
            new Equipment(mName, mEncumbering, mPrice, null, mDescription);
            fail("Null quality don't generate an exception");
        }
        catch (IllegalArgumentException e) {
            // success
        }
    }

    @Test
    public void contractRespectDescription() {
        // description can be null
        try {
            new Equipment(mName, mEncumbering, mPrice, mQuality, null);
        }
        catch (IllegalArgumentException e) {
            fail("Null description generate an exception");
        }

        // description can be empty
        try {
            new Equipment(mName, mEncumbering, mPrice, mQuality, "");
        }
        catch (IllegalArgumentException e) {
            fail("Empty description generate an exception");
        }
    }




    @Test
    public void equalsTest() {
        Equipment same = mEquipment;
        Equipment deepCopy = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        Equipment otherName = new Equipment("Toto", mEncumbering, mPrice, mQuality, mDescription);
        Equipment otherEncumbering = new Equipment(mName, 1, mPrice, mQuality, mDescription);
        Equipment otherPrice = new Equipment(mName, mEncumbering, 1, mQuality, mDescription);
        Equipment otherQuality = new Equipment(mName, mEncumbering, mPrice, Equipment.Quality.BEST,
                mDescription);
        Equipment otherDescription = new Equipment(mName, mEncumbering, mPrice, mQuality, "Plop");

        assertFalse("x=null", mEquipment.equals(null));
        assertTrue("x=x", mEquipment.equals(mEquipment));
        assertTrue("x = same", mEquipment.equals(same));
        assertTrue("x = deepCopy", mEquipment.equals(deepCopy));
        assertFalse("x = otherName", mEquipment.equals(otherName));
        assertFalse("otherName = x", otherName.equals(mEquipment));
        assertFalse("x = otherEncumbering", mEquipment.equals(otherEncumbering));
        assertFalse("x = otherPrice", mEquipment.equals(otherPrice));
        assertFalse("x = otherQuality", mEquipment.equals(otherQuality));
        assertTrue("x = otherDescription", mEquipment.equals(otherDescription));
    }

    @Test
    public void hashCodeTest() {
        Equipment same = mEquipment;
        Equipment deepCopy = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        Equipment otherName = new Equipment("Toto", mEncumbering, mPrice, mQuality, mDescription);
        Equipment otherEncumbering = new Equipment(mName, 1, mPrice, mQuality, mDescription);
        Equipment otherPrice = new Equipment(mName, mEncumbering, 1, mQuality, mDescription);
        Equipment otherQuality = new Equipment(mName, mEncumbering, mPrice, Equipment.Quality.BEST,
                mDescription);
        Equipment otherDescription = new Equipment(mName, mEncumbering, mPrice, mQuality, "Plop");

        assertEquals("x=x", mEquipment.hashCode(), mEquipment.hashCode());
        assertEquals("x = same", mEquipment.hashCode(), same.hashCode());
        assertEquals("x = deepCopy", mEquipment.hashCode(), deepCopy.hashCode());
        assertNotSame("x = otherName", mEquipment.hashCode(), otherName.hashCode());
        assertNotSame("x = otherEncumbering", mEquipment.hashCode(), otherEncumbering.hashCode());
        assertNotSame("x = otherPrice", mEquipment.hashCode(), otherPrice.hashCode());
        assertNotSame("x = otherQuality", mEquipment.hashCode(), otherQuality.hashCode());
        assertEquals("x = otherDescription", mEquipment.hashCode(), otherDescription.hashCode());
    }

    @Test
    public void setDescriptionTest() {
        Equipment descriptionChanged = new Equipment(mName, mEncumbering, mPrice, mQuality,
                mDescription);

        assertEquals(mEquipment, descriptionChanged);

        descriptionChanged.setDescription("New description");

        assertEquals(mEquipment, descriptionChanged);
    }
}
