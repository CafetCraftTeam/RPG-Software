package cafetcraftteam.rpgsoftware.character_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.character.Character;

import static junit.framework.Assert.assertEquals;

/**
 * Testing the class Character
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacterTest {
    private final String mName = "Toto";
    private final String mYear = "1900";
    private final cafetcraftteam.rpgsoftware.character.Character.Race mRace = Character.Race.DWARF;
    private final Character.Sex mSex = Character.Sex.FEMALE;
    private final int mAge = 100;
    private final int mHeight = 120;
    private final int mWeight = 90;

    private Character mCharacter;

    @Before
    public void init() throws InstantiationException {
        mCharacter = new Character(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge
        );
    }

    @Test
    public void creationTest() {
        assertEquals(mName, mCharacter.getName());
        assertEquals(mRace, mCharacter.getRace());
        assertEquals(mSex, mCharacter.getSex());
        assertEquals(mAge, mCharacter.getAge());
        assertEquals(mHeight, mCharacter.getHeight());
        assertEquals(mWeight, mCharacter.getWeight());
    }
}
