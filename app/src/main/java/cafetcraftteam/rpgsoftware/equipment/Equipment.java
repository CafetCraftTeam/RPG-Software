package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Class for all the equipment
 */
public class Equipment
{
    /**
     * Enumeration of the different quality available for an equipment
     */
    public enum Quality
    {
        POOR,
        COMMON,
        GOOD,
        BEST,
        MAGICAL
    }

    private final String mName; // the name of the object
    private final int mEncumbering; // the encumbering of the object
    private final int mPrice; // the price of the object
    private final Quality mQuality; // the quality of the object
    // the description of the object, not characteristic of the object, could be empty or change without changing the properties
    private String mDescription;

    /**
     * Constructor of an equipment
     *
     * @param name        the name of the equipment, must not be null or empty
     * @param encumbering the encumbering of the equipment, must be positive
     * @param price       the price of the equipment, must be positive
     * @param quality     the quality of the equipment as an enum Quality, must be not null
     * @param description the description of the equipment, could be empty, if null is passed the
     *                    description is set to an empty string
     */
    public Equipment(@NonNull String name, int encumbering, int price, @NonNull Quality quality,
                     @Nullable String description)
    {
        //Contract of the constructor
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("The name must not be empty or null");
        }
        if (encumbering < 0)
        {
            throw new IllegalArgumentException("The encumbering must be positive or zero");
        }
        if (price < 0)
        {
            throw new IllegalArgumentException("The price must be positive or zero");
        }
        if (quality == null)
        {
            throw new IllegalArgumentException("The quality must not be null");
        }
        if (description == null)
        {
            description = "";
        }

        mName = name;
        mEncumbering = encumbering;
        mPrice = price;
        mQuality = quality;
        mDescription = description;
    }

    /**
     * Getter of the name of the equipment
     *
     * @return the name
     */
    public String getName()
    {
        return mName;
    }

    /**
     * Getter of the encumbering of the equipment
     *
     * @return the encumbering
     */
    public int getEncumbering()
    {
        return mEncumbering;
    }

    /**
     * Getter of the price of the equipment
     *
     * @return the price as a number of pennies
     */
    public int getPrice()
    {
        return mPrice;
    }

    /**
     * Getter of the quality of the equipment
     *
     * @return the quality as an enum
     */
    public Quality getQuality()
    {
        return mQuality;
    }

    /**
     * Getter of the optional description of the equipment, if it have not been given this return
     * a simple empty string.
     *
     * @return the description of the equipment
     */
    public String getDescription()
    {
        return mDescription;
    }

    /**
     * Setter of the description of the equipment. This is not characteristic of an equipment,
     * therefor you can change it at any time without changing the behaviour of the equipment.
     *
     * @param description the future description of the equipment. Must be not null, but can be empty.
     */
    public void setDescription(@NonNull String description)
    {
        mDescription = description;
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

        Equipment other = (Equipment) object;

        return new EqualsBuilder()
                .append(mName, other.mName)
                .append(mEncumbering, other.mEncumbering)
                .append(mPrice, other.mPrice)
                .append(mQuality, other.mQuality)
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
        return new HashCodeBuilder(3, 13)
                .append(mName)
                .append(mEncumbering)
                .append(mPrice)
                .append(mQuality)
                .toHashCode();
    }

}
