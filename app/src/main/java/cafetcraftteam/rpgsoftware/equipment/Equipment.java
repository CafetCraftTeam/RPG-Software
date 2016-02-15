package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Class for all the equipment
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

    private final String mName; // the name of the object
    private final int mEncumbering; // the encumbering of the object
    private final int mPrice; // the price of the object
    private final Quality mQuality; // the quality of the object
    // the description of the object, not characteristic of the object, could be empty or change without changing the properties
    private String mDescription;

    /**
     * Constructor of an equipment
     * @param name the name of the equipment, must not be null or empty
     * @param encumbering the encumbering of the equipment, must be positive
     * @param price the price of the equipment, must be positive
     * @param quality the quality of the equipment as an enum Quality, must be not null
     * @param description the description of the equipment, could be empty, but not null
     */
    public Equipment(@NonNull String name, int encumbering, int price,@NonNull Quality quality,
                     @NonNull String description)
    {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name must not be empty");
        }
        if (encumbering < 0) {
            throw new IllegalArgumentException("The encumbering must be positive");
        }
        if (price < 0) {
            throw new IllegalArgumentException("The price must be positive");
        }

        mName = name;
        mEncumbering = encumbering;
        mPrice = price;
        mQuality = quality;
        mDescription = description;
    }

    /**
     * Getter of the name of the equipment
     * @return the name
     */
    public String getName(){
        return mName;
    }

    /**
     * Getter of the encumbering of the object
     * @return the encumbering
     */
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

    public void setDescription(String desciption) {
        mDescription = desciption;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        //Verify if it's not the same object
        if (object == this) {
            return true;
        }

        if (!(object instanceof Equipment)) {
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder(3, 13)
                .append(mName)
                .append(mEncumbering)
                .append(mPrice)
                .append(mQuality)
                .toHashCode();
    }

}
