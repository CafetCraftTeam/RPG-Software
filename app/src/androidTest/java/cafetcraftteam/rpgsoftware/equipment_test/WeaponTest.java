package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.equipment.Equipment;
import cafetcraftteam.rpgsoftware.equipment.Weapon;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Gautier on 11/02/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class WeaponTest
{
    private String mName = "Bottle";
    private int mEncumbering = 10;
    private int mPrice = 100;
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple bottle";

    private String mGroup = "Two-Handed";
    private String mQualities = "Armour Piercing";

    private Weapon mWeapon = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription, mGroup,
            mQualities);

    @Test
    public void creationTest() {
        Equipment equipment = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        assertEquals(equipment, mWeapon);
        assertEquals(mGroup, mWeapon.getGroup());
        assertEquals(mQualities, mWeapon.getQualities());
    }

    @Test
    public void equalsTest() {
        Weapon same = mWeapon;
        Weapon deepCopy = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription, mGroup,
                mQualities);
        Weapon otherName = new Weapon("Toto", mEncumbering, mPrice, mQuality, mDescription, mGroup,
                mQualities);
        Weapon otherEncumbering = new Weapon(mName, 1, mPrice, mQuality, mDescription, mGroup,
                mQualities);
        Weapon otherPrice = new Weapon(mName, mEncumbering, 1, mQuality, mDescription, mGroup,
                mQualities);
        Weapon otherQuality = new Weapon(mName, mEncumbering, mPrice, Equipment.Quality.BEST,
                mDescription, mGroup, mQualities);
        Weapon otherDescription = new Weapon(mName, mEncumbering, mPrice, mQuality, "Plop", mGroup,
                mQualities);
        Weapon otherGroup = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription,
                "Plop", mQualities);
        Weapon otherQualities = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription,
                mGroup, "Sharp");

        assertFalse("x=null", mWeapon.equals(null));
        assertTrue("x=x", mWeapon.equals(mWeapon));
        assertTrue("x = same", mWeapon.equals(same));
        assertTrue("x = deepCopy", mWeapon.equals(deepCopy));
        assertFalse("x = otherName", mWeapon.equals(otherName));
        assertFalse("otherName = x", otherName.equals(mWeapon));
        assertFalse("x = otherEncumbering", mWeapon.equals(otherEncumbering));
        assertFalse("x = otherPrice", mWeapon.equals(otherPrice));
        assertFalse("x = otherQuality", mWeapon.equals(otherQuality));
        assertTrue("x = otherDescription", mWeapon.equals(otherDescription));
        assertFalse("x = otherGroup", mWeapon.equals(otherGroup));
        assertFalse("x = otherQualities", mWeapon.equals(otherQualities));
    }

}
