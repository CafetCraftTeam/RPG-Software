package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

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
    private final int mMagic = 0;
    private final int mInsanityPoint = 1;
    private final int mFatePoint = 1;

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
            mInsanityPoint,
            mFatePoint
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
        assertEquals(mInsanityPoint, mCharacteristic.getInsanityPoints());
        assertEquals(mFatePoint, mCharacteristic.getFatePoints());
    }
}
