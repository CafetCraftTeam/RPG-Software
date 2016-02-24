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
    private List<Armour> mActualArmor; // the armor(s) actually wore by the character
    private Map<Equipment, Integer> mEquipment; // all the equipment of the player

    /**
     * Abilities and Talents
     */
    private HashMap<String, String> mBasicSkills;
    private HashMap<String, String> mAdvanSkills;

    /**
     * Constructor of a Warhammer character
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
            @Nullable String distinguishingMarks
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

        // endregion--------------------------------------------------------------------------------

        // initialization of the personal information
        mEyeColour = eyeColour;
        mHairColour = hairColour;
        mStarSign = starSign;
        mNumberOfSiblings = numberOfSiblings;
        mBirthPlace = birthPlace;
        mDistinguishingMarks = distinguishingMarks;

        // initialization of the equipment
        mActualWeapons = new Hands(null, null);
        mActualArmor = new ArrayList<>();
        mEquipment = new HashMap<>();

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

    //endregion=====================================================================================

    //region SETTER=================================================================================
    public void setProfession(String Profession) {
        this.mProfession = Profession;
    }

    public int getPrimaryProfile(Characteristic.Primary primaryCharacteristic) {
        return mCharacteristic.getPrimaryCharacteristic(primaryCharacteristic);
    }

    /*public void setPrimaryProfile(PrimCharacteristic c, int Value)
    {
        this.mPrimaryProfile.put(c, Value);
    }*/

    public int getSecondaryProfile(Characteristic.Secondary secondaryCharacteristic) {
        return mCharacteristic.getSecondaryCharacteristic(secondaryCharacteristic);
    }

    /*public void setSecondaryProfile(SecondCharacteristic c, int Value)
    {
        this.mSecondaryProfile.put(c, Value);
    }*/

    public int getActualFortune() {
        return mActualFortune;
    }

    public void setActualFortune(int ActualFortune) {
        mActualFortune = ActualFortune;
    }

    public int getActualWounds() {
        return mActualWounds;
    }

    public void setActualWounds(int ActualWounds) {
        mActualWounds = ActualWounds;
    }

            /*
    Under Constructions waiting for Equipment class
     */

    public void addEquipment(@NonNull Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("The equipment must be not null");
        }

        if (mEquipment.containsKey(equipment)) {
            mEquipment.put(equipment, mEquipment.get(equipment) + 1);
        } else {
            mEquipment.put(equipment, 1);
        }
    }

    public void handleEquipment(@NonNull Equipment equipment, @NonNull Hands.Handle handle) {
        if (equipment == null) {
            throw new IllegalArgumentException("The equipment must be not null");
        }
        if (handle == null) {
            throw new IllegalArgumentException("The handle must be not null");
        }
        if (!mEquipment.containsKey(equipment)) {
            mEquipment.put(equipment, 1);
        }

        switch (handle) {
            case LEFT:
                mActualWeapons.useLeft(equipment);
                break;
            case RIGHT:
                mActualWeapons.useRight(equipment);
                break;
            case BOTH:
                mActualWeapons.useBoth(equipment);
                break;
            default:
                throw new EnumConstantNotPresentException(Hands.Handle.class, "The hand asked is not present");
        }
    }

    public void wearAnArmour(@NonNull Armour armour) {
        if (armour == null) {
            throw new IllegalArgumentException("The armour must be not null");
        }
        if (!mEquipment.containsKey(armour)) {
            mEquipment.put(armour, 1);
        }

        // verify that there is no other armour on the body part covered by this one
        for (Armour woreArmour : mActualArmor) {
            for (BodyPart bodyPart : BodyPart.values()) {
                if (woreArmour.isProtected(bodyPart) && armour.isProtected(bodyPart)) {
                    throw new IllegalArgumentException("The armour could not be wore, there is " +
                            "already an armour on this body part " + bodyPart.toString());
                }
            }
        }

        // everything is OK
        mActualArmor.add(armour);
    }

    public int getDefensePoints(BodyPart bodyPart) {
        int defensePoints = 0;

        for (Armour armour : mActualArmor) {
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
                    "GAstre",
                    2,
                    "Karak-a-karak",
                    "Nain");
        } catch (InstantiationException instantiationError) {
            throw new InstantiationError("There is a problem in the constructor of CharacterWarhammer");
        }
        return characterWarhammer;
    }
}
