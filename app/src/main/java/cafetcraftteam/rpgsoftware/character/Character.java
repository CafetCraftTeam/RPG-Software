package cafetcraftteam.rpgsoftware.character;

import android.support.annotation.NonNull;

/**
 * Created by Pujima on 10/02/2016.
 */
public class Character {

    /**
     * The sex of a character
     */
    public enum Sex {
        FEMALE,
        MALE
    }

    /**
     * The race of a character
     */
    public enum Race {
        HUMAN,
        ELF,
        DWARF,
        HALFLING
    }

    /**
     * Character Information
     */
    private final String mName; // the name of the character
    private final Race mRace; // the race of the character
    private final Sex mSex; // the sex of the character
    private final int mAge; // the age of the character
    private final int mHeight; // the height of the character
    private final int mWeight; // the weight of the character

    /**
     * Constructor of the character
     *
     * @param name   the name of the character, must be not null and non empty
     * @param race   the race of the character, must be not null
     * @param sex    the sex of the character, must be not null
     * @param weight the weight of the character in kilogram, must be positive
     * @param height the height of the character in meter, must be positive
     * @param age    the age of the character in years, must be positive
     */
    public Character(
            @NonNull String name,
            @NonNull Race race,
            @NonNull Sex sex,
            int weight,
            int height,
            int age
    ) throws InstantiationException {
        if (name == null || name.isEmpty()) {
            throw new InstantiationException("The name must be not null and not empty");
        }
        if (race == null) {
            throw new InstantiationException("The race must be not null");
        }
        if (sex == null) {
            throw new InstantiationException("The sex must be not null");
        }
        if (weight < 0) {
            throw new InstantiationException("The weight must be positive");
        }
        if (height < 0) {
            throw new InstantiationException("The height must be positive");
        }
        if (age < 0) {
            throw new InstantiationException("The age must be positive");
        }

        mName = name;
        mRace = race;
        mSex = sex;
        mWeight = weight;
        mHeight = height;
        mAge = age;
    }

    /**
     * Getter of the name of the character
     * @return the name of the character as a string, always non null and not empty
     */
    @NonNull
    public String getName() {
        return mName;
    }

    /**
     * Getter of the race of the character
     * @return the race of the character, always non null
     */
    @NonNull
    public Race getRace() {
        return mRace;
    }

    /**
     * Getter of the sex of the character
     * @return the sex of the character, always non null
     */
    @NonNull
    public Sex getSex() {
        return mSex;
    }

    /**
     * Getter of the age of the character
     * @return the age of the character, always positive
     */
    public int getAge() {
        return mAge;
    }

    /**
     * Getter of the height of the character
     * @return the height of the character, always positive
     */
    public int getHeight() {
        return mHeight;
    }

    /**
     * Getter of the weight of the character
     * @return the weight of the character, always positive
     */
    public int getWeight() {
        return mWeight;
    }


}
