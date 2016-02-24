package cafetcraftteam.rpgsoftware.character_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import cafetcraftteam.rpgsoftware.character.Character;
import cafetcraftteam.rpgsoftware.character.CharacterWarhammer;

import static junit.framework.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacterWarhammerTest {

    private CharacterWarhammer Pujima = new CharacterWarhammer("Pujima","1662", cafetcraftteam.rpgsoftware.character.Character.Race.HUMAN,
            36, Character.Sex.MALE,"blue",185,"Braun",78,"Lion",2,"Birthplace","None");

    @Before
    public void init() {
    }
    @Test
    public void TestConstructor() {
        assertEquals("Pujima",Pujima.getName());
        assertEquals("1662",Pujima.getYear());
        assertEquals(Character.Race.HUMAN,Pujima.getRace());
        assertEquals(36,Pujima.getAge());
        assertEquals(Character.Sex.MALE,Pujima.getSex());
        assertEquals("blue",Pujima.getEyeColour());
        assertEquals(185,Pujima.getHeight());
        assertEquals("Braun",Pujima.getHairColour());
        assertEquals(78,Pujima.getWeight());
        assertEquals("Lion",Pujima.getStarSign());
        assertEquals(2,Pujima.getNumberOfSiblings());
        assertEquals("Birthplace",Pujima.getBirthPlace());
        assertEquals("None",Pujima.getDistinguishingMark());
    }
    @Test
    public void TestProfession() {
        Pujima.setProfession("Worker");
        assertEquals("Worker",Pujima.getProfession());
    }
    /*@Test
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
    }*/
    @Test
    public void TestActualFortune() {
        Pujima.setActualFortune(2);
        assertEquals(2, Pujima.getActualFortune());
    }
    /*@Test
    public void TestTotalWounds() {
        Pujima.setTotalWounds(2);
        assertEquals(2,Pujima.getTotalWounds());
    }*/
    @Test
    public void TestActualWounds() {
        Pujima.setActualWounds(2);
        assertEquals(2, Pujima.getActualWounds());
    }
}


