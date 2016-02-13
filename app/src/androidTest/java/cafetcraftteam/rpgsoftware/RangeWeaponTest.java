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
public class RangeWeaponTest
{
    private String mName = "Bottle";
    private int mEncumbering = 10;
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple bottle";
    private String mGroup = "Crossbow";
    private String mQualities = "Armour Piercing";

    private int mShortRange = 24;
    private int mLongRange = 48;
    private double mReload = 1;

    private RangeWeapon rangeWeapon = new RangeWeapon(mName, mEncumbering, mQuality, mDescription,
            mGroup, mQualities, mShortRange, mLongRange, mReload);

    @Test
    public void creationTest() {
        assertEquals(mName, rangeWeapon.getName());
        assertEquals(mEncumbering, rangeWeapon.getEncumbering());
        assertEquals(mQuality, rangeWeapon.getQuality());
        assertEquals(mDescription, rangeWeapon.getDescription());
        assertEquals(mGroup, rangeWeapon.getGroup());
        assertEquals(mQualities, rangeWeapon.getQualities());
        assertEquals(mShortRange, rangeWeapon.getShortRange());
        assertEquals(mLongRange, rangeWeapon.getLongRange());
        assertEquals(mReload, rangeWeapon.getReload());
    }
}
