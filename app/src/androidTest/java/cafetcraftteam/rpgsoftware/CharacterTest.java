package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Testing the class Character
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacterTest
{
    private final String mName = "Toto";
    private final String mYear = "1900";
    private final String mRace = "Dwarf";
    private final Character.Sex mSex = Character.Sex.FEMALE;
    private final int mAge = 100;
    private final int mHeight = 120;
    private final int mWeight = 90;

    private final Character mCharacter = new Character(mName, mYear, mRace, mSex, mWeight, mHeight,
            mAge);

    @Test
    public void creationTest() {
        assertEquals(mName, mCharacter.getName());
        assertEquals(mYear, mCharacter.getYear());
        assertEquals(mRace, mCharacter.getRace());
        assertEquals(mSex, mCharacter.getSex());
        assertEquals(mAge, mCharacter.getAge());
        assertEquals(mHeight, mCharacter.getHeight());
        assertEquals(mWeight, mCharacter.getWeight());
    }
}
