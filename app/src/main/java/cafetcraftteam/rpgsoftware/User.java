package cafetcraftteam.rpgsoftware;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that contain all the information of a user
 */
public class User
{
    // the name of the user
    private String mName;
    // the email of the user
    private String mEmail;
    // store all the characters of this user
    private Set<Character> mCharacter;
    // store all the campaigns where this user is the game master

    /**
     * Constructor of the user
     * @param name the name of the user
     * @param email the email of the user
     */
    public User(String name, String email) {
        mName = name;
        mEmail = email;

        mCharacter = new HashSet<>();
    }

    /**
     * Getter of the name of the user
     * @return the name of the user
     */
    public String getName()
    {
        return mName;
    }

    /**
     * Getter of the email of the user
     * @return the email of the user
     */
    public String getEmail() {
        return mEmail;
    }

    public Set<Character> getCharacters() {
        return mCharacter;
    }

    /**
     * Associate the given character to this user
     * @param character the reference of the character to associate
     */
    public void addCharacter(Character character) {
        mCharacter.add(character);
    }
}
