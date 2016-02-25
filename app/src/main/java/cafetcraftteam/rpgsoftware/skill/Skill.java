package cafetcraftteam.rpgsoftware.skill;

import android.support.annotation.NonNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import cafetcraftteam.rpgsoftware.Profile;

import static cafetcraftteam.rpgsoftware.Profile.Primary;

/**
 * Class that represent a Warhammer skill
 */
public abstract class Skill {

    /**
     * Level of mastery of a skill
     */
    public enum Level {
        NONE,
        ACQUIRE,
        ADVANCE,
        MASTER {
            @Override
            public Level improve() {
                return this;
            }
        };

        // to avoid copy of the array
        private static Level[] sValues = values();

        /**
         * Improve the level of mastering by one, capped at the level Master
         *
         * @return the next level of mastering, capped at the level Master
         */
        public Level improve() {
            // no bound checking as the last element override the method to capped
            return sValues[ordinal() + 1];
        }
    }

    private String mName; // the name of the skill
    private Primary mAssociatedCharacteristic; // the characteristic from which the skill depends
    private Level mLevel; //the level of mastery of the skill
    private int mBonus; // the bonus applied to this skill

    /**
     * Constructor of a skill
     *
     * @param name           the name of the skill, must be not null or empty
     * @param characteristic the characteristic associated to the skill, must be not null
     * @param level          the level of mastery of this skill, must be not null
     * @param bonus          the bonus on this skill
     */
    public Skill(@NonNull String name,
                 @NonNull Primary characteristic,
                 @NonNull Level level,
                 int bonus) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name must be not null or empty");
        }
        if (characteristic == null) {
            throw new IllegalArgumentException("The characteristic must not be null");
        }
        if (level == null) {
            throw new IllegalArgumentException("The level of mastery of the skill must not be null");
        }
        if (bonus < 0) {
            throw new IllegalArgumentException("The bonus must be positive");
        }

        mName = name;
        mAssociatedCharacteristic = characteristic;
        mLevel = level;
        mBonus = bonus;
    }

    /**
     * Constructor of a skill without any bonus
     *
     * @param name           the name of the skill, must be not null or empty
     * @param characteristic the characteristic associated to the skill, must be not null
     * @param level          the level of mastery of this skill, must be not null
     */
    public Skill(@NonNull String name,
                 @NonNull Primary characteristic,
                 @NonNull Level level) {
        this(name, characteristic, level, 0);
    }

    // region GETTER================================================================================

    /**
     * Getter of the name of the skill
     *
     * @return the name of the skill as a string, always not null
     */
    @NonNull
    public String getName() {
        return mName;
    }

    /**
     * Getter of the characteristic associated with this skill
     *
     * @return the characteristic associated as a Primary enum, always not null
     */
    @NonNull
    public Primary getAssociatedCharacteristic() {
        return mAssociatedCharacteristic;
    }

    /**
     * Getter of the level of mastery of this skill
     *
     * @return the level of mastery as a Level enum, always not null
     */
    @NonNull
    public Level getLevel() {
        return mLevel;
    }

    /**
     * Getter of the bonus for this skill
     *
     * @return the bonus as a positive integer
     */
    public int getBonus() {
        return mBonus;
    }

    /**
     * Getter of the value of the skill with the actual bonus and the given profile
     *
     * @param characterProfile the profile that use the skill, must be not null
     * @return the value as a positive integer
     */
    public abstract int getSkillValue(@NonNull Profile characterProfile);

    // endregion====================================================================================

    // region SETTER================================================================================

    /**
     * Setter of the bonus for this skill
     *
     * @param bonus the bonus for this skill, must be positive
     */
    public void setBonus(int bonus) {
        if (bonus < 0) {
            throw new IllegalArgumentException("The bonus must be positive");
        }

        mBonus = bonus;
    }

    // endregion====================================================================================

    /**
     * Method that improve the level of mastery of the skill
     */
    public void improve() {
        mLevel = mLevel.improve();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null)
        {
            return false;
        }

        if (object == this)
        {
            return true;
        }

        // usage of instanceof for consistency with inheritance
        if (!(object instanceof Skill))
        {
            return false;
        }

        Skill otherSkill = (Skill) object;

        return new EqualsBuilder()
                .append(mName, otherSkill.mName)
                .append(mAssociatedCharacteristic, otherSkill.mAssociatedCharacteristic)
                .isEquals();
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(397, 181)
                .append(mName)
                .append(mAssociatedCharacteristic)
                .hashCode();
    }

    /**
     * Return a deep copy of the actual object
     * @return a deep copy of the actual object
     */
    public abstract Skill deepCopy();
}
