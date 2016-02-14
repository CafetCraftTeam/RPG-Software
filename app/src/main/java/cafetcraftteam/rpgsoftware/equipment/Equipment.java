package cafetcraftteam.rpgsoftware.equipment;

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

    private String mName;
    private int mEncumbering;
    private int mPrice;
    private Quality mQuality;
    private String mDescription;

    public Equipment(String name, int encumbering, int price, Quality quality, String description)
    {
        mName = name;
        mEncumbering = encumbering;
        mPrice = price;
        mQuality = quality;
        mDescription = description;
    }

    public String getName(){
        return mName;
    }

    public int getEncumbering() {
        return mEncumbering;
    }

    public int getPrice() {
        return mPrice;
    }

    public Quality getQuality() {
        return mQuality;
    }

    public String getDescription() {
        return mDescription;
    }

}
