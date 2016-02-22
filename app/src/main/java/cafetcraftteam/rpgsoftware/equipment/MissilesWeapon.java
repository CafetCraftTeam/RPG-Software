package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
        if (reload < 0)
        {
            throw new IllegalArgumentException("The time of reload must be positive or zero");
        }

        mShortRange = shortRange;
        mLongRange = longRange;

        mReload = reload;
    }

    /**
     * Getter for the short range of the weapon
     *
     * @return the short range of the weapon
     */
    public int getShortRange()
    {
        return mShortRange;
    }

    /**
     * Getter for the long range of the weapon
     *
     * @return the long range of the weapon
     */
    public int getLongRange()
    {
        return mLongRange;
    }

    /**
     * Getter of the time for reload the weapon
     *
     * @return the time to reload the weapon
     */
    public double getReload()
    {
        return mReload;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object object)
    {
        if (object == null)
        {
            return false;
        }

        if (object == this)
        {
            return true;
        }

        // usage of instanceof for consistency with inheritance
        if (!(object instanceof Equipment))
        {
            return false;
        }

        MissilesWeapon other = (MissilesWeapon) object;

        return new EqualsBuilder()
                .appendSuper(super.equals(object))
                .append(mShortRange, other.mShortRange)
                .append(mLongRange, other.mLongRange)
                .append(mReload, other.mReload)
                .isEquals();
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(41, 191)
                .appendSuper(super.hashCode())
                .append(mShortRange)
                .append(mLongRange)
                .append(mReload)
                .toHashCode();
    }
}