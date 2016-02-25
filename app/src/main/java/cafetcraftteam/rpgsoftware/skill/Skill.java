package cafetcraftteam.rpgsoftware.skill;

import android.support.annotation.NonNull;

import cafetcraftteam.rpgsoftware.CharacterWarhammer;

import static cafetcraftteam.rpgsoftware.Characteristic.Primary;

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
        MASTER
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

    public abstract int getSkillValue(CharacterWarhammer characterCharacteristic);

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
}
