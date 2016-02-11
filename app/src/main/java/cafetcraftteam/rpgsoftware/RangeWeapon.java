package cafetcraftteam.rpgsoftware;

/**
 * Created by Gautier on 11/02/2016.
 */
public class RangeWeapon extends Weapon
{
    private int mShortRange;
    private int mLongRange;
    private double mReload;

    public RangeWeapon(String name, int encumbering, Quality quality, String description,
                       String group, String qualities, int shortRange, int longRange, double reload)
    {
        super(name, encumbering, quality, description, group, qualities);
        mShortRange = shortRange;
        mLongRange = longRange;

        mReload = reload;
    }

    public int getShortRange()
    {
        return mShortRange;
    }

    public int getLongRange()
    {
        return mLongRange;
    }

    public double getReload()
    {
        return mReload;
    }
}
