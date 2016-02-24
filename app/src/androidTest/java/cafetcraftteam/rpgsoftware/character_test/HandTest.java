package cafetcraftteam.rpgsoftware.character_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.character.Hand;
import cafetcraftteam.rpgsoftware.equipment.Equipment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Class that test Hand
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HandTest {
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

    private final Hand mHand = new Hand(mLeft, mRight);

    @Test
    public void creationTest() {
        assertEquals(mLeft, mHand.getLeft());
        assertEquals(mRight, mHand.getRight());
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

        mHand.useLeft(differentLeft);

        assertEquals(differentLeft, mHand.getLeft());
        assertNotSame(mLeft, mHand.getLeft());
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

        mHand.useRight(differentRight);

        assertEquals(differentRight, mHand.getRight());
        assertNotSame(mRight, mHand.getRight());
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

        mHand.useBoth(differentBoth);

        assertEquals(differentBoth, mHand.getLeft());
        assertNotSame(mLeft, mHand.getLeft());
        assertEquals(differentBoth, mHand.getRight());
        assertNotSame(mRight, mHand.getRight());
    }
}
