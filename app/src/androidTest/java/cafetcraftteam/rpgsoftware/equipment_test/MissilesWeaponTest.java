package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.EnumSet;
import java.util.Set;

import cafetcraftteam.rpgsoftware.equipment.Equipment;
import cafetcraftteam.rpgsoftware.equipment.MissilesWeapon;
import cafetcraftteam.rpgsoftware.equipment.Weapon;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Class that test the MissileWeapon class
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MissilesWeaponTest
{
    private final String mName = "Bottle";
    private final int mEncumbering = 10;
    private final int mPrice = 100;
    private final Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private final String mDescription = "It's a simple bottle";
    private final Weapon.Group mGroup = Weapon.Group.LONGBOW;
    private final Set<Weapon.Qualities> mQualities = EnumSet.of(Weapon.Qualities.DEFENSIVE);

    private final int mShortRange = 24;
    private final int mLongRange = 48;
    private final double mReload = 1;

    private final MissilesWeapon mMissilesWeapon = new MissilesWeapon(mName, mEncumbering, mPrice,
            mQuality, mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);

    @Test
    public void creationTest()
    {
        Equipment equipment = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        assertEquals(equipment, mMissilesWeapon);
        assertEquals(mGroup, mMissilesWeapon.getGroup());
        assertEquals(mQualities, mMissilesWeapon.getQualities());
        assertEquals(mShortRange, mMissilesWeapon.getShortRange());
        assertEquals(mLongRange, mMissilesWeapon.getLongRange());
        assertEquals(mReload, mMissilesWeapon.getReload());
    }

    @Test
    public void contractRespectShortRange()
    {
        // short range must be positive
        try
        {
            new MissilesWeapon(mName, mEncumbering, mPrice, mQuality, mDescription, mGroup, mQualities,
                    -mShortRange, mLongRange, mReload);
            fail("Negative short range don't generate an exception");
        } catch (IllegalArgumentException e)
        {
            // success
        }

        // short range could be zero
        MissilesWeapon missilesWeapon = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, 0, mLongRange, mReload);
        assertEquals(0, missilesWeapon.getShortRange());
    }

    @Test
    public void contractRespectLongRange()
    {
        // long range must be positive
        try
        {
            new MissilesWeapon(mName, mEncumbering, mPrice, mQuality, mDescription, mGroup, mQualities,
                    mShortRange, -mLongRange, mReload);
            fail("Negative long range don't generate an exception");
        } catch (IllegalArgumentException e)
        {
            // success
        }

        // long range could be zero
        MissilesWeapon missilesWeapon = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, 0, 0, mReload);
        assertEquals(0, missilesWeapon.getLongRange());

        // long range must be greater than short range or it will be swap
        MissilesWeapon missilesWeapon1 = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, 0, mReload);
        assertEquals(mShortRange, missilesWeapon1.getLongRange());
    }

    @Test
    public void contractRespectReload()
    {
        // Reload must not be null
        try
        {
            new MissilesWeapon(mName, mEncumbering, mPrice, mQuality, mDescription, mGroup, mQualities,
                    mShortRange, mLongRange, -mReload);
            fail("Negative Reload don't generate an exception");
        } catch (IllegalArgumentException e)
        {
            // success
        }

        // Reload could be zero
        MissilesWeapon missilesWeapon = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, 0);
        assertEquals(0.0, missilesWeapon.getReload());
    }

    @Test
    public void equalsTest()
    {
        MissilesWeapon same = mMissilesWeapon;
        MissilesWeapon deepCopy = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherName = new MissilesWeapon("Toto", mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherEncumbering = new MissilesWeapon(mName, 1, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherPrice = new MissilesWeapon(mName, mEncumbering, 1, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherQuality = new MissilesWeapon(mName, mEncumbering, mPrice,
                Equipment.Quality.BEST, mDescription, mGroup, mQualities, mShortRange, mLongRange,
                mReload);
        MissilesWeapon otherDescription = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                "Plop", mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherGroup = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, Weapon.Group.THROWING, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherQualities = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, EnumSet.of(Weapon.Qualities.SLOW), mShortRange, mLongRange,
                mReload);
        MissilesWeapon otherShortRange = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, 12, mLongRange,mReload);
        MissilesWeapon otherLongRange = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, 72,mReload);
        MissilesWeapon otherReload = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange,0.5);

        assertFalse("x=null", mMissilesWeapon.equals(null));
        assertTrue("x=x", mMissilesWeapon.equals(mMissilesWeapon));
        assertTrue("x = same", mMissilesWeapon.equals(same));
        assertTrue("x = deepCopy", mMissilesWeapon.equals(deepCopy));
        assertFalse("x = otherName", mMissilesWeapon.equals(otherName));
        assertFalse("otherName = x", otherName.equals(mMissilesWeapon));
        assertFalse("x = otherEncumbering", mMissilesWeapon.equals(otherEncumbering));
        assertFalse("x = otherPrice", mMissilesWeapon.equals(otherPrice));
        assertFalse("x = otherQuality", mMissilesWeapon.equals(otherQuality));
        assertTrue("x = otherDescription", mMissilesWeapon.equals(otherDescription));
        assertFalse("x = otherGroup", mMissilesWeapon.equals(otherGroup));
        assertFalse("x = otherQualities", mMissilesWeapon.equals(otherQualities));
        assertFalse("x = otherShortRange", mMissilesWeapon.equals(otherShortRange));
        assertFalse("x = otherLongRange", mMissilesWeapon.equals(otherLongRange));
        assertFalse("x = otherReload", mMissilesWeapon.equals(otherReload));
    }

    @Test
    public void hashCodeTest()
    {
        MissilesWeapon same = mMissilesWeapon;
        MissilesWeapon deepCopy = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherName = new MissilesWeapon("Toto", mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherEncumbering = new MissilesWeapon(mName, 1, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherPrice = new MissilesWeapon(mName, mEncumbering, 1, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherQuality = new MissilesWeapon(mName, mEncumbering, mPrice,
                Equipment.Quality.BEST, mDescription, mGroup, mQualities, mShortRange, mLongRange,
                mReload);
        MissilesWeapon otherDescription = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                "Plop", mGroup, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherGroup = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, Weapon.Group.THROWING, mQualities, mShortRange, mLongRange, mReload);
        MissilesWeapon otherQualities = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, EnumSet.of(Weapon.Qualities.SLOW), mShortRange, mLongRange,
                mReload);
        MissilesWeapon otherShortRange = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, 12, mLongRange,mReload);
        MissilesWeapon otherLongRange = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, 72,mReload);
        MissilesWeapon otherReload = new MissilesWeapon(mName, mEncumbering, mPrice, mQuality,
                mDescription, mGroup, mQualities, mShortRange, mLongRange,0.5);

        assertEquals("x=x", mMissilesWeapon.hashCode(), mMissilesWeapon.hashCode());
        assertEquals("x = same", mMissilesWeapon.hashCode(), same.hashCode());
        assertEquals("x = deepCopy", mMissilesWeapon.hashCode(), deepCopy.hashCode());
        assertNotSame("x = otherName", mMissilesWeapon.hashCode(), otherName.hashCode());
        assertNotSame("x = otherEncumbering", mMissilesWeapon.hashCode(), otherEncumbering.hashCode());
        assertNotSame("x = otherPrice", mMissilesWeapon.hashCode(), otherPrice.hashCode());
        assertNotSame("x = otherQuality", mMissilesWeapon.hashCode(), otherQuality.hashCode());
        assertEquals("x = otherDescription", mMissilesWeapon.hashCode(), otherDescription.hashCode());
        assertNotSame("x = otherGroup", mMissilesWeapon.hashCode(), otherGroup.hashCode());
        assertNotSame("x = otherQualities", mMissilesWeapon.hashCode(), otherQualities.hashCode());
        assertNotSame("x = otherShortRange", mMissilesWeapon.hashCode(), otherShortRange.hashCode());
        assertNotSame("x = otherLongRange", mMissilesWeapon.hashCode(), otherLongRange.hashCode());
        assertNotSame("x = otherReload", mMissilesWeapon.hashCode(), otherReload.hashCode());
    }
}
