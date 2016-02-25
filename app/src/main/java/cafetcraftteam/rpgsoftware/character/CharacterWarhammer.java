package cafetcraftteam.rpgsoftware.character;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cafetcraftteam.rpgsoftware.Profile;
import cafetcraftteam.rpgsoftware.equipment.Armour;
import cafetcraftteam.rpgsoftware.equipment.Equipment;
import cafetcraftteam.rpgsoftware.skill.AdvancedSkill;
import cafetcraftteam.rpgsoftware.skill.BasicSkill;
import cafetcraftteam.rpgsoftware.skill.BasicSkill.BasicSkillName;
import cafetcraftteam.rpgsoftware.skill.Skill;

/**
 * Class that contains all the information of a Warhammer character
 */
public class CharacterWarhammer extends cafetcraftteam.rpgsoftware.character.Character {
    /**
     * The body part of a character in Warhammer
     */
    public enum BodyPart {
        HEAD,
        TORSO,
        LEFT_ARM,
        RIGHT_ARM,
        LEFT_LEG,
        RIGHT_LEG
    }

    /**
     * The personal information of the character
     */
    private final String mEyeColour;
    private final String mHairColour;
    private final String mStarSign;
    private final int mNumberOfSiblings;
    private final String mBirthPlace;
    private final String mDistinguishingMarks;
    private String mProfession;


    /**
     * Main profile
     */
    private Profile mProfile;

    private int mActualFortune;
    private int mActualWounds;

    /**
     * Equipment
     */
    private final Hands mActualWeapons; // the weapons actually in the hand of the character
    private final List<Armour> mActualArmour; // the armor(s) actually wore by the character
    // all the equipment of the character that is not actually used
    private final Map<Equipment, Integer> mInventory;

    /**
     * Abilities and Talents
     */
    private final List<BasicSkill> mBasicSkills;
    private final Map<String, AdvancedSkill> mAdvancedSkills;

    /**
     * Constructor of a Warhammer character, the character have nothing in his hand, inventory and
     * wear nothing
     *
     * @param name                the name of the character, must be not null and non empty
     * @param race                the race of the character, must be not null
     * @param sex                 the sex of the character, must be not null
     * @param weight              the weight of the character in kilogram, must be positive
     * @param height              the height of the character in meter, must be positive
     * @param age                 the age of the character in years, must be positive
     * @param eyeColour           the eye colour of the character as a string,
     *                            could be null or empty, if null replace by an empty string
     * @param hairColour          the hair colour of the character as a string,
     *                            could be null or empty, if null replace by an empty string
     * @param starSign            the star sign of the character as a string,
     *                            could be null or empty, if null replace by an empty string
     * @param numberOfSiblings    the number of siblings of the character, must be positive
     * @param birthPlace          the birthplace of the character as a string,
     *                            could be null or empty, if null replace by an empty string
     * @param distinguishingMarks the distinguishing marks of the character as a string,
     *                            could be null or empty, if null replace by an empty string
     * @param profession          the profession of the character, could null or empty, if null
     *                            replace by an empty string
     * @throws InstantiationException
     */
    public CharacterWarhammer(
            @NonNull String name,
            @NonNull Race race,
            @NonNull Sex sex,
            int weight,
            int height,
            int age,
            @Nullable String eyeColour,
            @Nullable String hairColour,
            @Nullable String starSign,
            int numberOfSiblings,
            @Nullable String birthPlace,
            @Nullable String distinguishingMarks,
            @Nullable String profession
    ) throws InstantiationException {
        super(name, race, sex, weight, height, age);

        // region CONTRACT--------------------------------------------------------------------------

        if (eyeColour == null) {
            eyeColour = "";
        }
        if (hairColour == null) {
            hairColour = "";
        }
        if (starSign == null) {
            starSign = "";
        }
        if (numberOfSiblings < 0) {
            throw new InstantiationException("The number of siblings must be positive or zero");
        }
        if (birthPlace == null) {
            birthPlace = "";
        }
        if (distinguishingMarks == null) {
            distinguishingMarks = "";
        }
        if (profession == null) {
            profession = "";
        }

        // endregion--------------------------------------------------------------------------------

        // initialization of the personal information
        mEyeColour = eyeColour;
        mHairColour = hairColour;
        mStarSign = starSign;
        mNumberOfSiblings = numberOfSiblings;
        mBirthPlace = birthPlace;
        mDistinguishingMarks = distinguishingMarks;
        mProfession = profession;

        // initialization of the equipment
        mActualWeapons = new Hands(null, null); // nothing in the hands
        mActualArmour = new ArrayList<>(); // wear nothing
        mInventory = new HashMap<>(); // nothing in the inventory

        // initialization of the skills
        mBasicSkills = new ArrayList<>();
        for (BasicSkillName basicSkillName : BasicSkillName.values()) {
            mBasicSkills.add(new BasicSkill(basicSkillName, Skill.Level.NONE));
        }

        mAdvancedSkills = new TreeMap<>();

        //TODO initialize correctly the profile
        mProfile = Profile.ancestorGurdillProfile();
    }


    // region Personal information==================================================================

    /**
     * Getter of the eyes colour of the character
     *
     * @return the eyes colour as a string, could be empty but not null
     */
    @NonNull
    public String getEyeColour() {
        return mEyeColour;
    }

    /**
     * Getter of the hair colour of the character
     *
     * @return the hair colour as a string, could be empty but not null
     */
    @NonNull
    public String getHairColour() {
        return mHairColour;
    }

    /**
     * Getter of the star sign of the character
     *
     * @return the star sign as a string, could be empty but not null
     */
    @NonNull
    public String getStarSign() {
        return mStarSign;
    }

    /**
     * Getter of the number of siblings of the character
     *
     * @return the number of siblings as a positive integer
     */
    public int getNumberOfSiblings() {
        return mNumberOfSiblings;
    }

    /**
     * Getter of the birthplace of the character
     *
     * @return the birthplace as a string, could be empty but not null
     */
    @NonNull
    public String getBirthplace() {
        return mBirthPlace;
    }

    /**
     * Getter of the distinguishing marks of the character
     *
     * @return the distinguishing marks as a string, could be empty but not null
     */
    @NonNull
    public String getDistinguishingMarks() {
        return mDistinguishingMarks;
    }

    /**
     * Getter of the profession of the character
     *
     * @return the profession as a string, could be empty but not null
     */
    @NonNull
    public String getProfession() {
        return mProfession;
    }

    /**
     * Setter of the profession
     *
     * @param profession the profession, could be null or empty, if null it will be replace by an
     *                   empty string
     */
    public void setProfession(@Nullable String profession) {
        if (profession == null) {
            profession = "";
        }
        mProfession = profession;
    }

    // endregion====================================================================================

    // region Main Profile==========================================================================

    /**
     * The actual number of fortune points of the character
     *
     * @return the actual number of fortune points, always positive
     */
    public int getActualFortunePoints() {
        return mActualFortune;
    }

    /**
     * The actual number of wounds points of the character
     *
     * @return the actual number of wounds points, always positive
     */
    public int getActualWounds() {
        return mActualWounds;
    }

    public void setActualFortune(int ActualFortune) {
        mActualFortune = ActualFortune;
    }

    public void setActualWounds(int ActualWounds) {
        mActualWounds = ActualWounds;
    }

    // endregion====================================================================================

    // region EQUIPMENT=============================================================================

    /**
     * Getter of the inventory, the part of the equipment of the player that is not actually in use
     *
     * @return the inventory of the character
     */
    public Map<Equipment, Integer> getInventory() {
        return mInventory;
    }

    /**
     * Method that allow to add some equipment to the character
     *
     * @param equipment the equipment to add, must be not null
     */
    public void addEquipment(@NonNull Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("The equipment must be not null");
        }

        if (mInventory.containsKey(equipment)) {
            mInventory.put(equipment, mInventory.get(equipment) + 1);
        } else {
            mInventory.put(equipment, 1);
        }
    }

    /**
     * Method that remove one equipment from the inventory. It decrease the quantity of the object
     * by one and remove it definitely if it's the last one
     *
     * @param equipment the equipment to remove, must already be in the inventory, must not be null
     */
    public void removeEquipment(@NonNull Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("The equipment to remove should not be null");
        }
        if (!mInventory.containsKey(equipment)) {
            throw new IllegalArgumentException("The equipment to remove must already be in the" +
                    " inventory");
        }

        mInventory.put(equipment, mInventory.get(equipment) - 1);

        if (mInventory.get(equipment) <= 0) {
            mInventory.remove(equipment);
        }
    }

    /**
     * Take something in your hand(s). They must be empty
     *
     * @param equipment the equipment to take, must not be null
     * @param handle    the hand(s) used to take this object, the hand(s) must be empty or an
     *                  IllegalStateException is thrown
     */
    public void takeItem(@NonNull Equipment equipment, @NonNull Hands.Handle handle) {
        if (equipment == null) {
            throw new IllegalArgumentException("The equipment to take must not be null");
        }
        if (handle == null) {
            throw new IllegalArgumentException("The handle for taking must not be null");
        }

        switch (handle) {
            case LEFT:
                mActualWeapons.unsheatheLeft(equipment);
                break;
            case RIGHT:
                mActualWeapons.unsheatheRight(equipment);
                break;
            case BOTH:
                mActualWeapons.unsheatheBoth(equipment);
                break;
            default:
                throw new EnumConstantNotPresentException(Hands.Handle.class, "The handle ask is " +
                        "not present");
        }
    }

    /**
     * Drop an equipment from the handle given. The hand(s) must be not empty or an
     * IllegalStateException is thrown
     *
     * @param handle the hand(s) of which the equipment will be drop, must be not null
     * @return the equipment previously in the hand(s), always not null
     */
    @NonNull
    public List<Equipment> dropItem(@NonNull Hands.Handle handle) {
        if (handle == null) {
            throw new IllegalArgumentException("The handle must not be null");
        }

        List<Equipment> dropEquipment = new ArrayList<>();
        switch (handle) {
            case LEFT:
                dropEquipment.add(mActualWeapons.sheatheLeft());
                break;
            case RIGHT:
                dropEquipment.add(mActualWeapons.sheatheRight());
                break;
            case BOTH:
                dropEquipment.addAll(mActualWeapons.sheatheBoth());
                break;
            default:
                throw new EnumConstantNotPresentException(Hands.Handle.class, "The handle ask is " +
                        "not present");
        }
        return dropEquipment;
    }

    // endregion====================================================================================

    // region ARMOUR================================================================================

    /**
     * Wear the armour given
     *
     * @param armour the armour to wear, must be not null. If the body part(s) used by this armour
     *               is(are) already occupy by an armour throw an IllegalArgumentException
     */
    public void wearAnArmour(@NonNull Armour armour) {
        if (armour == null) {
            throw new IllegalArgumentException("The armour must be not null");
        }

        // verify that there is no other armour on the body part covered by this one
        for (Armour woreArmour : mActualArmour) {
            for (BodyPart bodyPart : BodyPart.values()) {
                if (woreArmour.isProtected(bodyPart) && armour.isProtected(bodyPart)) {
                    throw new IllegalStateException("The armour could not be wore, there is " +
                            "already an armour on this body part " + bodyPart.toString());
                }
            }
        }

        // everything is OK
        mActualArmour.add(armour);
    }

    /**
     * Take off the armour that protect the body part passed in argument. If it cover multiple body
     * part, it will be remove from all these body part
     *
     * @param bodyPart the body part from which the armor will be removed, if the body part is not
     *                 covered, throw an IllegalStateException, must be not null
     * @return the armour remove, always not null
     */
    @NonNull
    public Armour takeOffArmour(@NonNull BodyPart bodyPart) {
        if (bodyPart == null) {
            throw new IllegalArgumentException("The body part must not be null");
        }
        if (!isProtected(bodyPart)) {
            throw new IllegalStateException("The body part must be protected");
        }

        Armour removedArmour = null;
        for (Armour armour : mActualArmour) {
            if (armour.isProtected(bodyPart)) {
                removedArmour = armour;
                break;
            }
        }

        mActualArmour.remove(removedArmour);
        return removedArmour;
    }

    /**
     * Take off the armour given in argument. If this armour is not actually wore throw an
     * IllegalArgumentException.
     *
     * @param armour the armour that will be take off, must be not null
     * @return the armour take off, always not null
     */
    @NonNull
    public Armour takeOffArmour(@NonNull Armour armour) {
        if (armour == null) {
            throw new IllegalArgumentException("The armour must not be null");
        }
        if (!mActualArmour.contains(armour)) {
            throw new IllegalArgumentException("The armour given must be actually wore");
        }

        mActualArmour.remove(armour);

        return armour;
    }

    /**
     * Is a body part actually covered by an armour
     *
     * @param bodyPart the body part to test, must be not null
     * @return true if there at least one actual wore armour that protect this body part,
     * false otherwise
     */
    public boolean isProtected(@NonNull BodyPart bodyPart) {
        if (bodyPart == null) {
            throw new IllegalArgumentException("The body part should not be null");
        }

        boolean isProtected = false;
        for (Armour armour : mActualArmour) {
            isProtected = isProtected || armour.isProtected(bodyPart);
        }
        return isProtected;
    }

    /**
     * Getter of the number of armour point on the localisation given
     *
     * @param bodyPart the localisation wanted, must be not null
     * @return the number of armour point on this body part
     */
    public int getArmorPoints(@NonNull BodyPart bodyPart) {
        int defensePoints = 0;

        for (Armour armour : mActualArmour) {
            defensePoints += armour.getArmourPoint(bodyPart);
        }

        return defensePoints;
    }

    //endregion=====================================================================================

    // region SKILL=================================================================================

    /**
     * Getter of the value of an advanced skill
     *
     * @param advancedSkillName the name of the skill, must be not null, if not actually there
     *                          throw an IllegalArgumentException
     * @return the value of the Skill, always positive and not zero
     */
    public int getAdvancedSkillValue(@NonNull String advancedSkillName) {
        if (advancedSkillName == null) {
            throw new IllegalArgumentException("The name of the advanced skill must not be null");
        }
        if (!mAdvancedSkills.containsKey(advancedSkillName)) {
            throw new IllegalArgumentException("The Skill given is not actually there");
        }

        return mAdvancedSkills.get(advancedSkillName).getSkillValue(mProfile);
    }

    /**
     * Getter of the value of an basic skill
     *
     * @param basicSkillName the name of the skill, must be not null
     * @return the value of the Skill, always positive and not zero
     */
    public int getBasicSkillValue(@NonNull BasicSkillName basicSkillName) {
        if (basicSkillName == null) {
            throw new IllegalArgumentException("The name of the basic skill must not be null");
        }

        return mBasicSkills.get(basicSkillName.ordinal()).getSkillValue(mProfile);
    }

    /**
     * Method that permit to add an advanced skill to the character
     *
     * @param advancedSkill the advanced skill to add, must be not null, if it's already present
     *                      throw an exception. The skill will be copy to avoid external modification
     */
    public void addAdvancedSkill(@NonNull AdvancedSkill advancedSkill) {
        if (advancedSkill == null) {
            throw new IllegalArgumentException("The advanced Skill given must not be null");
        }

        if (mAdvancedSkills.containsValue(advancedSkill)) {
            throw new IllegalStateException("The advanced skill given is already there");
        }

        AdvancedSkill deepCopy = advancedSkill.deepCopy();
        mAdvancedSkills.put(deepCopy.getName(), deepCopy);
    }

    /**
     * Improve the advanced skill with the same name as the one given
     *
     * @param advancedSkillName the name of the advanced skill to improve, must not be null,
     *                          throw an exception if there is no skill with this name
     */
    public void improveAdvancedSkill(@NonNull String advancedSkillName) {
        if (advancedSkillName == null) {
            throw new IllegalArgumentException("The name of the advanced skill must not be null");
        }
        if (!mAdvancedSkills.containsKey(advancedSkillName)) {
            throw new IllegalArgumentException("The Skill given is not actually there");
        }

        mAdvancedSkills.get(advancedSkillName).improve();
    }

    /**
     * Improve the basic skill with the same name as the one given
     *
     * @param basicSkillName the name of the basic skill to improve, must not be null,
     *                       throw an exception if there is no skill with this name
     */
    public void improveBasicSkill(@NonNull BasicSkillName basicSkillName) {
        if (basicSkillName == null) {
            throw new IllegalArgumentException("The name of the basic skill must not be null");
        }

        mBasicSkills.get(basicSkillName.ordinal()).improve();
    }


    // endregion====================================================================================

    /**
     * Give quickly an CharacterWarhammer
     *
     * @return the ancestor Gurdill (take care of him)
     */
    public static CharacterWarhammer ancestorGurdill() {
        CharacterWarhammer characterWarhammer;
        try {
            characterWarhammer = new CharacterWarhammer(
                    "Ancestor Gurdill",
                    Race.DWARF,
                    Sex.MALE,
                    100,
                    150,
                    80,
                    "Blue",
                    "Green",
                    "The Big Cross",
                    2,
                    "Karak-a-karak",
                    "Dwarf",
                    "Miner");
        } catch (InstantiationException instantiationError) {
            throw new InstantiationError("There is a problem in the constructor of CharacterWarhammer");
        }
        return characterWarhammer;
    }
}
