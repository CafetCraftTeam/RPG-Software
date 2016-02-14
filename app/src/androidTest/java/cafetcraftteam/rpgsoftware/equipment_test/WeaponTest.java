package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.equipment.Equipment;
import cafetcraftteam.rpgsoftware.equipment.Weapon;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Gautier on 11/02/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class WeaponTest
{
    private String mName = "Bottle";
    private int mEncumbering = 10;
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple bottle";

    private String mGroup = "Two-Handed";
    private String mQualities = "Armour Piercing";

    private Weapon weapon = new Weapon(mName, mEncumbering, mQuality, mDescription, mGroup,
            mQualities);

    @Test
    public void creationTest() {
        assertEquals(mName, weapon.getName());
        assertEquals(mEncumbering, weapon.getEncumbering());
        assertEquals(mQuality, weapon.getQuality());
        assertEquals(mDescription, weapon.getDescription());
        assertEquals(mGroup, weapon.getGroup());
        assertEquals(mQualities, weapon.getQualities());
    }

}
