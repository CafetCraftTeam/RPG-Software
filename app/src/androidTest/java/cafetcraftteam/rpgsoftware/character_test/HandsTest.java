package cafetcraftteam.rpgsoftware.character_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.character.Hands;
import cafetcraftteam.rpgsoftware.equipment.Equipment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Class that test Hands
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HandsTest {
    private final Equipment mLeft = new Equipment(
            "Left hand equipment",
            20,
            1,
            Equipment.Quality.COMMON,
            null
    );

    private final Equipment mRight = new Equipment(
            "Right hand equipment",
            20,
            2,
            Equipment.Quality.COMMON,
            ""
    );

    private final Hands mHands = new Hands(mLeft, mRight);

    @Test
    public void creationTest() {
        assertEquals(mLeft, mHands.getLeft());
        assertEquals(mRight, mHands.getRight());
    }

    @Test
    public void useLeftTest() {
        Equipment differentLeft = new Equipment(
                "Different left hand equipment",
                mLeft.getEncumbering(),
                mLeft.getPrice(),
                mLeft.getQuality(),
                mLeft.getDescription()
        );

        assertEquals(mLeft, mHands.useLeft(differentLeft));

        assertEquals(differentLeft, mHands.getLeft());
        assertNotSame(mLeft, mHands.getLeft());
    }

    @Test
    public void useRightTest() {
        Equipment differentRight = new Equipment(
                "Different right hand equipment",
                mRight.getEncumbering(),
                mRight.getPrice(),
                mRight.getQuality(),
                mRight.getDescription()
        );

        assertEquals(mRight, mHands.useRight(differentRight));

        assertEquals(differentRight, mHands.getRight());
        assertNotSame(mRight, mHands.getRight());
    }

    @Test
    public void useBothTest() {
        Equipment differentBoth = new Equipment(
                "Different Both hand equipment",
                mLeft.getEncumbering(),
                mLeft.getPrice(),
                mLeft.getQuality(),
                mLeft.getDescription()
        );

        Pair<Equipment, Equipment> previousEquipment = new Pair<>(mLeft, mRight);
        assertEquals(previousEquipment, mHands.useBoth(differentBoth));

        assertEquals(differentBoth, mHands.getLeft());
        assertNotSame(mLeft, mHands.getLeft());
        assertEquals(differentBoth, mHands.getRight());
        assertNotSame(mRight, mHands.getRight());
    }
}
