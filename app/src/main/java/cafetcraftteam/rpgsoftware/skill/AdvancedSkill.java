package cafetcraftteam.rpgsoftware.skill;

import android.support.annotation.NonNull;

import cafetcraftteam.rpgsoftware.Profile;

/**
 * Created by Tago on 25/02/2016.
 */
public class AdvancedSkill extends Skill {
    /**
     * Constructor of a skill
     *
     * @param name           the name of the skill, must be not null or empty
     * @param characteristic the characteristic associated to the skill, must be not null
     * @param level          the level of mastery of this skill, must be not null
     * @param bonus          the bonus on this skill
     */
    public AdvancedSkill(@NonNull String name, @NonNull Profile.Primary characteristic, @NonNull Level level, int bonus) {
        super(name, characteristic, level, bonus);
    }

    /**
     * Constructor of a skill without any bonus
     *
     * @param name           the name of the skill, must be not null or empty
     * @param characteristic the characteristic associated to the skill, must be not null
     * @param level          the level of mastery of this skill, must be not null
     */
    public AdvancedSkill(@NonNull String name, @NonNull Profile.Primary characteristic, @NonNull Level level) {
        super(name, characteristic, level);
    }

    /**
     * Getter of the value of the skill with the actual bonus and the given profile
     * If the level of mastering is NONE, throw an IllegalStateException
     *
     * @param characterProfile the profile that use the skill, must be not null
     * @return the value as a positive integer
     */
    @Override
    public int getSkillValue(@NonNull Profile characterProfile) {
        if (characterProfile == null) {
            throw new IllegalArgumentException("The Profile should not be null");
        }

        if (getLevel() == Level.NONE) {
            throw new IllegalStateException("The skill must be at least acquired to be used");
        } else {
            return characterProfile.getCharacteristic(getAssociatedCharacteristic())
                    + 10 * (getLevel().ordinal() - 1) + getBonus();
        }
    }
}
