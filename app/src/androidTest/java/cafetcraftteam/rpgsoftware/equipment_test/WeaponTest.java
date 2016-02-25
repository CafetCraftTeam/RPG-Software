package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import cafetcraftteam.rpgsoftware.equipment.Equipment;
import cafetcraftteam.rpgsoftware.equipment.Weapon;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Class that test the Weapon class
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class WeaponTest
{
    private final String mName = "Bottle";
    private final int mEncumbering = 10;
    private final int mPrice = 100;
    private final Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private final String mDescription = "It's a simple bottle";

    private final Weapon.Group mGroup = Weapon.Group.TWO_HANDED;
    private final Set<Weapon.Qualities> mQualities = EnumSet.of(Weapon.Qualities.ARMOUR_PIERCING);

    private final Weapon mWeapon = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription,
            mGroup, mQualities);

    @Test
    public void creationTest()
    {
        Equipment equipment = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        assertEquals(equipment, mWeapon);
        assertEquals(mGroup, mWeapon.getGroup());
        assertEquals(mQualities, mWeapon.getQualities());
    }

    @Test
    public void contractRespectGroup()
    {
        // group must not be null
        try
        {
            new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription, null, mQualities);
            fail("Null group don't generate an exception");
        } catch (IllegalArgumentException e)
        {
            // success
        }
    }

    @Test
    public void contractRespectQualities()
    {
        // qualities can be null
        Weapon weapon = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription, mGroup, null);
        assertEquals(EnumSet.of(Weapon.Qualities.NONE), weapon.getQualities());

        // qualities can be empty
        Weapon weapon1 = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription, mGroup,
                new HashSet<Weapon.Qualities>());
        assertEquals(EnumSet.of(Weapon.Qualities.NONE), weapon1.getQualities());
    }

    @Test
    public void equalsTest()
    {
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
                Weapon.Group.THROWING, mQualities);
        Weapon otherQualities = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription,
                mGroup, EnumSet.of(Weapon.Qualities.SLOW));

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

    @Test
    public void hashCodeTest()
    {
        Weapon same = mWeapon;
        Weapon deepCopy = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription,
                mGroup, mQualities);
        Weapon otherName = new Weapon("Toto", mEncumbering, mPrice, mQuality, mDescription,
                mGroup, mQualities);
        Weapon otherEncumbering = new Weapon(mName, 1, mPrice, mQuality, mDescription, mGroup,
                mQualities);
        Weapon otherPrice = new Weapon(mName, mEncumbering, 1, mQuality, mDescription, mGroup,
                mQualities);
        Weapon otherQuality = new Weapon(mName, mEncumbering, mPrice, Equipment.Quality.BEST,
                mDescription, mGroup, mQualities);
        Weapon otherDescription = new Weapon(mName, mEncumbering, mPrice, mQuality, "Plop",
                mGroup, mQualities);
        Weapon otherGroup = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription,
                Weapon.Group.FENCING, mQualities);
        Weapon otherQualities = new Weapon(mName, mEncumbering, mPrice, mQuality, mDescription,
                mGroup, EnumSet.of(Weapon.Qualities.IMPACT));

        assertEquals("x=x", mWeapon.hashCode(), mWeapon.hashCode());
        assertEquals("x = same", mWeapon.hashCode(), same.hashCode());
        assertEquals("x = deepCopy", mWeapon.hashCode(), deepCopy.hashCode());
        assertNotSame("x = otherName", mWeapon.hashCode(), otherName.hashCode());
        assertNotSame("x = otherEncumbering", mWeapon.hashCode(), otherEncumbering.hashCode());
        assertNotSame("x = otherPrice", mWeapon.hashCode(), otherPrice.hashCode());
        assertNotSame("x = otherQuality", mWeapon.hashCode(), otherQuality.hashCode());
        assertEquals("x = otherDescription", mWeapon.hashCode(), otherDescription.hashCode());
        assertNotSame("x = otherGroup", mWeapon.hashCode(), otherGroup.hashCode());
        assertNotSame("x = otherQualities", mWeapon.hashCode(), otherQualities.hashCode());
    }

}
