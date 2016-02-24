package cafetcraftteam.rpgsoftware.character;

import android.support.annotation.NonNull;

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
    private Hand mActualWeapons; // the weapons actually in the hand of the character
    private List<Armour> mActualArmor; // the armor(s) actually wore by the character
    private Map<Equipment, Integer> mEquipment; // all the equipment of the player

    /**
     * Abilities and Talents
     */
    private HashMap<String, String> mBasicSkills;
    private HashMap<String, String> mAdvanSkills;

    public CharacterWarhammer(
            String name,
            String year,
            Race race,
            int age,
            Sex sex,
            String eyeColour,
            int height,
            String hairColour,
            int weight,
            String starSign,
            int numberOfSiblings,
            String birthPlace,
            String distinguishingMarks
    ) {
        super(name, year, race, sex, weight, height, age);
        mEyeColour = eyeColour;
        mHairColour = hairColour;
        mStarSign = starSign;
        mNumberOfSiblings = numberOfSiblings;
        mBirthPlace = birthPlace;
        mDistinguishingMarks = distinguishingMarks;
        mActualWeapons = new Hand(null, null);
        mActualArmor = new ArrayList<>();
        mEquipment = new HashMap<>();
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
    public String getEyeColour() {
        return mEyeColour;
    }

    public String getHairColour() {
        return mHairColour;
    }

    public String getStarSign() {
        return mStarSign;
    }

    public int getNumberOfSiblings() {
        return mNumberOfSiblings;
    }

    public String getBirthPlace() {
        return mBirthPlace;
    }

    public String getDistinguishingMark() {
        return mDistinguishingMarks;
    }

    public String getProfession() {
        return mProfession;
    }
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

    public void handleEquipment(@NonNull Equipment equipment, @NonNull Hand.Handle handle) {
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
                throw new EnumConstantNotPresentException(Hand.Handle.class, "The hand asked is not present");
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
        return new CharacterWarhammer(
                "Ancestor Gurdill",
                "1900",
                Race.DWARF,
                80,
                Sex.MALE,
                "Blue",
                150,
                "Green",
                100,
                "GAstre",
                2,
                "Karak-a-karak",
                "Nain");
    }
}
