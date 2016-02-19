package cafetcraftteam.rpgsoftware;

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

    /*
    Character and Player Information
     */
    private final String mName;
    private final String mYear;
    private final String mRace;
    private final Sex mSex;
    private final int mAge;
    private final int mHeight;
    private final int mWeight;

    Character(String Name, String Year, String Race, Sex sex, int weight, int height, int age)
    {
        mName = Name;
        mYear = Year;
        mRace = Race;
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

    public String getRace()
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
