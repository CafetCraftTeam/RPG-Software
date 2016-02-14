package cafetcraftteam.rpgsoftware;

/**
 * Created by Gautier on 10/02/2016.
 */
public class Equipment
{
    public enum Quality
    {
        POOR,
        COMMON,
        GOOD,
        BEST,
        MAGICAL
    }
// test

    private String mName;
    private int mEncumbering;
    private Quality mQuality;
    private String mDescription;

    public Equipment(String name, int encumbering, Quality quality, String description)
    {
        mName = name;
        mEncumbering = encumbering;
        mQuality = quality;
        mDescription = description;
    }

    public String getName(){
        return mName;
    }

    public int getEncumbering() {
        return mEncumbering;
    }

    public Quality getQuality() {
        return mQuality;
    }

    public String getDescription() {
        return mDescription;
    }
}
