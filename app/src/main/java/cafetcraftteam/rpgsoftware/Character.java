package cafetcraftteam.rpgsoftware;

/**
 * Created by Pujima on 10/02/2016.
 */
public class Character {

    /*
    Character and Player Information
     */
    private final String mName;
    private final String mRealName;
    private final String mCampaign;
    private final String mYear;
    private final String mRace;

    Character(String Name, String RealName, String Campaign, String Year, String Race){
        mName = Name;
        mRealName = RealName;
        mCampaign = Campaign;
        mYear = Year;
        mRace = Race;
    }

    public String getmName() {
        return mName;
    }

    public String getmRealName() {
        return mRealName;
    }

    public String getmCampaign() {
        return mCampaign;
    }

    public String getmYear() {
        return mYear;
    }

    public String getmRace() {
        return mRace;
    }
}
