package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Class for testing the User class
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UserTest
{
    private String mName = "Toto";
    private String mEmail = "toto@plop.fr";
    private User mUser = new User(mName, mEmail);

    @Test
    public void creationTest() {
        assertEquals(mName, mUser.getName());
        assertEquals(mEmail, mUser.getEmail());
    }

    @Test
    public void addCharacterTest() {
        Character character = CharacterWarhammer.ancesterGurdill();

        mUser.addCharacter(character);

        assertEquals(1, mUser.getCharacters().size());
    }
}
