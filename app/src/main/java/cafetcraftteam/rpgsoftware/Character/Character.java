package cafetcraftteam.rpgsoftware.character;

/**
 * Created by Pujima on 10/02/2016.
 */
public class Character
{

    /*
    Personal Details
     */

    public enum Sex
    {
        FEMALE,
        MALE
    }

    public enum Race
    {
        HUMAN,
        ELF,
        DWARF,
        HALFLING
    }

    /*
    Character and Player Information
     */
    private final String mName;
    private final String mYear;
    private final Race mRace;
    private final Sex mSex;
    private final int mAge;
    private final int mHeight;
    private final int mWeight;

    public Character(String name, String year, Race race, Sex sex, int weight, int height, int age)
    {
        mName = name;
        mYear = year;
        mRace = race;
        mSex = sex;
        mWeight = weight;
        mHeight = height;
        mAge = age;
    }

    public String getName()
    {
        return mName;
    }

    public String getYear()
    {
        return mYear;
    }

    public Race getRace()
    {
        return mRace;
    }

    public Sex getSex()
    {
        return mSex;
    }

    public int getAge()
    {
        return mAge;
    }

    public int getHeight()
    {
        return mHeight;
    }

    public int getWeight()
    {
        return mWeight;
    }


}
