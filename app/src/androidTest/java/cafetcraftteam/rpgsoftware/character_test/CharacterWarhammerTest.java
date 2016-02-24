package cafetcraftteam.rpgsoftware.character_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.character.Character;
import cafetcraftteam.rpgsoftware.character.CharacterWarhammer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Class that test the CharacterWarhammer class
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacterWarhammerTest {

    private final String mName = "Pujima";
    private final Character.Race mRace = Character.Race.HUMAN;
    private final Character.Sex mSex = Character.Sex.MALE;
    private final int mWeight = 78;
    private final int mHeight = 185;
    private final int mAge = 36;
    private final String mEyeColour = "blue";
    private final String mHairColour = "Brawn";
    private final String mStarSign = "Lion";
    private final int mNumberOfSiblings = 2;
    private final String mBirthplace = "Birthplace";
    private final String mDistinguishingMarks = "None";
    private final String mProfession = "";

    private CharacterWarhammer Pujima;

    @Before
    public void init() throws InstantiationException {
        Pujima = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
    }

    @Test
    public void testConstructor() {
        assertEquals(mName, Pujima.getName());
        assertEquals(mRace, Pujima.getRace());
        assertEquals(mSex, Pujima.getSex());
        assertEquals(mWeight, Pujima.getWeight());
        assertEquals(mHeight, Pujima.getHeight());
        assertEquals(mAge, Pujima.getAge());
        assertEquals(mEyeColour, Pujima.getEyeColour());
        assertEquals(mHairColour, Pujima.getHairColour());
        assertEquals(mStarSign, Pujima.getStarSign());
        assertEquals(mNumberOfSiblings, Pujima.getNumberOfSiblings());
        assertEquals(mBirthplace, Pujima.getBirthplace());
        assertEquals(mDistinguishingMarks, Pujima.getDistinguishingMarks());
        assertEquals(mProfession, Pujima.getProfession());
    }

    // region CONTRACT RESPECT======================================================================
    @Test
    public void contractRespectEyeColour() throws InstantiationException {
        // the eye colour could be null and will be replace by an empty string
        CharacterWarhammer nullEyeColour = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                null,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals("", nullEyeColour.getEyeColour());
    }

    @Test
    public void contractRespectHairColour() throws InstantiationException {
        // the hair colour could be null and will be replace by an empty string
        CharacterWarhammer nullHairColour = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                null,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals("", nullHairColour.getHairColour());
    }

    @Test
    public void contractRespectStarSign() throws InstantiationException {
        // the star sign could be null and will be replace by an empty string
        CharacterWarhammer nullStarSign = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                null,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals("", nullStarSign.getStarSign());
    }

    @Test
    public void contractRespectNumberOfSiblings() throws InstantiationException {
        // the number of siblings could be zero
        CharacterWarhammer zeroNumberOfSiblings = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                0,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals(0, zeroNumberOfSiblings.getNumberOfSiblings());

        // the number of siblings could not be negative
        try {
            new CharacterWarhammer(
                    mName,
                    mRace,
                    mSex,
                    mWeight,
                    mHeight,
                    mAge,
                    mEyeColour,
                    mHairColour,
                    mStarSign,
                    -mNumberOfSiblings,
                    mBirthplace,
                    mDistinguishingMarks,
                    mProfession
            );
            fail("A negative number of siblings have not throw an exception");
        } catch (InstantiationException e) {
            // success
        }
    }

    @Test
    public void contractRespectBirthplace() throws InstantiationException {
        // the birthplace could be null and will be replace by an empty string
        CharacterWarhammer nullBirthplace = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                null,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals("", nullBirthplace.getBirthplace());
    }

    @Test
    public void contractRespectDistinguishingMarks() throws InstantiationException {
        // the distinguishing marks could be null and will be replace by an empty string
        CharacterWarhammer nullDistinguishingMarks = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                null,
                mProfession
        );
        assertEquals("", nullDistinguishingMarks.getDistinguishingMarks());
    }

    @Test
    public void contractRespectProfession() throws InstantiationException {
        // the profession could be null and will be replace by an empty string
        CharacterWarhammer nullProfession = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                null
        );
        assertEquals("", nullProfession.getProfession());
    }

    // endregion====================================================================================


    @Test
    public void TestSetterProfession() {
        // set a profession
        String profession = "Worker";
        Pujima.setProfession(profession);
        assertEquals(profession, Pujima.getProfession());

        // setting a null profession should throw an exception and be replace by an empty string
        String nullProfession = null;
        Pujima.setProfession(nullProfession);
        assertEquals("", Pujima.getProfession());
    }

    @Test
    public void TestActualFortune() {
        Pujima.setActualFortune(2);
        assertEquals(2, Pujima.getActualFortunePoints());
    }

    @Test
    public void TestActualWounds() {
        Pujima.setActualWounds(2);
        assertEquals(2, Pujima.getActualWounds());
    }
}


