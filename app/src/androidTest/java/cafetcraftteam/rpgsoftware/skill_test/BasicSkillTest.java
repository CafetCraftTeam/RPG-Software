package cafetcraftteam.rpgsoftware.skill_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import cafetcraftteam.rpgsoftware.CharacterWarhammer;
import cafetcraftteam.rpgsoftware.skill.BasicSkill;
import cafetcraftteam.rpgsoftware.skill.Skill.Level;

import static cafetcraftteam.rpgsoftware.Profile.Primary;
import static junit.framework.Assert.assertEquals;

/**
 * Class that test the BasicSkill
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BasicSkillTest {
    private final String mName = "Drive";
    private final Primary mAssociatedCharacteristic = Primary.S;
    private final Level mLevel = Level.ACQUIRE;
    private final int mBonus = 10;

    private final BasicSkill mBasicSkill
            = new BasicSkill(mName, mAssociatedCharacteristic, mLevel, mBonus);

    private CharacterWarhammer mAncestorGurdill = CharacterWarhammer.ancestorGurdill();

    @Test
    public void creationTest() {
        assertEquals(mName, mBasicSkill.getName());
        assertEquals(mAssociatedCharacteristic, mBasicSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, mBasicSkill.getLevel());
        assertEquals(mBonus, mBasicSkill.getBonus());

        BasicSkill zeroBonusBasicSkill = new BasicSkill(mName, mAssociatedCharacteristic, mLevel);
        assertEquals(mName, zeroBonusBasicSkill.getName());
        assertEquals(mAssociatedCharacteristic, zeroBonusBasicSkill.getAssociatedCharacteristic());
        assertEquals(mLevel, zeroBonusBasicSkill.getLevel());
        assertEquals(0, zeroBonusBasicSkill.getBonus());
    }

    @Test
    public void getSkillValueTest() {
        // with a level of acquire or above
//        assertEquals((int) mAncestorGurdill.getPrimaryProfile(mAssociatedCharacteristic),
//              mBasicSkill.getSkillValue(mAncestorGurdill));
    }
}
