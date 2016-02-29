package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Class that testing the characteristic class
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProfileTest {
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

    private Profile mProfile;

    @Before
    public void initiate() throws InstantiationException {
        mProfile = new Profile(
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
        assertEquals(mWeaponSkill, mProfile.getWeaponSkill());
        assertEquals(mBallisticSkill, mProfile.getBallisticSkill());
        assertEquals(mStrength, mProfile.getStrength());
        assertEquals(mToughness, mProfile.getToughness());
        assertEquals(mAgility, mProfile.getAgility());
        assertEquals(mIntelligence, mProfile.getIntelligence());
        assertEquals(mWillPower, mProfile.getWillPower());
        assertEquals(mFellowship, mProfile.getFellowship());
        assertEquals(mAttacks, mProfile.getAttacks());
        assertEquals(mWounds, mProfile.getWounds());
        assertEquals(mStrength / 10, mProfile.getStrengthBonus());
        assertEquals(mToughness / 10, mProfile.getToughnessBonus());
        assertEquals(mMovement, mProfile.getMovement());
        assertEquals(mMagic, mProfile.getMagic());
        assertEquals(mInsanityPoints, mProfile.getInsanityPoints());
        assertEquals(mFatePoints, mProfile.getFatePoints());
    }

    // region CONTRACT RESPECT TEST=================================================================
    @Test
    public void contractRespectWeaponSkill() {
        // the weapon skill must be positive
        try {
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
        Profile zeroAttack = new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
            new Profile(
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
        Profile zeroMagic = new Profile(
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
            new Profile(
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
        Profile zeroInsanityPoints = new Profile(
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
            new Profile(
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
        Profile zeroFatePoints = new Profile(
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

    @Test
    public void getPrimaryTest() {
        assertEquals(mWeaponSkill,
                mProfile.getCharacteristic(Profile.Primary.WS));
        assertEquals(mBallisticSkill,
                mProfile.getCharacteristic(Profile.Primary.BS));
        assertEquals(mStrength,
                mProfile.getCharacteristic(Profile.Primary.S));
        assertEquals(mToughness,
                mProfile.getCharacteristic(Profile.Primary.T));
        assertEquals(mAgility,
                mProfile.getCharacteristic(Profile.Primary.AG));
        assertEquals(mIntelligence,
                mProfile.getCharacteristic(Profile.Primary.INT));
        assertEquals(mWillPower,
                mProfile.getCharacteristic(Profile.Primary.WP));
        assertEquals(mFellowship,
                mProfile.getCharacteristic(Profile.Primary.FEL));
    }

    @Test
    public void getSecondaryTest() {
        assertEquals(mAttacks,
                mProfile.getCharacteristic(Profile.Secondary.A));
        assertEquals(mWounds,
                mProfile.getCharacteristic(Profile.Secondary.W));
        assertEquals(mStrength/10,
                mProfile.getCharacteristic(Profile.Secondary.SB));
        assertEquals(mToughness/10,
                mProfile.getCharacteristic(Profile.Secondary.TB));
        assertEquals(mMovement,
                mProfile.getCharacteristic(Profile.Secondary.M));
        assertEquals(mMagic,
                mProfile.getCharacteristic(Profile.Secondary.MAG));
        assertEquals(mInsanityPoints,
                mProfile.getCharacteristic(Profile.Secondary.IP));
        assertEquals(mFatePoints,
                mProfile.getCharacteristic(Profile.Secondary.FP));
    }

    // region SETTER TEST===========================================================================
    @Test
    public void setterWeaponSkill() {
        // can set a positive value
        int positiveWeaponSkill = 53;
        mProfile.setWeaponSkill(positiveWeaponSkill);
        assertEquals(positiveWeaponSkill, mProfile.getWeaponSkill());
        mProfile.setWeaponSkill(mWeaponSkill);

        // cannot set a negative value
        int negativeWeaponSkill = -26;
        try {
            mProfile.setWeaponSkill(negativeWeaponSkill);
            fail("Setting a negative as weapon skill have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The weapon skill must be strictly positive", e.getMessage());
        }
        mProfile.setWeaponSkill(mWeaponSkill);

        // cannot set a zero value
        int zeroWeaponSkill = 0;
        try {
            mProfile.setWeaponSkill(zeroWeaponSkill);
            fail("Setting a zero as weapon skill have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The weapon skill must be strictly positive", e.getMessage());
        }
        mProfile.setWeaponSkill(mWeaponSkill);
    }

    @Test
    public void setterBallisticSkill() {
        // can set a positive value
        int positiveBallisticSkill = 99;
        mProfile.setBallisticSkill(positiveBallisticSkill);
        assertEquals(positiveBallisticSkill, mProfile.getBallisticSkill());
        mProfile.setBallisticSkill(mBallisticSkill);

        // cannot set a negative value
        int negativeBallisticSkill = -1;
        try {
            mProfile.setBallisticSkill(negativeBallisticSkill);
            fail("Setting a negative as ballistic skill have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The ballistic skill must be strictly positive", e.getMessage());
        }
        mProfile.setBallisticSkill(mBallisticSkill);

        // cannot set a zero value
        int zeroBallisticSkill = 0;
        try {
            mProfile.setBallisticSkill(zeroBallisticSkill);
            fail("Setting a zero as ballistic skill have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The ballistic skill must be strictly positive", e.getMessage());
        }
        mProfile.setBallisticSkill(mBallisticSkill);
    }

    @Test
    public void setterStrength() {
        // can set a positive value
        int positiveStrength = 23;
        mProfile.setStrength(positiveStrength);
        assertEquals(positiveStrength, mProfile.getStrength());
        mProfile.setStrength(mStrength);

        // cannot set a negative value
        int negativeStrength = -46;
        try {
            mProfile.setStrength(negativeStrength);
            fail("Setting a negative as strength have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The strength must be strictly positive", e.getMessage());
        }
        mProfile.setStrength(mStrength);

        // cannot set a zero value
        int zeroStrength = 0;
        try {
            mProfile.setStrength(zeroStrength);
            fail("Setting a zero as strength have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The strength must be strictly positive", e.getMessage());
        }
        mProfile.setStrength(mStrength);
    }

    @Test
    public void setterToughness() {
        // can set a positive value
        int positiveToughness = 53;
        mProfile.setToughness(positiveToughness);
        assertEquals(positiveToughness, mProfile.getToughness());
        mProfile.setToughness(mToughness);

        // cannot set a negative value
        int negativeToughness = -26;
        try {
            mProfile.setToughness(negativeToughness);
            fail("Setting a negative as toughness have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The toughness must be strictly positive", e.getMessage());
        }
        mProfile.setToughness(mToughness);

        // cannot set a zero value
        int zeroToughness = 0;
        try {
            mProfile.setToughness(zeroToughness);
            fail("Setting a zero as toughness have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The toughness must be strictly positive", e.getMessage());
        }
        mProfile.setToughness(mToughness);
    }

    @Test
    public void setterAgility() {
        // can set a positive value
        int positiveAgility = 36;
        mProfile.setAgility(positiveAgility);
        assertEquals(positiveAgility, mProfile.getAgility());
        mProfile.setAgility(mAgility);

        // cannot set a negative value
        int negativeAgility = -17;
        try {
            mProfile.setAgility(negativeAgility);
            fail("Setting a negative as agility have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The agility must be strictly positive", e.getMessage());
        }
        mProfile.setAgility(mAgility);

        // cannot set a zero value
        int zeroAgility = 0;
        try {
            mProfile.setAgility(zeroAgility);
            fail("Setting a zero as agility have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The agility must be strictly positive", e.getMessage());
        }
        mProfile.setAgility(mAgility);
    }

    @Test
    public void setterIntelligence() {
        // can set a positive value
        int positiveIntelligence = 84;
        mProfile.setIntelligence(positiveIntelligence);
        assertEquals(positiveIntelligence, mProfile.getIntelligence());
        mProfile.setIntelligence(mIntelligence);

        // cannot set a negative value
        int negativeIntelligence = -46;
        try {
            mProfile.setIntelligence(negativeIntelligence);
            fail("Setting a negative as intelligence have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The intelligence must be strictly positive", e.getMessage());
        }
        mProfile.setIntelligence(mIntelligence);

        // cannot set a zero value
        int zeroIntelligence = 0;
        try {
            mProfile.setIntelligence(zeroIntelligence);
            fail("Setting a zero as intelligence have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The intelligence must be strictly positive", e.getMessage());
        }
        mProfile.setIntelligence(mIntelligence);
    }

    @Test
    public void setterWillPower() {
        // can set a positive value
        int positiveWillPower = 35;
        mProfile.setWillPower(positiveWillPower);
        assertEquals(positiveWillPower, mProfile.getWillPower());
        mProfile.setWillPower(mWillPower);

        // cannot set a negative value
        int negativeWillPower = -74;
        try {
            mProfile.setWillPower(negativeWillPower);
            fail("Setting a negative as will power have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The will power must be strictly positive", e.getMessage());
        }
        mProfile.setWillPower(mWillPower);

        // cannot set a zero value
        int zeroWillPower = 0;
        try {
            mProfile.setWillPower(zeroWillPower);
            fail("Setting a zero as will power have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The will power must be strictly positive", e.getMessage());
        }
        mProfile.setWillPower(mWillPower);
    }

    @Test
    public void setterFellowship() {
        // can set a positive value
        int positiveFellowship = 55;
        mProfile.setFellowship(positiveFellowship);
        assertEquals(positiveFellowship, mProfile.getFellowship());
        mProfile.setFellowship(mFellowship);

        // cannot set a negative value
        int negativeFellowship = -73;
        try {
            mProfile.setFellowship(negativeFellowship);
            fail("Setting a negative as fellowship have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The fellowship must be strictly positive", e.getMessage());
        }
        mProfile.setFellowship(mFellowship);

        // cannot set a zero value
        int zeroFellowship = 0;
        try {
            mProfile.setFellowship(zeroFellowship);
            fail("Setting a zero as fellowship have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The fellowship must be strictly positive", e.getMessage());
        }
        mProfile.setFellowship(mFellowship);
    }

    @Test
    public void setterAttacks() {
        // can set a positive value
        int positiveAttacks = 10;
        mProfile.setAttacks(positiveAttacks);
        assertEquals(positiveAttacks, mProfile.getAttacks());
        mProfile.setAttacks(mAttacks);

        // cannot set a negative value
        int negativeAttacks = -6;
        try {
            mProfile.setAttacks(negativeAttacks);
            fail("Setting a negative as number of attacks have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The number of attacks must be positive", e.getMessage());
        }
        mProfile.setAttacks(mAttacks);

        // can set a zero value
        int zeroAttacks = 0;
        mProfile.setAttacks(zeroAttacks);
        assertEquals(zeroAttacks, mProfile.getAttacks());
        mProfile.setAttacks(mAttacks);
    }

    @Test
    public void setterWounds() {
        // can set a positive value
        int positiveWounds = 17;
        mProfile.setWounds(positiveWounds);
        assertEquals(positiveWounds, mProfile.getWounds());
        mProfile.setWounds(mWounds);

        // cannot set a negative value
        int negativeWounds = -3;
        try {
            mProfile.setWounds(negativeWounds);
            fail("Setting a negative as wounds have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The wounds must be strictly positive", e.getMessage());
        }
        mProfile.setWounds(mWounds);

        // cannot set a zero value
        int zeroWounds = 0;
        try {
            mProfile.setWounds(zeroWounds);
            fail("Setting a zero as wounds have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The wounds must be strictly positive", e.getMessage());
        }
        mProfile.setWounds(mWounds);
    }

    @Test
    public void setterMovement() {
        // can set a positive value
        int positiveMovement = 1;
        mProfile.setMovement(positiveMovement);
        assertEquals(positiveMovement, mProfile.getMovement());
        mProfile.setMovement(mMovement);

        // cannot set a negative value
        int negativeMovement = -9;
        try {
            mProfile.setMovement(negativeMovement);
            fail("Setting a negative as movement have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The movement must be strictly positive", e.getMessage());
        }
        mProfile.setMovement(mMovement);

        // cannot set a zero value
        int zeroMovement = 0;
        try {
            mProfile.setMovement(zeroMovement);
            fail("Setting a zero as movement have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The movement must be strictly positive", e.getMessage());
        }
        mProfile.setMovement(mMovement);
    }

    @Test
    public void setterMagic() {
        // can set a positive value
        int positiveMagic = 5;
        mProfile.setMagic(positiveMagic);
        assertEquals(positiveMagic, mProfile.getMagic());
        mProfile.setMagic(mMagic);

        // cannot set a negative value
        int negativeMagic = -2;
        try {
            mProfile.setMagic(negativeMagic);
            fail("Setting a negative as magic have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The magic must be positive", e.getMessage());
        }
        mProfile.setMagic(mMagic);

        // can set a zero value
        int zeroMagic = 0;
        mProfile.setMagic(zeroMagic);
        assertEquals(zeroMagic, mProfile.getMagic());
        mProfile.setMagic(mMagic);
    }

    @Test
    public void setterInsanityPoints() {
        // can set a positive value
        int positiveInsanityPoints = 53;
        mProfile.setInsanityPoints(positiveInsanityPoints);
        assertEquals(positiveInsanityPoints, mProfile.getInsanityPoints());
        mProfile.setInsanityPoints(mInsanityPoints);

        // cannot set a negative value
        int negativeInsanityPoints = -26;
        try {
            mProfile.setInsanityPoints(negativeInsanityPoints);
            fail("Setting a negative as number of insanity points have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The number of insanity points must be positive", e.getMessage());
        }
        mProfile.setInsanityPoints(mInsanityPoints);

        // can set a zero value
        int zeroInsanityPoints = 0;
        mProfile.setInsanityPoints(zeroInsanityPoints);
        assertEquals(zeroInsanityPoints, mProfile.getInsanityPoints());
        mProfile.setInsanityPoints(mInsanityPoints);
    }

    @Test
    public void setterFatePoints() {
        // can set a positive value
        int positiveFatePoints = 99;
        mProfile.setFatePoints(positiveFatePoints);
        assertEquals(positiveFatePoints, mProfile.getFatePoints());
        mProfile.setFatePoints(mFatePoints);

        // cannot set a negative value
        int negativeFatePoints = -1;
        try {
            mProfile.setFatePoints(negativeFatePoints);
            fail("Setting a negative as number of fate points have not throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The number of fate points must be positive", e.getMessage());
        }
        mProfile.setFatePoints(mFatePoints);

        // can set a zero value
        int zeroFatePoints = 0;
        mProfile.setFatePoints(zeroFatePoints);
        assertEquals(zeroFatePoints, mProfile.getFatePoints());
        mProfile.setFatePoints(mFatePoints);
    }
    // endregion====================================================================================

    @Test
    public void deepCopyTest() {
        Profile same = mProfile;
        Profile deepCopy = mProfile.deepCopy();

        assertEquals(mAgility, mProfile.getAgility());
        assertEquals(mAgility, same.getAgility());
        assertEquals(mAgility, deepCopy.getAgility());

        mProfile.setAgility(mAgility + 20);

        assertEquals(mAgility + 20, mProfile.getAgility());
        assertEquals(mAgility + 20, same.getAgility());
        assertEquals(mAgility, deepCopy.getAgility());
    }
}
