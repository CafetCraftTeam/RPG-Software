package cafetcraftteam.rpgsoftware;

/**
 * Created by Pujima on 10/02/2016.
 */
public class Character {

    /*
    Character and Player Information
     */
    private final String mName;
    private final String mYear;
    private final String mRace;

    Character(String Name, String RealName, String Campaign, String Year, String Race){
        mName = Name;
        mYear = Year;
        mRace = Race;
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
}
