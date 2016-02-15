package cafetcraftteam.rpgsoftware.equipment;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Gautier on 11/02/2016.
 */
public class Weapon extends Equipment
{
    private String mGroup;
    private String mQualities;

    public Weapon(String name, int encumbering, int price, Quality quality, String description,
                  String group, String qualities)
    {
        super(name, encumbering, price, quality, description);
        mGroup = group;
        mQualities = qualities;
    }

    public String getGroup()
    {
        return mGroup;
    }

    public String getQualities()
    {
        return mQualities;
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

        if (!(object instanceof  Weapon)) {
            return false;
        }

        Weapon other = (Weapon) object;

        return new EqualsBuilder()
                .appendSuper(super.equals(object))
                .append(mGroup, other.mGroup)
                .append(mQualities, other.mQualities)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(5, 19)
                .appendSuper(super.hashCode())
                .append(mGroup)
                .append(mQualities)
                .toHashCode();
    }
}
