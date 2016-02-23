package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by Gautier on 22/02/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacteristicTest
{
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

    private final Characteristic mCharacteristic = new Characteristic(
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

    @Test
    public void creationTest()
    {
        assertEquals(mWeaponSkill, mCharacteristic.getWeaponSkill());
        assertEquals(mBallisticSkill, mCharacteristic.getBallisticSkill());
        assertEquals(mStrength, mCharacteristic.getStrength());
        assertEquals(mToughness, mCharacteristic.getToughness());
        assertEquals(mAgility, mCharacteristic.getAgility());
        assertEquals(mIntelligence, mCharacteristic.getIntelligence());
        assertEquals(mWillPower, mCharacteristic.getWillPower());
        assertEquals(mAttacks, mCharacteristic.getAttacks());
        assertEquals(mWounds, mCharacteristic.getWounds());
        assertEquals(mStrength/10, mCharacteristic.getStrengthBonus());
        assertEquals(mToughness/10, mCharacteristic.getToughnessBonus());
        assertEquals(mMovement, mCharacteristic.getMovement());
        assertEquals(mMagic, mCharacteristic.getMagic());
        assertEquals(mInsanityPoints, mCharacteristic.getInsanityPoints());
        assertEquals(mFatePoints, mCharacteristic.getFatePoints());
    }

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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
            assertEquals("The fellowship must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectAttacks() {
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
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
        }
        catch (InstantiationError e){
            assertEquals("The movement must be strictly positive", e.getMessage());
        }
    }

    @Test
    public void contractRespectMagic() {
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
        }
        catch (InstantiationError e){
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
    public void contractRespectInsanityPoints() {
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
        }
        catch (InstantiationError e){
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
    public void contractRespectFatePoints() {
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
        }
        catch (InstantiationError e){
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
}
