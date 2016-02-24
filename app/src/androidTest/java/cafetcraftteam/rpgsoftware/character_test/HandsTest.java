package cafetcraftteam.rpgsoftware.character_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Pair;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import cafetcraftteam.rpgsoftware.character.Hands;
import cafetcraftteam.rpgsoftware.equipment.Equipment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.fail;

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

    @Before
    public void init() {
        if (mHands.getLeft() != mLeft) {
            mHands.sheatheLeft();
        }
        if (mHands.getRight() != mRight) {
            mHands.sheatheRight();
        }

        if (mHands.getLeft() == null) {
            mHands.unsheatheLeft(mLeft);
        }
        if (mHands.getRight() == null) {
            mHands.unsheatheRight(mRight);
        }
    }

    @Test
    public void creationTest() {
        assertEquals(mLeft, mHands.getLeft());
        assertEquals(mRight, mHands.getRight());
    }

    @Test
    public void unsheatheLeftTest() {
        mHands.sheatheLeft();

        // unsheathe an equipment
        mHands.unsheatheLeft(mLeft);

        assertEquals(mLeft, mHands.getLeft());

        // unsheathe a null equipment should throw an exception
        try {
            mHands.unsheatheLeft(null);
            fail("unsheathe a null equipment should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The equipment must not be null", e.getMessage());
        }

        // unsheathe on not null hands should throw an exception
        try {
            mHands.unsheatheLeft(mLeft);
            fail("unsheathe on not null hands should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("The left hand must be empty to unsheathe something with it", e.getMessage());
        }
    }

    @Test
    public void unsheatheRightTest() {
        mHands.sheatheRight();

        // unsheathe an equipment
        mHands.unsheatheRight(mRight);

        assertEquals(mRight, mHands.getRight());

        // unsheathe a null equipment should throw an exception
        try {
            mHands.unsheatheRight(null);
            fail("unsheathe a null equipment should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The equipment must not be null", e.getMessage());
        }

        // unsheathe on not null hands should throw an exception
        try {
            mHands.unsheatheRight(mRight);
            fail("unsheathe on not null hands should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("The right hand must be empty to unsheathe something with it", e.getMessage());
        }
    }

    @Test
    public void unsheatheBothTest() {
        mHands.sheatheBoth();

        // unsheathe an equipment
        mHands.unsheatheBoth(mLeft);

        assertEquals(mLeft, mHands.getLeft());
        assertEquals(mLeft, mHands.getRight());

        // unsheathe a null equipment should throw an exception
        mHands.sheatheBoth();

        try {
            mHands.unsheatheBoth(null);
            fail("Unsheathe a null equipment should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The equipment must not be null", e.getMessage());
        }

        // unsheathe when only the left hands is empty
        mHands.unsheatheBoth(mRight);
        mHands.sheatheLeft();

        try {
            mHands.unsheatheBoth(mLeft);
            fail("unsheathe when only the left hands is empty should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("Both hands must be empty to unsheathe something with it",
                    e.getMessage());
        }

        // unsheathe when only the right hands is empty
        mHands.unsheatheLeft(mRight);
        mHands.sheatheRight();

        try {
            mHands.unsheatheBoth(mRight);
            fail("unsheathe when only the right hands is empty should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("Both hands must be empty to unsheathe something with it",
                    e.getMessage());
        }
    }

    @Test
    public void sheatheLeftTest() {
        // sheathe left hand
        Equipment previousLeft = mHands.sheatheLeft();

        assertEquals(mLeft, previousLeft);
        assertEquals(null, mHands.getLeft());
        assertEquals(mRight, mHands.getRight());

        // sheathe a null equipment should throw an exception
        try {
            mHands.sheatheLeft();
            fail("sheathe a null equipment should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("The left hand must not be empty", e.getMessage());
        }
    }

    @Test
    public void sheatheRightTest() {
        // sheathe right hand
        Equipment previousRight = mHands.sheatheRight();

        assertEquals(mRight, previousRight);
        assertEquals(null, mHands.getRight());
        assertEquals(mLeft, mHands.getLeft());

        // sheathe a null equipment should throw an exception
        try {
            mHands.sheatheRight();
            fail("sheathe a null equipment should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("The right hand must not be empty", e.getMessage());
        }
    }

    @Test
    public void sheatheBothTest() {
        // sheathe both hands
        List<Equipment> previousBoth = mHands.sheatheBoth();

        assertEquals(2, previousBoth.size());
        assertEquals(mLeft, previousBoth.get(0));
        assertEquals(mRight, previousBoth.get(1));
        assertEquals(null, mHands.getLeft());
        assertEquals(null, mHands.getRight());

        // sheathe when a null equipment is in the right hand should not throw an exception
        mHands.unsheatheLeft(mLeft);

        List<Equipment> nullRight = mHands.sheatheBoth();

        assertEquals(1, nullRight.size());
        assertEquals(mLeft, nullRight.get(0));
        assertEquals(null, mHands.getLeft());
        assertEquals(null, mHands.getRight());

        // sheathe when a null equipment is in the left hand should not throw an exception
        mHands.unsheatheRight(mRight);

        List<Equipment> nullLeft = mHands.sheatheBoth();

        assertEquals(1, nullLeft.size());
        assertEquals(mRight, nullLeft.get(0));
        assertEquals(null, mHands.getLeft());
        assertEquals(null, mHands.getRight());
    }
}
