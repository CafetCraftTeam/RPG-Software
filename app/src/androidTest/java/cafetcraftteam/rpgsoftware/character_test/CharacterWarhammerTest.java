package cafetcraftteam.rpgsoftware.character_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import cafetcraftteam.rpgsoftware.character.Character;
import cafetcraftteam.rpgsoftware.character.CharacterWarhammer;
import cafetcraftteam.rpgsoftware.character.Hands;
import cafetcraftteam.rpgsoftware.equipment.Armour;
import cafetcraftteam.rpgsoftware.equipment.Equipment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Class that test the CharacterWarhammer class
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CharacterWarhammerTest {

    private final String mName = "Pujima";
    private final Character.Race mRace = Character.Race.HUMAN;
    private final Character.Sex mSex = Character.Sex.MALE;
    private final int mWeight = 78;
    private final int mHeight = 185;
    private final int mAge = 36;
    private final String mEyeColour = "blue";
    private final String mHairColour = "Brawn";
    private final String mStarSign = "Lion";
    private final int mNumberOfSiblings = 2;
    private final String mBirthplace = "Birthplace";
    private final String mDistinguishingMarks = "None";
    private final String mProfession = "";

    private CharacterWarhammer Pujima;

    private final Equipment mEquipment = new Equipment(
            "Book",
            1,
            20,
            Equipment.Quality.COMMON,
            ""
    );

    private Armour mArmour;
    private final Map<CharacterWarhammer.BodyPart, Integer> mProtectedParts
            = new EnumMap<>(CharacterWarhammer.BodyPart.class);

    @Before
    public void init() throws InstantiationException {
        Pujima = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );

        mProtectedParts.put(CharacterWarhammer.BodyPart.LEFT_ARM, 1);

        mArmour = new Armour(
                "Leather",
                80,
                1000,
                Equipment.Quality.COMMON,
                "",
                mProtectedParts
        );
    }

    @Test
    public void testConstructor() {
        assertEquals(mName, Pujima.getName());
        assertEquals(mRace, Pujima.getRace());
        assertEquals(mSex, Pujima.getSex());
        assertEquals(mWeight, Pujima.getWeight());
        assertEquals(mHeight, Pujima.getHeight());
        assertEquals(mAge, Pujima.getAge());
        assertEquals(mEyeColour, Pujima.getEyeColour());
        assertEquals(mHairColour, Pujima.getHairColour());
        assertEquals(mStarSign, Pujima.getStarSign());
        assertEquals(mNumberOfSiblings, Pujima.getNumberOfSiblings());
        assertEquals(mBirthplace, Pujima.getBirthplace());
        assertEquals(mDistinguishingMarks, Pujima.getDistinguishingMarks());
        assertEquals(mProfession, Pujima.getProfession());
        assertEquals(0, Pujima.getInventory().size());
    }

    // region CONTRACT RESPECT======================================================================
    @Test
    public void contractRespectEyeColour() throws InstantiationException {
        // the eye colour could be null and will be replace by an empty string
        CharacterWarhammer nullEyeColour = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                null,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals("", nullEyeColour.getEyeColour());
    }

    @Test
    public void contractRespectHairColour() throws InstantiationException {
        // the hair colour could be null and will be replace by an empty string
        CharacterWarhammer nullHairColour = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                null,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals("", nullHairColour.getHairColour());
    }

    @Test
    public void contractRespectStarSign() throws InstantiationException {
        // the star sign could be null and will be replace by an empty string
        CharacterWarhammer nullStarSign = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                null,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals("", nullStarSign.getStarSign());
    }

    @Test
    public void contractRespectNumberOfSiblings() throws InstantiationException {
        // the number of siblings could be zero
        CharacterWarhammer zeroNumberOfSiblings = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                0,
                mBirthplace,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals(0, zeroNumberOfSiblings.getNumberOfSiblings());

        // the number of siblings could not be negative
        try {
            new CharacterWarhammer(
                    mName,
                    mRace,
                    mSex,
                    mWeight,
                    mHeight,
                    mAge,
                    mEyeColour,
                    mHairColour,
                    mStarSign,
                    -mNumberOfSiblings,
                    mBirthplace,
                    mDistinguishingMarks,
                    mProfession
            );
            fail("A negative number of siblings have not throw an exception");
        } catch (InstantiationException e) {
            // success
        }
    }

    @Test
    public void contractRespectBirthplace() throws InstantiationException {
        // the birthplace could be null and will be replace by an empty string
        CharacterWarhammer nullBirthplace = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                null,
                mDistinguishingMarks,
                mProfession
        );
        assertEquals("", nullBirthplace.getBirthplace());
    }

    @Test
    public void contractRespectDistinguishingMarks() throws InstantiationException {
        // the distinguishing marks could be null and will be replace by an empty string
        CharacterWarhammer nullDistinguishingMarks = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                null,
                mProfession
        );
        assertEquals("", nullDistinguishingMarks.getDistinguishingMarks());
    }

    @Test
    public void contractRespectProfession() throws InstantiationException {
        // the profession could be null and will be replace by an empty string
        CharacterWarhammer nullProfession = new CharacterWarhammer(
                mName,
                mRace,
                mSex,
                mWeight,
                mHeight,
                mAge,
                mEyeColour,
                mHairColour,
                mStarSign,
                mNumberOfSiblings,
                mBirthplace,
                mDistinguishingMarks,
                null
        );
        assertEquals("", nullProfession.getProfession());
    }

    // endregion====================================================================================


    @Test
    public void TestSetterProfession() {
        // set a profession
        String profession = "Worker";
        Pujima.setProfession(profession);
        assertEquals(profession, Pujima.getProfession());

        // setting a null profession should throw an exception and be replace by an empty string
        String nullProfession = null;
        Pujima.setProfession(nullProfession);
        assertEquals("", Pujima.getProfession());
    }

    @Test
    public void TestActualFortune() {
        Pujima.setActualFortune(2);
        assertEquals(2, Pujima.getActualFortunePoints());
    }

    @Test
    public void TestActualWounds() {
        Pujima.setActualWounds(2);
        assertEquals(2, Pujima.getActualWounds());
    }

    // region EQUIPMENT=============================================================================

    @Test
    public void addEquipmentTest() {
        // add an equipment
        Pujima.addEquipment(mEquipment);

        assertTrue(Pujima.getInventory().containsKey(mEquipment));
        assertEquals(1, (int) Pujima.getInventory().get(mEquipment));

        // add multiple time the equipment
        Pujima.addEquipment(mEquipment);
        assertEquals(2, (int) Pujima.getInventory().get(mEquipment));

        Pujima.addEquipment(mEquipment);
        assertEquals(3, (int) Pujima.getInventory().get(mEquipment));

        // add a null equipment should throw an exception
        try {
            Pujima.addEquipment(null);
            fail("add a null equipment should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The equipment must be not null", e.getMessage());
        }
    }

    @Test
    public void removeEquipmentTest() {
        // remove an equipment which is not already in the inventory should throw an exception
        try {
            Pujima.removeEquipment(mEquipment);
            fail("remove an equipment which is not already in the inventory should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The equipment to remove must already be in the inventory", e.getMessage());
        }

        //remove an equipment
        Pujima.addEquipment(mEquipment);
        Pujima.addEquipment(mEquipment);
        Pujima.addEquipment(mEquipment);

        Pujima.removeEquipment(mEquipment);
        assertEquals(1, Pujima.getInventory().size());
        assertTrue(Pujima.getInventory().containsKey(mEquipment));
        assertEquals(2, (int) Pujima.getInventory().get(mEquipment));

        Pujima.removeEquipment(mEquipment);
        assertEquals(1, Pujima.getInventory().size());
        assertTrue(Pujima.getInventory().containsKey(mEquipment));
        assertEquals(1, (int) Pujima.getInventory().get(mEquipment));

        Pujima.removeEquipment(mEquipment);
        assertEquals(0, Pujima.getInventory().size());
        assertFalse(Pujima.getInventory().containsKey(mEquipment));

        // remove a null equipment should throw an exception
        Pujima.addEquipment(mEquipment);
        try {
            Pujima.removeEquipment(null);
            fail("remove a null equipment should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The equipment to remove should not be null", e.getMessage());
        }
    }

    @Test
    public void takeItemTest() {
        // take an equipment in the left hand
        Pujima.takeItem(mEquipment, Hands.Handle.LEFT);

        List<Equipment> leftDroppedItem = Pujima.dropItem(Hands.Handle.BOTH);
        assertEquals(1, leftDroppedItem.size());
        assertEquals(mEquipment, leftDroppedItem.get(0));

        // take an equipment in the right hand
        Pujima.takeItem(mEquipment, Hands.Handle.RIGHT);

        List<Equipment> rightDroppedItem = Pujima.dropItem(Hands.Handle.BOTH);
        assertEquals(1, rightDroppedItem.size());
        assertEquals(mEquipment, rightDroppedItem.get(0));

        // take an equipment in both hands
        Pujima.takeItem(mEquipment, Hands.Handle.BOTH);

        List<Equipment> bothDroppedItem = Pujima.dropItem(Hands.Handle.BOTH);
        assertEquals(2, bothDroppedItem.size());
        assertEquals(mEquipment, bothDroppedItem.get(0));
        assertEquals(mEquipment, bothDroppedItem.get(1));

        // take a null equipment should throw an exception
        try {
            Pujima.takeItem(null, Hands.Handle.BOTH);
            fail("take a null equipment should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The equipment to take must not be null", e.getMessage());
        }

        // take a equipment with a null handle should throw an exception
        try {
            Pujima.takeItem(mEquipment, null);
            fail("take a equipment with a null handle should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The handle for taking must not be null", e.getMessage());
        }

        // take a equipment with an already occupied handle should throw an exception
        Pujima.takeItem(mEquipment, Hands.Handle.RIGHT);

        try {
            Pujima.takeItem(mEquipment, Hands.Handle.BOTH);
            fail("take a equipment with an already occupied handle should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("Both hands must be empty to unsheathe something with it",
                    e.getMessage());
        }
    }

    @Test
    public void dropItemTest() {
        // drop an empty handle should throw an exception
        try {
            Pujima.dropItem(Hands.Handle.LEFT);
            fail("drop an empty handle should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("The left hand must not be empty", e.getMessage());
        }

        try {
            Pujima.dropItem(Hands.Handle.RIGHT);
            fail("drop an empty handle should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("The right hand must not be empty", e.getMessage());
        }

        try {
            Pujima.dropItem(Hands.Handle.BOTH);
            fail("drop an empty handle should throw an exception");
        } catch (IllegalStateException e) {
            assertEquals("Both hand must not be empty", e.getMessage());
        }

        // drop an item at left
        Pujima.takeItem(mEquipment, Hands.Handle.BOTH);
        List<Equipment> leftDroppedItem = Pujima.dropItem(Hands.Handle.LEFT);
        assertEquals(1, leftDroppedItem.size());
        assertEquals(mEquipment, leftDroppedItem.get(0));
        assertEquals(mEquipment, Pujima.dropItem(Hands.Handle.RIGHT).get(0));

        // drop an item at right
        Pujima.takeItem(mEquipment, Hands.Handle.BOTH);
        List<Equipment> rightDroppedItem = Pujima.dropItem(Hands.Handle.RIGHT);
        assertEquals(1, rightDroppedItem.size());
        assertEquals(mEquipment, rightDroppedItem.get(0));
        assertEquals(mEquipment, Pujima.dropItem(Hands.Handle.LEFT).get(0));

        // drop an item at both
        Pujima.takeItem(mEquipment, Hands.Handle.BOTH);
        List<Equipment> bothDroppedItem = Pujima.dropItem(Hands.Handle.BOTH);
        assertEquals(2, bothDroppedItem.size());
        assertEquals(mEquipment, bothDroppedItem.get(0));
        assertEquals(mEquipment, bothDroppedItem.get(1));
    }

    @Test
    public void wearAnArmourTest() {
        // wear an armour for the left arm
        Pujima.wearAnArmour(mArmour);
        assertTrue(Pujima.isProtected(mProtectedParts.keySet().iterator().next()));
        assertEquals(mArmour, Pujima.takeOffArmour(mArmour));
        assertFalse(Pujima.isProtected(mProtectedParts.keySet().iterator().next()));

        // wear an armour for the right arm and left leg
        Map<CharacterWarhammer.BodyPart, Integer> multipleBodyParts =
                new EnumMap<>(CharacterWarhammer.BodyPart.class);
        multipleBodyParts.put(CharacterWarhammer.BodyPart.RIGHT_ARM, 1);
        multipleBodyParts.put(CharacterWarhammer.BodyPart.LEFT_LEG, 1);

        Armour multipleArmour = new Armour(
                mArmour.getName(),
                mArmour.getEncumbering(),
                mArmour.getPrice(),
                mArmour.getQuality(),
                mArmour.getDescription(),
                multipleBodyParts
        );
        Pujima.wearAnArmour(multipleArmour);
        assertTrue(Pujima.isProtected(multipleBodyParts.keySet().iterator().next()));
        assertTrue(Pujima.isProtected(CharacterWarhammer.BodyPart.LEFT_LEG));
        assertEquals(multipleArmour, Pujima.takeOffArmour(multipleArmour));
        assertFalse(Pujima.isProtected(multipleBodyParts.keySet().iterator().next()));
        assertFalse(Pujima.isProtected(CharacterWarhammer.BodyPart.LEFT_LEG));

        // wear multiple armour for the right arm and left leg
        Pujima.wearAnArmour(mArmour);
        Pujima.wearAnArmour(multipleArmour);

        assertTrue(Pujima.isProtected(mProtectedParts.keySet().iterator().next()));
        assertTrue(Pujima.isProtected(multipleBodyParts.keySet().iterator().next()));
        assertTrue(Pujima.isProtected(CharacterWarhammer.BodyPart.LEFT_LEG));
        assertEquals(mArmour, Pujima.takeOffArmour(mArmour));
        assertEquals(multipleArmour, Pujima.takeOffArmour(multipleArmour));
        assertFalse(Pujima.isProtected(mProtectedParts.keySet().iterator().next()));
        assertFalse(Pujima.isProtected(multipleBodyParts.keySet().iterator().next()));
        assertFalse(Pujima.isProtected(CharacterWarhammer.BodyPart.LEFT_LEG));

        // wear a null armour should throw an exception
        try {
            Pujima.wearAnArmour(null);
            fail("wear a null armour should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The armour must be not null", e.getMessage());
        }

        // wear an armour on an already occupied body part should throw an exception
        Pujima.wearAnArmour(mArmour);
        try {
            Armour differentArmour = new Armour(
                    "Not the same",
                    mArmour.getEncumbering(),
                    mArmour.getPrice(),
                    mArmour.getQuality(),
                    mArmour.getDescription(),
                    mProtectedParts
            );
            Pujima.wearAnArmour(differentArmour);
        } catch (IllegalStateException e) {
            assertEquals("The armour could not be wore, there is already an armour on this body " +
                    "part " + mProtectedParts.keySet().iterator().next().toString(), e.getMessage());
        }
    }

    @Test
    public void takeOffTest() {
        // take off an armour
        Pujima.wearAnArmour(mArmour);
        Pujima.takeOffArmour(mArmour);

        // take off from a body part
        Pujima.wearAnArmour(mArmour);
        Pujima.takeOffArmour(CharacterWarhammer.BodyPart.LEFT_ARM);

        // take off a null armour should throw an exception
        try {
            Pujima.takeOffArmour((Armour) null);
            fail("take off a null armour should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The armour must not be null", e.getMessage());
        }

        // take off from a null body part should throw an exception
        try {
            Pujima.takeOffArmour((CharacterWarhammer.BodyPart) null);
            fail("take off a null armour should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The body part must not be null", e.getMessage());
        }

        // take off an armor that is not actually wore should throw an exception
        try {
            Pujima.takeOffArmour(mArmour);
            fail("take off an armor that is not actually wore should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("The armour given must be actually wore", e.getMessage());
        }

        // take off with a non protected parts should throw an exception
        try {
            Pujima.takeOffArmour(CharacterWarhammer.BodyPart.LEFT_ARM);
        } catch (IllegalStateException e) {
            assertEquals("The body part must be protected", e.getMessage());
        }
    }

    // endregion====================================================================================
}


