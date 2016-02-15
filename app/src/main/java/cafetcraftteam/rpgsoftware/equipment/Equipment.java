package cafetcraftteam.rpgsoftware.equipment;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    private final String mName;
    private final int mEncumbering;
    private final int mPrice;
    private final Quality mQuality;
    private final String mDescription;

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
