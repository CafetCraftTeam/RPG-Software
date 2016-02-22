package cafetcraftteam.rpgsoftware;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import static junit.framework.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacterWarhammerTest {

    private CharacterWarhammer Pujima = new CharacterWarhammer("Pujima","cerschae","Warhammer","1662",
            "Human",36,"M","blue",185,"Braun",78,"Lion",2,"Birthplace","None");

    @Before
    public void init() {
    }
    @Test
    public void TestConstructor() {
        assertEquals("Pujima",Pujima.getName());
        assertEquals("cerschae",Pujima.getRealName());
        assertEquals("Warhammer",Pujima.getCampaign());
        assertEquals("1662",Pujima.getYear());
        assertEquals("Human",Pujima.getRace());
        assertEquals(36,Pujima.getAge());
        assertEquals("M",Pujima.getSex());
        assertEquals("blue",Pujima.getEyecolor());
        assertEquals(185,Pujima.getHeight());
        assertEquals("Braun",Pujima.getHaircolor());
        assertEquals(78,Pujima.getWeight());
        assertEquals("Lion",Pujima.getSA());
        assertEquals(2,Pujima.getNbBrSis());
        assertEquals("Birthplace",Pujima.getBirthPlace());
        assertEquals("None",Pujima.getDistinctifSign());
    }
    @Test
    public void TestProfession() {
        Pujima.setProfession("Worker");
        assertEquals("Worker",Pujima.getProfession());
    }
    @Test
    public void TestPrimaryProfile() {
        Pujima.setPrimaryProfile(PrimCharacteristic.CC, 30);
        assertEquals(Integer.valueOf(30),Pujima.getPrimaryProfile(PrimCharacteristic.CC));
    }
    @Test
    public void TestSecondaryProfile() {
        Pujima.setSecondaryProfile(SecondCharacteristic.A, 30);
        assertEquals(Integer.valueOf(30),Pujima.getSecondaryProfile(SecondCharacteristic.A));
    }
    @Test
    public void TestMovement() {
        Pujima.setMovement(5);
        assertEquals(5, Pujima.getMovement());
    }
    @Test
    public void TestTotalFortune() {
        Pujima.setTotalFortune(2);
        assertEquals(2,Pujima.getTotalFortune());
    }
    @Test
    public void TestActualFortune() {
        Pujima.setActualFortune(2);
        assertEquals(2, Pujima.getActualFortune());
    }
    @Test
    public void TestTotalWounds() {
        Pujima.setTotalWounds(2);
        assertEquals(2,Pujima.getTotalWounds());
    }
    @Test
    public void TestActualWounds() {
        Pujima.setActualWounds(2);
        assertEquals(2, Pujima.getActualWounds());
    }
    @Test
    public void TestDefensePoints() {
        Pujima.setDefensePoints(BodyPart.HEAD, 2);
        assertEquals(2,Pujima.getDefensePoints(BodyPart.HEAD));
    }
}


