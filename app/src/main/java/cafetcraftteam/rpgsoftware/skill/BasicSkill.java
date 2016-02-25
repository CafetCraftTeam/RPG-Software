package cafetcraftteam.rpgsoftware.skill;

import android.support.annotation.NonNull;

import cafetcraftteam.rpgsoftware.Profile;

import cafetcraftteam.rpgsoftware.Profile.Primary;

/**
 * The basic skill that could be used by everyone at half the value of the characteristic
 */
public class BasicSkill extends Skill {

    public enum BasicSkills {
        ANIMAL_CARE("Animal Care", Primary.INT),
        CHARM("Charm", Primary.FEL),
        COMMAND("Command", Primary.FEL),
        CONCEALMENT("Concealment", Primary.AG),
        CONSUME_ALCOHOL("Consume alcohol", Primary.T),
        DISGUISE("Disguise", Primary.FEL),
        DRIVE("Drive", Primary.S),
        EVALUATE("Evaluate", Primary.INT),
        GAMBLE("Gamble", Primary.INT),
        GOSSIP("Gossip", Primary.FEL),
        HAGGLE("Haggle", Primary.FEL),
        INTIMIDATE("Intimidate", Primary.S),
        OUTDOOR_SURVIVAL("Outdoor survival", Primary.INT),
        PERCEPTION("Perception", Primary.INT),
        RIDE("Ride", Primary.AG),
        ROW("Row", Primary.S),
        SCALE_SHEER_SURFACE("Scale sheer surface", Primary.S),
        SEARCH("Search", Primary.INT),
        SILENT_MOVE("Silent move", Primary.AG),
        SWIM("Swim", Primary.S);

        private final String mName;
        private final Primary mCharacteristic;

        BasicSkills(String name, Primary characteristic) {
            mName = name;
            mCharacteristic = characteristic;
        }

        @Override
        public String toString() {
            return mName;
        }

        public Primary getCharacteristic() {
            return mCharacteristic;
        }
    }

    /**
     * Constructor of a basic skill
     *
     * @param basicSkills    the basic skill wanted, must be not null
     * @param level          the level of mastery of this skill, must be not null
     * @param bonus          the bonus on this skill
     */
    public BasicSkill(@NonNull BasicSkills basicSkills,
                      @NonNull Level level,
                      int bonus) {
        super(basicSkills.toString(), basicSkills.getCharacteristic(), level, bonus);
    }

    /**
     * Constructor of a basic skill without any bonus
     *
     * @param basicSkills    the basic skill wanted, must be not null
     * @param level          the level of mastery of this skill, must be not null
     */
    public BasicSkill(@NonNull BasicSkills basicSkills,
                      @NonNull Level level) {
        super(basicSkills.toString(), basicSkills.getCharacteristic(), level);
    }

    /**
     * Getter of the value of the skill with the actual bonus and the given profile
     * If the level of mastering is NONE, calculate with the characteristic divided by 2
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
            return characterProfile.getCharacteristic(getAssociatedCharacteristic()) / 2;
        } else {
            return characterProfile.getCharacteristic(getAssociatedCharacteristic())
                    + 10 * (getLevel().ordinal() - 1) + getBonus();
        }
    }
}
