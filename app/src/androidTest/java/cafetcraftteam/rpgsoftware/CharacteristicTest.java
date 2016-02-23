package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by Gautier on 22/02/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacteristicTest {
    private final int mWeaponSkill = 30;
    private final int mBallisticSkill = 40;
    private final int mStrength = 35;
    private final int mToughness = 45;
    private final int mAgility = 50;
    private final int mIntelligence = 60;
    private final int mWillPower = 25;
    private final int mFellowship = 15;
    private final int mAttacks = 1;
    private final int mWounds = 13;
    private final int mMovement = 4;
    private final int mMagic = 2;
    private final int mInsanityPoints = 1;
    private final int mFatePoints = 1;

    private Characteristic mCharacteristic;

    @Before
    public void initiate() throws InstantiationException {
        mCharacteristic = new Characteristic(
                mWeaponSkill,
                mBallisticSkill,
                mStrength,
                mToughness,
                mAgility,
                mIntelligence,
                mWillPower,
                mFellowship,
                mAttacks,
                mWounds,
                mMovement,
                mMagic,
                mInsanityPoints,
                mFatePoints
        );
    }

    @Test
    public void creationTest() {
        assertEquals(mWeaponSkill, mCharacteristic.getWeaponSkill());
        assertEquals(mBallisticSkill, mCharacteristic.getBallisticSkill());
        assertEquals(mStrength, mCharacteristic.getStrength());
        assertEquals(mToughness, mCharacteristic.getToughness());
        assertEquals(mAgility, mCharacteristic.getAgility());
        assertEquals(mIntelligence, mCharacteristic.getIntelligence());
        assertEquals(mWillPower, mCharacteristic.getWillPower());
        assertEquals(mFellowship, mCharacteristic.getFellowship());
        assertEquals(mAttacks, mCharacteristic.getAttacks());
        assertEquals(mWounds, mCharacteristic.getWounds());
        assertEquals(mStrength / 10, mCharacteristic.getStrengthBonus());
        assertEquals(mToughness / 10, mCharacteristic.getToughnessBonus());
        assertEquals(mMovement, mCharacteristic.getMovement());
        assertEquals(mMagic, mCharacteristic.getMagic());
        assertEquals(mInsanityPoints, mCharacteristic.getInsanityPoints());
        assertEquals(mFatePoints, mCharacteristic.getFatePoints());
    }

    // region CONTRACT RESPECT TEST=================================================================
    @Test
    public void contractRespectWeaponSkill() {
        // the weapon skill must be positive
        try {
            new Characteristic(
                    -mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative weapon skill have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The weapon skill must be strictly positive", e.getMessage());
        }

        // the weapon skill must different from zero
        try {
            new Characteristic(
                    0,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero weapon skill have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The weapon skill must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectBallisticSkill() {
        // the ballistic skill must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    -mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative ballistic skill have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The ballistic skill must be strictly positive", e.getMessage());
        }

        // the ballistic skill must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    0,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero ballistic skill have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The ballistic skill must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectStrength() {
        // the strength must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    -mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative strength have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The strength must be strictly positive", e.getMessage());
        }

        // the strength must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    0,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero strength have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The strength must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectToughness() {
        // the toughness must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    -mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative toughness have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The toughness must be strictly positive", e.getMessage());
        }

        // the toughness must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    0,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero toughness have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The toughness must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectAgility() {
        // the agility must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    -mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative agility have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The agility must be strictly positive", e.getMessage());
        }

        // the agility must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    0,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero agility have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The agility must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectIntelligence() {
        // the intelligence must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    -mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative intelligence have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The intelligence must be strictly positive", e.getMessage());
        }

        // the intelligence must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    0,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero intelligence have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The intelligence must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectWillPower() {
        // the will power must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    -mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative will power have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The will power must be strictly positive", e.getMessage());
        }

        // the will power must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    0,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero will power have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The will power must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectFellowship() {
        // the fellowship must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    -mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative fellowship have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The fellowship must be strictly positive", e.getMessage());
        }

        // the fellowship must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    0,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero fellowship have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The fellowship must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectAttacks() throws InstantiationException {
        // the number of attacks must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    -mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative number of attacks have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The number of attacks must be positive", e.getMessage());
        }

        // the number of attacks can be zero
        Characteristic zeroAttack = new Characteristic(
                mWeaponSkill,
                mBallisticSkill,
                mStrength,
                mToughness,
                mAgility,
                mIntelligence,
                mWillPower,
                mFellowship,
                0,
                mWounds,
                mMovement,
                mMagic,
                mInsanityPoints,
                mFatePoints
        );
        assertEquals(0, zeroAttack.getAttacks());
    }

    @Test
    public void contractRespectWounds() {
        // the number of wounds must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    -mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative number of wounds have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The number of wounds must be strictly positive", e.getMessage());
        }

        // the number of wounds must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    0,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero number of wounds have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The number of wounds must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectMovement() {
        // the movement must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    -mMovement,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative movement have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The movement must be strictly positive", e.getMessage());
        }

        // the movement must different from zero
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    0,
                    mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A zero movement have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The movement must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectMagic() throws InstantiationException {
        // the magic must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    -mMagic,
                    mInsanityPoints,
                    mFatePoints
            );
            fail("A negative magic have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The magic must be positive", e.getMessage());
        }

        // the magic can be zero
        Characteristic zeroMagic = new Characteristic(
                mWeaponSkill,
                mBallisticSkill,
                mStrength,
                mToughness,
                mAgility,
                mIntelligence,
                mWillPower,
                mFellowship,
                mAttacks,
                mWounds,
                mMovement,
                0,
                mInsanityPoints,
                mFatePoints
        );
        assertEquals(0, zeroMagic.getMagic());
    }

    @Test
    public void contractRespectInsanityPoints() throws InstantiationException {
        // the number of insanity points must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    -mInsanityPoints,
                    mFatePoints
            );
            fail("A negative number of insanity points have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The number of insanity points must be positive", e.getMessage());
        }

        // the number of insanity points can be zero
        Characteristic zeroInsanityPoints = new Characteristic(
                mWeaponSkill,
                mBallisticSkill,
                mStrength,
                mToughness,
                mAgility,
                mIntelligence,
                mWillPower,
                mFellowship,
                mAttacks,
                mWounds,
                mMovement,
                mMagic,
                0,
                mFatePoints
        );
        assertEquals(0, zeroInsanityPoints.getInsanityPoints());
    }

    @Test
    public void contractRespectFatePoints() throws InstantiationException {
        // the number of fate points must be positive
        try {
            new Characteristic(
                    mWeaponSkill,
                    mBallisticSkill,
                    mStrength,
                    mToughness,
                    mAgility,
                    mIntelligence,
                    mWillPower,
                    mFellowship,
                    mAttacks,
                    mWounds,
                    mMovement,
                    mMagic,
                    mInsanityPoints,
                    -mFatePoints
            );
            fail("A negative number of fate points have not throw an exception");
        } catch (InstantiationException e) {
            assertEquals("The number of fate points must be positive", e.getMessage());
        }

        // the number of fate points can be zero
        Characteristic zeroFatePoints = new Characteristic(
                mWeaponSkill,
                mBallisticSkill,
                mStrength,
                mToughness,
                mAgility,
                mIntelligence,
                mWillPower,
                mFellowship,
                mAttacks,
                mWounds,
                mMovement,
                mMagic,
                mInsanityPoints,
                0
        );
        assertEquals(0, zeroFatePoints.getFatePoints());
    }
    //endregion=====================================================================================

    // region SETTER TEST===========================================================================
    @Test
    public void setterWeaponSkill() {
        // can set a positive value
        int positiveWeaponSkill = 53;
        mCharacteristic.setWeaponSkill(positiveWeaponSkill);
        assertEquals(positiveWeaponSkill, mCharacteristic.getWeaponSkill());
        mCharacteristic.setWeaponSkill(mWeaponSkill);

        // cannot set a negative value
        int negativeWeaponSkill = -26;
        try {
            mCharacteristic.setWeaponSkill(negativeWeaponSkill);
            fail("Setting a negative as weapon skill have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The weapon skill must be strictly positive", e.getMessage());
        }
        mCharacteristic.setWeaponSkill(mWeaponSkill);

        // cannot set a zero value
        int zeroWeaponSkill = 0;
        try {
            mCharacteristic.setWeaponSkill(zeroWeaponSkill);
            fail("Setting a zero as weapon skill have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The weapon skill must be strictly positive", e.getMessage());
        }
        mCharacteristic.setWeaponSkill(mWeaponSkill);
    }

    @Test
    public void setterBallisticSkill() {
        // can set a positive value
        int positiveBallisticSkill = 99;
        mCharacteristic.setBallisticSkill(positiveBallisticSkill);
        assertEquals(positiveBallisticSkill, mCharacteristic.getBallisticSkill());
        mCharacteristic.setBallisticSkill(mBallisticSkill);

        // cannot set a negative value
        int negativeBallisticSkill = -1;
        try {
            mCharacteristic.setBallisticSkill(negativeBallisticSkill);
            fail("Setting a negative as ballistic skill have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The ballistic skill must be strictly positive", e.getMessage());
        }
        mCharacteristic.setBallisticSkill(mBallisticSkill);

        // cannot set a zero value
        int zeroBallisticSkill = 0;
        try {
            mCharacteristic.setBallisticSkill(zeroBallisticSkill);
            fail("Setting a zero as ballistic skill have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The ballistic skill must be strictly positive", e.getMessage());
        }
        mCharacteristic.setBallisticSkill(mBallisticSkill);
    }

    @Test
    public void setterStrength() {
        // can set a positive value
        int positiveStrength = 23;
        mCharacteristic.setStrength(positiveStrength);
        assertEquals(positiveStrength, mCharacteristic.getStrength());
        mCharacteristic.setStrength(mStrength);

        // cannot set a negative value
        int negativeStrength = -46;
        try {
            mCharacteristic.setStrength(negativeStrength);
            fail("Setting a negative as strength have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The strength must be strictly positive", e.getMessage());
        }
        mCharacteristic.setStrength(mStrength);

        // cannot set a zero value
        int zeroStrength = 0;
        try {
            mCharacteristic.setStrength(zeroStrength);
            fail("Setting a zero as strength have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The strength must be strictly positive", e.getMessage());
        }
        mCharacteristic.setStrength(mStrength);
    }

    @Test
    public void setterToughness() {
        // can set a positive value
        int positiveToughness = 53;
        mCharacteristic.setToughness(positiveToughness);
        assertEquals(positiveToughness, mCharacteristic.getToughness());
        mCharacteristic.setToughness(mToughness);

        // cannot set a negative value
        int negativeToughness = -26;
        try {
            mCharacteristic.setToughness(negativeToughness);
            fail("Setting a negative as toughness have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The toughness must be strictly positive", e.getMessage());
        }
        mCharacteristic.setToughness(mToughness);

        // cannot set a zero value
        int zeroToughness = 0;
        try {
            mCharacteristic.setToughness(zeroToughness);
            fail("Setting a zero as toughness have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The toughness must be strictly positive", e.getMessage());
        }
        mCharacteristic.setToughness(mToughness);
    }

    @Test
    public void setterAgility() {
        // can set a positive value
        int positiveAgility = 36;
        mCharacteristic.setAgility(positiveAgility);
        assertEquals(positiveAgility, mCharacteristic.getAgility());
        mCharacteristic.setAgility(mAgility);

        // cannot set a negative value
        int negativeAgility = -17;
        try {
            mCharacteristic.setAgility(negativeAgility);
            fail("Setting a negative as agility have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The agility must be strictly positive", e.getMessage());
        }
        mCharacteristic.setAgility(mAgility);

        // cannot set a zero value
        int zeroAgility = 0;
        try {
            mCharacteristic.setAgility(zeroAgility);
            fail("Setting a zero as agility have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The agility must be strictly positive", e.getMessage());
        }
        mCharacteristic.setAgility(mAgility);
    }

    @Test
    public void setterIntelligence() {
        // can set a positive value
        int positiveIntelligence = 84;
        mCharacteristic.setIntelligence(positiveIntelligence);
        assertEquals(positiveIntelligence, mCharacteristic.getIntelligence());
        mCharacteristic.setIntelligence(mIntelligence);

        // cannot set a negative value
        int negativeIntelligence = -46;
        try {
            mCharacteristic.setIntelligence(negativeIntelligence);
            fail("Setting a negative as intelligence have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The intelligence must be strictly positive", e.getMessage());
        }
        mCharacteristic.setIntelligence(mIntelligence);

        // cannot set a zero value
        int zeroIntelligence = 0;
        try {
            mCharacteristic.setIntelligence(zeroIntelligence);
            fail("Setting a zero as intelligence have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The intelligence must be strictly positive", e.getMessage());
        }
        mCharacteristic.setIntelligence(mIntelligence);
    }

    @Test
    public void setterWillPower() {
        // can set a positive value
        int positiveWillPower = 35;
        mCharacteristic.setWillPower(positiveWillPower);
        assertEquals(positiveWillPower, mCharacteristic.getWillPower());
        mCharacteristic.setWillPower(mWillPower);

        // cannot set a negative value
        int negativeWillPower = -74;
        try {
            mCharacteristic.setWillPower(negativeWillPower);
            fail("Setting a negative as will power have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The will power must be strictly positive", e.getMessage());
        }
        mCharacteristic.setWillPower(mWillPower);

        // cannot set a zero value
        int zeroWillPower = 0;
        try {
            mCharacteristic.setWillPower(zeroWillPower);
            fail("Setting a zero as will power have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The will power must be strictly positive", e.getMessage());
        }
        mCharacteristic.setWillPower(mWillPower);
    }

    @Test
    public void setterFellowship() {
        // can set a positive value
        int positiveFellowship = 55;
        mCharacteristic.setFellowship(positiveFellowship);
        assertEquals(positiveFellowship, mCharacteristic.getFellowship());
        mCharacteristic.setFellowship(mFellowship);

        // cannot set a negative value
        int negativeFellowship = -73;
        try {
            mCharacteristic.setFellowship(negativeFellowship);
            fail("Setting a negative as fellowship have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The fellowship must be strictly positive", e.getMessage());
        }
        mCharacteristic.setFellowship(mFellowship);

        // cannot set a zero value
        int zeroFellowship = 0;
        try {
            mCharacteristic.setFellowship(zeroFellowship);
            fail("Setting a zero as fellowship have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The fellowship must be strictly positive", e.getMessage());
        }
        mCharacteristic.setFellowship(mFellowship);
    }

    @Test
    public void setterAttacks() {
        // can set a positive value
        int positiveAttacks = 10;
        mCharacteristic.setAttacks(positiveAttacks);
        assertEquals(positiveAttacks, mCharacteristic.getAttacks());
        mCharacteristic.setAttacks(mAttacks);

        // cannot set a negative value
        int negativeAttacks = -6;
        try {
            mCharacteristic.setAttacks(negativeAttacks);
            fail("Setting a negative as number of attacks have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The number of attacks must be positive", e.getMessage());
        }
        mCharacteristic.setAttacks(mAttacks);

        // can set a zero value
        int zeroAttacks = 0;
        mCharacteristic.setAttacks(zeroAttacks);
        assertEquals(zeroAttacks, mCharacteristic.getAttacks());
        mCharacteristic.setAttacks(mAttacks);
    }

    @Test
    public void setterWounds() {
        // can set a positive value
        int positiveWounds = 17;
        mCharacteristic.setWounds(positiveWounds);
        assertEquals(positiveWounds, mCharacteristic.getWounds());
        mCharacteristic.setWounds(mWounds);

        // cannot set a negative value
        int negativeWounds = -3;
        try {
            mCharacteristic.setWounds(negativeWounds);
            fail("Setting a negative as wounds have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The wounds must be strictly positive", e.getMessage());
        }
        mCharacteristic.setWounds(mWounds);

        // cannot set a zero value
        int zeroWounds = 0;
        try {
            mCharacteristic.setWounds(zeroWounds);
            fail("Setting a zero as wounds have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The wounds must be strictly positive", e.getMessage());
        }
        mCharacteristic.setWounds(mWounds);
    }

    @Test
    public void setterMovement() {
        // can set a positive value
        int positiveMovement = 1;
        mCharacteristic.setMovement(positiveMovement);
        assertEquals(positiveMovement, mCharacteristic.getMovement());
        mCharacteristic.setMovement(mMovement);

        // cannot set a negative value
        int negativeMovement = -9;
        try {
            mCharacteristic.setMovement(negativeMovement);
            fail("Setting a negative as movement have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The movement must be strictly positive", e.getMessage());
        }
        mCharacteristic.setMovement(mMovement);

        // cannot set a zero value
        int zeroMovement = 0;
        try {
            mCharacteristic.setMovement(zeroMovement);
            fail("Setting a zero as movement have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The movement must be strictly positive", e.getMessage());
        }
        mCharacteristic.setMovement(mMovement);
    }

    @Test
    public void setterMagic() {
        // can set a positive value
        int positiveMagic = 5;
        mCharacteristic.setMagic(positiveMagic);
        assertEquals(positiveMagic, mCharacteristic.getMagic());
        mCharacteristic.setMagic(mMagic);

        // cannot set a negative value
        int negativeMagic = -2;
        try {
            mCharacteristic.setMagic(negativeMagic);
            fail("Setting a negative as magic have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The magic must be positive", e.getMessage());
        }
        mCharacteristic.setMagic(mMagic);

        // can set a zero value
        int zeroMagic = 0;
        mCharacteristic.setMagic(zeroMagic);
        assertEquals(zeroMagic, mCharacteristic.getMagic());
        mCharacteristic.setMagic(mMagic);
    }

    @Test
    public void setterInsanityPoints() {
        // can set a positive value
        int positiveInsanityPoints = 53;
        mCharacteristic.setInsanityPoints(positiveInsanityPoints);
        assertEquals(positiveInsanityPoints, mCharacteristic.getInsanityPoints());
        mCharacteristic.setInsanityPoints(mInsanityPoints);

        // cannot set a negative value
        int negativeInsanityPoints = -26;
        try {
            mCharacteristic.setInsanityPoints(negativeInsanityPoints);
            fail("Setting a negative as number of insanity points have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The number of insanity points must be positive", e.getMessage());
        }
        mCharacteristic.setInsanityPoints(mInsanityPoints);

        // can set a zero value
        int zeroInsanityPoints = 0;
        mCharacteristic.setInsanityPoints(zeroInsanityPoints);
        assertEquals(zeroInsanityPoints, mCharacteristic.getInsanityPoints());
        mCharacteristic.setInsanityPoints(mInsanityPoints);
    }

    @Test
    public void setterFatePoints() {
        // can set a positive value
        int positiveFatePoints = 99;
        mCharacteristic.setFatePoints(positiveFatePoints);
        assertEquals(positiveFatePoints, mCharacteristic.getFatePoints());
        mCharacteristic.setFatePoints(mFatePoints);

        // cannot set a negative value
        int negativeFatePoints = -1;
        try {
            mCharacteristic.setFatePoints(negativeFatePoints);
            fail("Setting a negative as number of fate points have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The number of fate points must be positive", e.getMessage());
        }
        mCharacteristic.setFatePoints(mFatePoints);

        // can set a zero value
        int zeroFatePoints = 0;
        mCharacteristic.setFatePoints(zeroFatePoints);
        assertEquals(zeroFatePoints, mCharacteristic.getFatePoints());
        mCharacteristic.setFatePoints(mFatePoints);
    }
    // endregion====================================================================================
}
