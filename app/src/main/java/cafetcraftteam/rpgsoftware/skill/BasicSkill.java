package cafetcraftteam.rpgsoftware.skill;

import android.support.annotation.NonNull;

import cafetcraftteam.rpgsoftware.Profile;

import static cafetcraftteam.rpgsoftware.Profile.Primary;

/**
 * The basic skill that could be used by everyone at half the value of the characteristic
 */
public class BasicSkill extends Skill {
    public BasicSkill(@NonNull String name,
                      @NonNull Primary characteristic,
                      @NonNull Level level, int bonus) {
        super(name, characteristic, level, bonus);
    }

    public BasicSkill(@NonNull String name,
                      @NonNull Primary characteristic,
                      @NonNull Level level) {
        super(name, characteristic, level);
    }

    @Override
    public int getSkillValue(Profile characterProfile) {
        if (getLevel() == Level.NONE) {
            return characterProfile.getCharacteristic(getAssociatedCharacteristic()) / 2;
        } else {
            return characterProfile.getCharacteristic(getAssociatedCharacteristic())
                    + 10 * (getLevel().ordinal() - 1) + getBonus();
        }
    }
}
