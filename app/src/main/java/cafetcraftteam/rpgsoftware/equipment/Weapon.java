package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.EnumSet;
import java.util.Set;

/**
 * Class of the Weapons
 */
public class Weapon extends Equipment
{
    // the different groups possible for the weapons
    public enum Group
    {
        ORDINARY,
        CAVALRY,
        CROSSBOW,
        ENGINEER,
        ESTANGLING,
        FENCING,
        FLAIL,
        GUNPOWDER,
        LONGBOW,
        PARRYING,
        SLING,
        THROWING,
        TWO_HANDED
    }

    public enum Qualities
    {
        ARMOUR_PIERCING,
        BALANCED,
        DEFENSIVE,
        EXPERIMENTAL,
        FAST,
        IMPACT,
        NONE,
        PRECISE,
        PUMMELLING,
        SHRAPNEL,
        SLOW,
        SNARE,
        SPECIAL,
        TIRING,
        UNRELIABLE
    }

    // The weapon group of the weapon
    private final Group mGroup;

    // the qualities of the weapon
    private final Set<Qualities> mQualities;

    /**
     * Constructor of the class weapon
     *
     * @param name        the name of the weapon, must not be empty or null
     * @param encumbering the encumbering of the weapon, must be positive or zero
     * @param price       the price of the weapon, must be positive or zero
     * @param quality     the quality of the weapon, must not be null
     * @param description the description of the weapon, if null replace by an empty string
     * @param group       the group of the weapon, must not be null
     * @param qualities   the qualities of the weapon, if null or empty replace by the NONE Qualities
     */
    public Weapon(@NonNull String name, int encumbering, int price, @NonNull Quality quality,
                  @Nullable String description, @NonNull Group group,
                  @Nullable Set<Qualities> qualities)
    {
        super(name, encumbering, price, quality, description);

        // verification of the contract of the constructor
        if (group == null)
        {
            throw new IllegalArgumentException("The group of the weapon must not be null");
        }
        if (qualities == null || qualities.isEmpty())
        {
            qualities = EnumSet.of(Qualities.NONE);
        }

        mGroup = group;
        mQualities = qualities;
    }

    /**
     * Getter of the group of the weapon
     *
     * @return the group of the weapon
     */
    public Group getGroup()
    {
        return mGroup;
    }

    /**
     * Getter of the qualities of the weapon
     *
     * @return the qualities of the weapon
     */
    public Set<Qualities> getQualities()
    {
        return mQualities;
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

        //Verify if it's not the same object
        if (object == this)
        {
            return true;
        }

        if (!(object instanceof Weapon))
        {
            return false;
        }

        Weapon other = (Weapon) object;

        return new EqualsBuilder()
                .appendSuper(super.equals(object))
                .append(mGroup, other.mGroup)
                .append(mQualities, other.mQualities)
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
        return new HashCodeBuilder(5, 19)
                .appendSuper(super.hashCode())
                .append(mGroup)
                .append(mQualities)
                .toHashCode();
    }
}
