package cafetcraftteam.rpgsoftware.character;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cafetcraftteam.rpgsoftware.Characteristic;
import cafetcraftteam.rpgsoftware.equipment.Armour;
import cafetcraftteam.rpgsoftware.equipment.Equipment;

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
    private Characteristic mCharacteristic;

    private int mActualFortune;
    private int mActualWounds;

    /**
     * Equipment
     */
    private Hands mActualWeapons; // the weapons actually in the hand of the character
    private List<Armour> mActualArmour; // the armor(s) actually wore by the character
    // all the equipment of the character that is not actually used
    private Map<Equipment, Integer> mInventory;

    /**
     * Abilities and Talents
     */
    private HashMap<String, String> mBasicSkills;
    private HashMap<String, String> mAdvanSkills;

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
        mBasicSkills = new HashMap<>();
        mAdvanSkills = new HashMap<>();

        mBasicSkills.put("Animal Care", "Skill");
        mBasicSkills.put("Charm", "Skill");
        mBasicSkills.put("Command", "Skill");
        mBasicSkills.put("Concealment", "Skill");
        mBasicSkills.put("Consume Alcohol", "Skill");
        mBasicSkills.put("Disguise", "Skill");
        mBasicSkills.put("Drive", "Skill");
        mBasicSkills.put("Evaluate", "Skill");
        mBasicSkills.put("Gamble", "Skill");
        mBasicSkills.put("Gossip", "Skill");
        mBasicSkills.put("Haggle", "Skill");
        mBasicSkills.put("Intimidate", "Skill");
        mBasicSkills.put("Outdoor Survival", "Skill");
        mBasicSkills.put("Perception", "Skill");
        mBasicSkills.put("Ride", "Skill");
        mBasicSkills.put("Row", "Skill");
        mBasicSkills.put("Scale Sheer Surface", "Skill");
        mBasicSkills.put("Search", "Skill");
        mBasicSkills.put("Silent Move", "Skill");
        mBasicSkills.put("Swim", "Skill");
    }


    // region GETTER================================================================================

    // region Personal information------------------------------------------------------------------

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
    // endregion------------------------------------------------------------------------------------

    // region Main Profile--------------------------------------------------------------------------

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

    // endregion------------------------------------------------------------------------------------

    // region Equipment-----------------------------------------------------------------------------

    /**
     * Getter of the inventory, the part of the equipment of the player that is not actually in use
     *
     * @return the inventory of the character
     */
    public Map<Equipment, Integer> getInventory() {
        return mInventory;
    }

    // endregion------------------------------------------------------------------------------------

    //endregion=====================================================================================

    //region SETTER=================================================================================

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

    public int getPrimaryProfile(Characteristic.Primary primaryCharacteristic) {
        return mCharacteristic.getPrimaryCharacteristic(primaryCharacteristic);
    }

    public int getSecondaryProfile(Characteristic.Secondary secondaryCharacteristic) {
        return mCharacteristic.getSecondaryCharacteristic(secondaryCharacteristic);
    }

    public void setActualFortune(int ActualFortune) {
        mActualFortune = ActualFortune;
    }

    public void setActualWounds(int ActualWounds) {
        mActualWounds = ActualWounds;
    }

            /*
    Under Constructions waiting for Equipment class
     */

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
                    throw new IllegalArgumentException("The armour could not be wore, there is " +
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

    public int getDefensePoints(BodyPart bodyPart) {
        int defensePoints = 0;

        for (Armour armour : mActualArmour) {
            defensePoints += armour.getArmourPoint(bodyPart);
        }

        return defensePoints;
    }

    public void setBasicSkill(String Skillname, String Skill) throws IllegalAccessException {
        switch (Skillname) {
            case "Animal Care":
                mBasicSkills.put("Animal Care", Skill);
                break;
            case "Charm":
                mBasicSkills.put("Charm", Skill);
                break;
            case "Command":
                mBasicSkills.put("Command", Skill);
                break;
            case "Concealment":
                mBasicSkills.put("Concealment", Skill);
                break;
            case "Consume Alcohol":
                mBasicSkills.put("Consume Alcohol", Skill);
                break;
            case "Disguise":
                mBasicSkills.put("Disguise", Skill);
                break;
            case "Drive":
                mBasicSkills.put("Drive", Skill);
                break;
            case "Evaluate":
                mBasicSkills.put("Evaluate", Skill);
                break;
            case "Gamble":
                mBasicSkills.put("Gamble", Skill);
                break;
            case "Gossip":
                mBasicSkills.put("Gossip", Skill);
                break;
            case "Haggle":
                mBasicSkills.put("Haggle", Skill);
                break;
            case "Intimidate":
                mBasicSkills.put("Intimidate", Skill);
                break;
            case "Outdoor Survival":
                mBasicSkills.put("Outdoor Survival", Skill);
                break;
            case "Perception":
                mBasicSkills.put("Perception", Skill);
                break;
            case "Ride":
                mBasicSkills.put("Ride", Skill);
                break;
            case "Row":
                mBasicSkills.put("Row", Skill);
                break;
            case "Scale Sheer Surface":
                mBasicSkills.put("Scale Sheer Surface", Skill);
                break;
            case "Search":
                mBasicSkills.put("Search", Skill);
                break;
            case "Silent Move":
                mBasicSkills.put("Silent Move", Skill);
                break;
            case "Swim":
                mBasicSkills.put("Swim", Skill);
                break;
            default:
                throw new IllegalArgumentException("No Skill is called like " + Skillname);
        }
    }

    public void setAdvanSkills(String Skillname, String Skill) {
        this.mAdvanSkills.put(Skillname, Skill);
    }
    //endregion=====================================================================================

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
