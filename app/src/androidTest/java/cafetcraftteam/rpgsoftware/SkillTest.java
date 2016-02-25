package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import static cafetcraftteam.rpgsoftware.Characteristic.Primary;
import static cafetcraftteam.rpgsoftware.Skill.Level;
import static junit.framework.Assert.assertEquals;

/**
 * Class that test the skill
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SkillTest {
    private final String mName = "Charm";
    private final Primary mAssociatedCharacteristic = Primary.FEL;
    private final Level mLevel = Level.NONE;
    private final int mBonus = 5;

    private final Skill mSkill = new Skill(mName, mAssociatedCharacteristic, mLevel, mBonus);

    @Test
    public void creationTest() {
        assertEquals(mName, mSkill.getName());
        assertEquals(mAssociatedCharacteristic, mSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, mSkill.getLevel());
        assertEquals(mBonus, mSkill.getBonus());

        Skill noBonusSkill = new Skill(mName, mAssociatedCharacteristic, mLevel);
        assertEquals(mName, noBonusSkill.getName());
        assertEquals(mAssociatedCharacteristic, noBonusSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, noBonusSkill.getLevel());
        assertEquals(0, noBonusSkill.getBonus());
    }

    @Test
    public void contractRespectName() {
        // give a null name should throw an exception
        try {
            new Skill(null, mAssociatedCharacteristic, mLevel, mBonus);
        } catch (IllegalArgumentException e) {
            assertEquals("The name must be not null or empty", e.getMessage());
        }

        // give an empty name should throw an exception
        try {
            new Skill("", mAssociatedCharacteristic, mLevel, mBonus);
        } catch (IllegalArgumentException e) {
            assertEquals("The name must be not null or empty", e.getMessage());
        }
    }

    @Test
    public void contractRespectCharacteristic() {
        // give a null characteristic should throw an exception
        try {
            new Skill(mName, null, mLevel);
        } catch (IllegalArgumentException e) {
            assertEquals("The characteristic must not be null", e.getMessage());
        }
    }

    @Test
    public void contractRespectLevel() {
        // give a null level should throw an exception
        try {
            new Skill(mName, mAssociatedCharacteristic, null);
        } catch (IllegalArgumentException e) {
            assertEquals("The level of mastery of the skill must not be null", e.getMessage());
        }
    }

    @Test
    public void contractRespectBonus() {
        // give a negative bonus should throw an exception
        try {
            new Skill(mName, mAssociatedCharacteristic, mLevel, -mBonus);
        } catch (IllegalArgumentException e) {
            assertEquals("The bonus must be positive", e.getMessage());
        }

        // give a zero bonus should not throw an exception
        Skill zeroBonusSkill = new Skill(mName, mAssociatedCharacteristic, mLevel, 0);
        assertEquals(0, zeroBonusSkill.getBonus());
    }

    @Test
    public void setBonusTest() {
        mSkill.setBonus(10);

        assertEquals(10, mSkill.getBonus());
    }
}
