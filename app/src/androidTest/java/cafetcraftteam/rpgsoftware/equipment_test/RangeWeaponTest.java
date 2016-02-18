package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.equipment.Equipment;
import cafetcraftteam.rpgsoftware.equipment.RangeWeapon;
import cafetcraftteam.rpgsoftware.equipment.Weapon;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Gautier on 11/02/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RangeWeaponTest
{
    private String mName = "Bottle";
    private int mEncumbering = 10;
    private int mPrice = 100;
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple bottle";
    private Weapon.Group mGroup = Weapon.Group.LONGBOW;
    private Weapon.Qualities mQualities = Weapon.Qualities.DEFENSIVE;

    private int mShortRange = 24;
    private int mLongRange = 48;
    private double mReload = 1;

    private RangeWeapon mRangeWeapon = new RangeWeapon(mName, mEncumbering, mPrice, mQuality,
            mDescription, mGroup, mQualities, mShortRange, mLongRange, mReload);

    @Test
    public void creationTest() {
        Equipment equipment = new Equipment(mName, mEncumbering, mPrice, mQuality, mDescription);
        assertEquals(equipment, mRangeWeapon);
        assertEquals(mGroup, mRangeWeapon.getGroup());
        assertEquals(mQualities, mRangeWeapon.getQualities());
        assertEquals(mShortRange, mRangeWeapon.getShortRange());
        assertEquals(mLongRange, mRangeWeapon.getLongRange());
        assertEquals(mReload, mRangeWeapon.getReload());
    }
}
