package cafetcraftteam.rpgsoftware.skill;

import android.support.annotation.NonNull;

import cafetcraftteam.rpgsoftware.CharacterWarhammer;

import static cafetcraftteam.rpgsoftware.Characteristic.Primary;

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
    public int getSkillValue(CharacterWarhammer character) {
        if (getLevel() == Level.NONE) {
            return character.getPrimaryProfile(getAssociatedCharacteristic())/2;
        }
        else {
            return character.getPrimaryProfile(getAssociatedCharacteristic())
                    + 10*(getLevel().ordinal() -1) + getBonus();
        }
    }
}
