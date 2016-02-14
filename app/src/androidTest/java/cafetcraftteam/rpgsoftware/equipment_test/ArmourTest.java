package cafetcraftteam.rpgsoftware.equipment_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.equipment.Equipment;

/**
 * Created by Gautier on 14/02/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ArmourTest
{
    private String mName = "Bottle";
    private int mEncumbering = 10;
    private Equipment.Quality mQuality = Equipment.Quality.COMMON;
    private String mDescription = "It's a simple bottle";

    private int mArmourPoint = 2;
}
