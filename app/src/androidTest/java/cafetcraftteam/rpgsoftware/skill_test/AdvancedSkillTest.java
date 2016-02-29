package cafetcraftteam.rpgsoftware.skill_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.Profile;
import cafetcraftteam.rpgsoftware.skill.AdvancedSkill;
import cafetcraftteam.rpgsoftware.skill.Skill.Level;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Class that test the BasicSkill
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AdvancedSkillTest {
    private final String mName = "Perception";
    private final Profile.Primary mAssociatedCharacteristic = Profile.Primary.INT;
    private final Level mLevel = Level.ACQUIRE;
    private final int mBonus = 15;

    private final AdvancedSkill mAdvancedSkill
            = new AdvancedSkill(mName, mAssociatedCharacteristic, mLevel, mBonus);

    private final Profile mAncestorGurdillProfile = Profile.ancestorGurdillProfile();

    @Test
    public void creationTest() {
        assertEquals(mName, mAdvancedSkill.getName());
        assertEquals(mAssociatedCharacteristic, mAdvancedSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, mAdvancedSkill.getLevel());
        assertEquals(mBonus, mAdvancedSkill.getBonus());

        AdvancedSkill zeroBonusAdvancedSkill = new AdvancedSkill(mName, mAssociatedCharacteristic, mLevel);
        assertEquals(mName, zeroBonusAdvancedSkill.getName());
        assertEquals(mAssociatedCharacteristic, zeroBonusAdvancedSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, zeroBonusAdvancedSkill.getLevel());
        assertEquals(0, zeroBonusAdvancedSkill.getBonus());
    }

    @Test
    public void getSkillValueTest() {
        // with a level of acquire
        assertEquals(mAncestorGurdillProfile.getCharacteristic(mAssociatedCharacteristic) + mBonus,
                mAdvancedSkill.getSkillValue(mAncestorGurdillProfile));

        // with a level of master
        AdvancedSkill masterSkill = new AdvancedSkill(
                mName,
                mAssociatedCharacteristic,
                Level.MASTER
        );
        assertEquals(mAncestorGurdillProfile.getCharacteristic(mAssociatedCharacteristic) + 20,
                masterSkill.getSkillValue(mAncestorGurdillProfile));

        // with a level of None should throw an exception
        AdvancedSkill noneSkill = new AdvancedSkill(
                mName,
                mAssociatedCharacteristic,
                Level.NONE
        );
        try {
            noneSkill.getSkillValue(mAncestorGurdillProfile);
            fail("with a level of None should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("The skill must be at least acquired to be used", e.getMessage());
        }

        // give a null Profile should throw an exception
        try {
            mAdvancedSkill.getSkillValue(null);
            fail("give a null Profile should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The Profile should not be null", e.getMessage());
        }
    }
}
