package cafetcraftteam.rpgsoftware.equipment;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        //Verify if it's not the same object
        if (object == this) {
            return true;
        }

        if (object instanceof Equipment) {
            Equipment other = (Equipment) object;

            // Verify all the relevant attributes (the description is not)
            if (!mName.equals(other.mName)) {
                return false;
            }
            if (mEncumbering != other.mEncumbering) {
                return false;
            }
            if (mPrice != other.mPrice) {
                return false;
            }
            if (mQuality != other.mQuality) {
                return false;
            }

            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 3;
        final int multiplier = 13;

        result = multiplier*result + mName.hashCode();
        result = multiplier*result + mEncumbering;
        result = multiplier*result + mPrice;
        result = multiplier*result + mQuality.ordinal();

        return result;
    }

}
