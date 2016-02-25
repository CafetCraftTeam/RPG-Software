package cafetcraftteam.rpgsoftware.skill_test;

import android.support.annotation.NonNull;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.Profile;
import cafetcraftteam.rpgsoftware.skill.Skill;

import static cafetcraftteam.rpgsoftware.Profile.Primary;
import static cafetcraftteam.rpgsoftware.skill.Skill.Level;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Class that test the skill
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SkillTest {

    // region DEFINE A CONCRETE CLASS===============================================================

    private class ConcreteSkill extends Skill {

        public ConcreteSkill(@NonNull String name,
                             @NonNull Primary characteristic,
                             @NonNull Level level,
                             int bonus) {
            super(name, characteristic, level, bonus);
        }

        public ConcreteSkill(@NonNull String name,
                             @NonNull Primary characteristic,
                             @NonNull Level level) {
            super(name, characteristic, level, 0);
        }

        @Override
        public int getSkillValue(@NonNull Profile characterProfile) {
            return 0;
        }
    }

    // endregion====================================================================================

    private final String mName = "Charm";
    private final Primary mAssociatedCharacteristic = Primary.FEL;
    private final Level mLevel = Level.NONE;
    private final int mBonus = 5;

    private final Skill mSkill = new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel, mBonus);

    @Test
    public void creationTest() {
        assertEquals(mName, mSkill.getName());
        assertEquals(mAssociatedCharacteristic, mSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, mSkill.getLevel());
        assertEquals(mBonus, mSkill.getBonus());

        Skill noBonusSkill = new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel);
        assertEquals(mName, noBonusSkill.getName());
        assertEquals(mAssociatedCharacteristic, noBonusSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, noBonusSkill.getLevel());
        assertEquals(0, noBonusSkill.getBonus());
    }

    @Test
    public void contractRespectName() {
        // give a null name should throw an exception
        try {
            new ConcreteSkill(null, mAssociatedCharacteristic, mLevel, mBonus);
            fail("give a null name should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The name must be not null or empty", e.getMessage());
        }

        // give an empty name should throw an exception
        try {
            new ConcreteSkill("", mAssociatedCharacteristic, mLevel, mBonus);
            fail("give an empty name should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The name must be not null or empty", e.getMessage());
        }
    }

    @Test
    public void contractRespectCharacteristic() {
        // give a null characteristic should throw an exception
        try {
            new ConcreteSkill(mName, null, mLevel);
            fail("give a null characteristic should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The characteristic must not be null", e.getMessage());
        }
    }

    @Test
    public void contractRespectLevel() {
        // give a null level should throw an exception
        try {
            new ConcreteSkill(mName, mAssociatedCharacteristic, null);
            fail("give a null level should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The level of mastery of the skill must not be null", e.getMessage());
        }
    }

    @Test
    public void contractRespectBonus() {
        // give a negative bonus should throw an exception
        try {
            new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel, -mBonus);
            fail("give a negative bonus should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The bonus must be positive", e.getMessage());
        }

        // give a zero bonus should not throw an exception
        Skill zeroBonusSkill = new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel, 0);
        assertEquals(0, zeroBonusSkill.getBonus());
    }

    @Test
    public void setBonusTest() {
        // set a bonus
        mSkill.setBonus(10);

        assertEquals(10, mSkill.getBonus());

        // set a negative bonus should throw an exception
        try {
            mSkill.setBonus(-mBonus);
            fail("set a negative bonus should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The bonus must be positive", e.getMessage());
        }
    }

    @Test
    public void equalsTest() {
        Skill same = mSkill;
        Skill deepCopy = new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel, mBonus);
        Skill otherName = new ConcreteSkill("Other",mAssociatedCharacteristic, mLevel, mBonus);
        Skill otherCharacteristic = new ConcreteSkill(mName, Primary.WS, mLevel, mBonus);
        Skill otherLevel = new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel.improve(), mBonus);
        Skill otherBonus = new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel, mBonus + 5);

        assertFalse("x=null", mSkill.equals(null));
        assertTrue("x=x", mSkill.equals(mSkill));
        assertTrue("x = same", mSkill.equals(same));
        assertTrue("x = deepCopy", mSkill.equals(deepCopy));
        assertFalse("x = otherName", mSkill.equals(otherName));
        assertFalse("otherName = x", otherName.equals(mSkill));
        assertFalse("x = otherCharacteristic", mSkill.equals(otherCharacteristic));
        assertTrue("x = otherLevel", mSkill.equals(otherLevel));
        assertTrue("x = otherBonus", mSkill.equals(otherBonus));
    }

    @Test
    public void hashCodeTest() {
        Skill same = mSkill;
        Skill deepCopy = new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel, mBonus);
        Skill otherName = new ConcreteSkill("Other",mAssociatedCharacteristic, mLevel, mBonus);
        Skill otherCharacteristic = new ConcreteSkill(mName, Primary.WS, mLevel, mBonus);
        Skill otherLevel = new ConcreteSkill(mName, mAssociatedCharacteristic,
                mLevel.improve().improve(), mBonus);
        Skill otherBonus = new ConcreteSkill(mName, mAssociatedCharacteristic, mLevel, mBonus + 10);

        assertEquals("x=x", mSkill.hashCode(), mSkill.hashCode());
        assertEquals("x = same", mSkill.hashCode(), same.hashCode());
        assertEquals("x = deepCopy", mSkill.hashCode(), deepCopy.hashCode());
        assertNotSame("x = otherName", mSkill.hashCode(), otherName.hashCode());
        assertNotSame("x = otherCharacteristic", mSkill.hashCode(), otherCharacteristic.hashCode());
        assertEquals("x = otherLevel", mSkill.hashCode(), otherLevel.hashCode());
        assertEquals("x = otherBonus", mSkill.hashCode(), otherBonus.hashCode());
    }
}
