package cafetcraftteam.rpgsoftware.equipment;

import java.util.Set;

/**
 * Class for all the range weapons
 */
public class MissilesWeapon extends Weapon
{
    // the short range of the missiles weapon (no penalty)
    private final int mShortRange;
    // the long range of the missiles weapon (-20% of penalty)
    private final int mLongRange;
    // time to reload a new projectile in the weapon (in round)
    private final double mReload;

    /**
     * Constructor of a missiles weapon
     *
     * @param name        the name of the weapon, must not be empty or null
     * @param encumbering the encumbering of the weapon, must be positive or zero
     * @param price       the price of the weapon, must be positive or zero
     * @param quality     the quality of the weapon, must not be null
     * @param description the description of the weapon, if null replace by an empty string
     * @param group       the group of the weapon, must not be null
     * @param qualities   the qualities of the weapon, if null or empty replace by the NONE Qualities
     * @param shortRange  the short range of the weapon, must be positive or zero
     * @param longRange   the long range of the weapon, must be positive or zero, if smaller than the
     *                    short range, the two values are swap
     * @param reload      the time to reload the weapon (in round), must be positive or zero
     */
    public MissilesWeapon(String name, int encumbering, int price, Quality quality, String description,
                          Group group, Set<Qualities> qualities, int shortRange, int longRange,
                          double reload)
    {
        super(name, encumbering, price, quality, description, group, qualities);

        // verify the contract of the constructor
        if (shortRange < 0)
        {
            throw new IllegalArgumentException("The short range must be positive or zero");
        }
        if (longRange < 0)
        {
            throw new IllegalArgumentException("The long range must be positive or zero");
        }
        if (longRange < shortRange)
        {
            int temp = longRange;
            longRange = shortRange;
            shortRange = temp;
        }

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