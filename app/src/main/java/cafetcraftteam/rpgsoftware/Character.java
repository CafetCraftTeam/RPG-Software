package cafetcraftteam.rpgsoftware;

/**
 * Created by Pujima on 10/02/2016.
 */
public class Character {

    public enum Sex {
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

    Character(String Name, String Year, String Race, Sex sex){
        mName = Name;
        mYear = Year;
        mRace = Race;
        mSex = sex;
    }

    public String getName() {
        return mName;
    }

    public String getYear() {
        return mYear;
    }

    public String getRace() {
        return mRace;
    }

    public Sex getSex() {
        return mSex;
    }

}
