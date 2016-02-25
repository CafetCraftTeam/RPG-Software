package cafetcraftteam.rpgsoftware;

import android.support.annotation.NonNull;

import static cafetcraftteam.rpgsoftware.Characteristic.Primary;

/**
 * Class that represent a Warhammer skill
 */
public class Skill {

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
    private Level mLevel; //
    private int mBonus;

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

    /*
    //Attendre révision de la classe characteristic
    public int computeSkillValue(){
        int temp = 10;
        //Verifier la formule de calcul :
        return CharacterWarhammer.getPrimaryProfile(mChar)*(1+0.1*mLevel) + mBonus;
    }
    */
    public String getName() {
        return mName;
    }

    public Primary getAssociatedCharacteritic() {
        return mAssociatedCharacteristic;
    }

    public Level getLevel() {
        return mLevel;
    }

    public int getBonus() {
        return mBonus;
    }

    public void setBonus(int Bonus) {
        mBonus = Bonus;
    }
}
