package cafetcraftteam.rpgsoftware;

/**
 * Created by Gautier on 10/02/2016.
 */
public class Equipment
{
    public enum Quality
    {
        BAD,
        NORMAL,
        EXCEPTIONAL
    }

    private String mName;
    private int mEncomberment;
    private Quality mQuatilty;
    private String mDescription;

    public Equipment(String name, int encomberment, Quality quality, String description)
    {
        mName = name;
        mEncomberment = encomberment;
        mQuatilty = quality;
        mDescription = description;
    }

    public String getName(){
        return mName;
    }

    public int getEncomberment() {
        return mEncomberment;
    }

    public Quality getQuatilty() {
        return mQuatilty;
    }

    public String getDescription() {
        return mDescription;
    }
}
