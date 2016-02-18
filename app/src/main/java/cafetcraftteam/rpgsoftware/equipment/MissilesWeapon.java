package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
    public MissilesWeapon(@NonNull String name, int encumbering, int price, @NonNull Quality quality,
                          @Nullable String description, @NonNull Group group,
                          @Nullable Set<Qualities> qualities, int shortRange, int longRange,
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
        if (reload < 0) {
            throw new IllegalArgumentException("The time of reload must be positive or zero");
        }

        mShortRange = shortRange;
        mLongRange = longRange;

        mReload = reload;
    }

    /**
     * Getter for the short range of the weapon
     * @return the short range of the weapon
     */
    public int getShortRange()
    {
        return mShortRange;
    }

    /**
     * Getter for the long range of the weapon
     * @return the long range of the weapon
     */
    public int getLongRange()
    {
        return mLongRange;
    }

    /**
     * Getter of the time for reload the weapon
     * @return the time to reload the weapon
     */
    public double getReload()
    {
        return mReload;
    }
}