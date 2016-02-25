package cafetcraftteam.rpgsoftware.skill;

import android.support.annotation.NonNull;

import cafetcraftteam.rpgsoftware.Profile;

import static cafetcraftteam.rpgsoftware.Profile.Primary;

/**
 * The basic skill that could be used by everyone at half the value of the characteristic
 */
public class BasicSkill extends Skill {
    /**
     * Constructor of a basic skill
     *
     * @param name           the name of the skill, must be not null or empty
     * @param characteristic the characteristic associated to the skill, must be not null
     * @param level          the level of mastery of this skill, must be not null
     * @param bonus          the bonus on this skill
     */
    public BasicSkill(@NonNull String name,
                      @NonNull Primary characteristic,
                      @NonNull Level level, int bonus) {
        super(name, characteristic, level, bonus);
    }

    /**
     * Constructor of a basic skill without any bonus
     *
     * @param name           the name of the skill, must be not null or empty
     * @param characteristic the characteristic associated to the skill, must be not null
     * @param level          the level of mastery of this skill, must be not null
     */
    public BasicSkill(@NonNull String name,
                      @NonNull Primary characteristic,
                      @NonNull Level level) {
        super(name, characteristic, level);
    }

    /**
     * Getter of the value of the skill with the actual bonus and the given profile
     * @param characterProfile the profile that use the skill
     * @return the value as a positive integer
     */
    @Override
    public int getSkillValue(@NonNull Profile characterProfile) {
        if (characterProfile == null) {
            throw new IllegalArgumentException("The Profile should not be null");
        }

        if (getLevel() == Level.NONE) {
            return characterProfile.getCharacteristic(getAssociatedCharacteristic()) / 2;
        } else {
            return characterProfile.getCharacteristic(getAssociatedCharacteristic())
                    + 10 * (getLevel().ordinal() - 1) + getBonus();
        }
    }
}
