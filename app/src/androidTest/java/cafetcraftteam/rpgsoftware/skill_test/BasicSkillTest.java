package cafetcraftteam.rpgsoftware.skill_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.Profile;
import cafetcraftteam.rpgsoftware.skill.BasicSkill;
import cafetcraftteam.rpgsoftware.skill.Skill.Level;

import static cafetcraftteam.rpgsoftware.skill.BasicSkill.BasicSkills;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Class that test the BasicSkill
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BasicSkillTest {
    private final BasicSkills mBasicSkills = BasicSkills.DRIVE;
    private final Level mLevel = Level.ACQUIRE;
    private final int mBonus = 10;

    private final BasicSkill mBasicSkill
            = new BasicSkill(mBasicSkills, mLevel, mBonus);

    private final Profile mAncestorGurdillProfile = Profile.ancestorGurdillProfile();

    @Test
    public void creationTest() {
        assertEquals(mBasicSkills.toString(), mBasicSkill.getName());
        assertEquals(mBasicSkills.getCharacteristic(), mBasicSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, mBasicSkill.getLevel());
        assertEquals(mBonus, mBasicSkill.getBonus());

        BasicSkills zeroBonus = BasicSkills.PERCEPTION;
        BasicSkill zeroBonusBasicSkill = new BasicSkill(zeroBonus, mLevel);
        assertEquals(zeroBonus.toString(), zeroBonusBasicSkill.getName());
        assertEquals(zeroBonus.getCharacteristic(), zeroBonusBasicSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, zeroBonusBasicSkill.getLevel());
        assertEquals(0, zeroBonusBasicSkill.getBonus());
    }

    @Test
    public void getSkillValueTest() {
        // with a level of acquire
        assertEquals(mAncestorGurdillProfile.getCharacteristic(mBasicSkills.getCharacteristic()) + mBonus,
                mBasicSkill.getSkillValue(mAncestorGurdillProfile));

        // with a level of master
        BasicSkills masterLevel = BasicSkills.CHARM;
        BasicSkill masterSkill = new BasicSkill(
                masterLevel,
                Level.MASTER
        );
        assertEquals(mAncestorGurdillProfile.getCharacteristic(masterLevel.getCharacteristic()) + 20,
                masterSkill.getSkillValue(mAncestorGurdillProfile));

        // with a level of None
        BasicSkills noneLevel = BasicSkills.CONCEALMENT;
        BasicSkill noneSkill = new BasicSkill(
                noneLevel,
                Level.NONE
        );
        assertEquals(mAncestorGurdillProfile.getCharacteristic(noneLevel.getCharacteristic()) / 2,
                noneSkill.getSkillValue(mAncestorGurdillProfile));

        // give a null Profile should throw an exception
        try {
            mBasicSkill.getSkillValue(null);
            fail("give a null Profile should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The Profile should not be null", e.getMessage());
        }
    }

    @Test
    public void deepCopyTest() {
        BasicSkill same = mBasicSkill;
        BasicSkill deepCopy = mBasicSkill.deepCopy();

        int bonus = 12;
        mBasicSkill.setBonus(bonus);

        assertEquals(bonus, mBasicSkill.getBonus());
        assertEquals(bonus, same.getBonus());
        assertEquals(mBonus, deepCopy.getBonus());

        mBasicSkill.improve();

        assertEquals(mLevel.improve(), mBasicSkill.getLevel());
        assertEquals(mLevel.improve(), same.getLevel());
        assertEquals(mLevel, deepCopy.getLevel());
    }
}
