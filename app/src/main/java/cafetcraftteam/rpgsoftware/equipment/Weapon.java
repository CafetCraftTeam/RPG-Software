package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    private final Qualities mQualities;

    /**
     * Constructor of the class weapon
     *
     * @param name        the name of the weapon
     * @param encumbering the encumbering of the weapon
     * @param price       the price of the weapon
     * @param quality     the quality of the weapon
     * @param description the description of the weapon
     * @param group       the group of the weapon
     * @param qualities   the qualities of the weapon
     */
    public Weapon(@NonNull String name, int encumbering, int price, @NonNull Quality quality,
                  @NonNull String description, @NonNull Group group, @NonNull Qualities qualities)
    {
        super(name, encumbering, price, quality, description);
        mGroup = group;
        mQualities = qualities;
    }

    public Group getGroup()
    {
        return mGroup;
    }

    public Qualities getQualities()
    {
        return mQualities;
    }

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
