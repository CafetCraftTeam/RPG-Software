package cafetcraftteam.rpgsoftware.character;

import java.util.HashMap;

import cafetcraftteam.rpgsoftware.Characteristic;

/**
 * Class that contains all the information of a Warhammer character
 */
public class CharacterWarhammer extends cafetcraftteam.rpgsoftware.character.Character
{
    /**
     * The body part of in Warhammer
     */
    public enum BodyPart
    {
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
    private final String mDistinguishingMark;
    private String mProfession;


        /*
    Main Profile
     */

    private Characteristic mCharacteristic;

    private int mMovement;
    private int mTotalFortune;
    private int mActualFortune;
    private int mTotalWounds;
    private int mActualWounds;

    /*
Equipment
*/
    private HashMap<Integer, String> mWeapons;
    private HashMap<Integer, String> mArmor;
    private HashMap<BodyPart, Integer> mDefensePoints;
    private HashMap<Integer, String> mEquipment;

            /*
    Abilities and Talents
     */

    private HashMap<String, String> mBasicSkills;
    private HashMap<String, String> mAdvanSkills;

    public CharacterWarhammer(String name, String year, Race race,
                       int age, Sex sex, String eyeColour, int height, String hairColour,
                       int weight, String starSign, int numberOfSiblings, String birthPlace,
                       String distinguishSign)
    {
        super(name, year, race, sex, weight, height, age);
        mEyeColour = eyeColour;
        mHairColour = hairColour;
        mStarSign = starSign;
        mNumberOfSiblings = numberOfSiblings;
        mBirthPlace = birthPlace;
        mDistinguishingMark = distinguishSign;
        mWeapons = new HashMap<>();
        mArmor = new HashMap<>();
        mDefensePoints = new HashMap<>();
        mEquipment = new HashMap<>();
        mBasicSkills = new HashMap<>();
        mAdvanSkills = new HashMap<>();

        mDefensePoints.put(BodyPart.HEAD, 0);
        mDefensePoints.put(BodyPart.TORSO, 0);
        mDefensePoints.put(BodyPart.LEFT_ARM, 0);
        mDefensePoints.put(BodyPart.RIGHT_ARM, 0);
        mDefensePoints.put(BodyPart.LEFT_LEG, 0);
        mDefensePoints.put(BodyPart.RIGHT_LEG, 0);
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

    /*
    ================================================================================================
    --------Getter----------------------------------------------------------------------------------
    ================================================================================================
     */

    public String getEyeColour()
    {
        return mEyeColour;
    }

    public String getHairColour()
    {
        return mHairColour;
    }

    public String getStarSign()
    {
        return mStarSign;
    }

    public int getNumberOfSiblings()
    {
        return mNumberOfSiblings;
    }

    public String getBirthPlace()
    {
        return mBirthPlace;
    }

    public String getDistinguishingMark()
    {
        return mDistinguishingMark;
    }

    public String getProfession()
    {
        return mProfession;
    }

    /*
    ================================================================================================
    --------Setter----------------------------------------------------------------------------------
    ================================================================================================
     */

    public void setProfession(String Profession)
    {
        this.mProfession = Profession;
    }

    public int getPrimaryProfile(Characteristic.Primary primaryCharacteristic)
    {
        return mCharacteristic.getPrimaryCharacteristic(primaryCharacteristic);
    }

    /*public void setPrimaryProfile(PrimCharacteristic c, int Value)
    {
        this.mPrimaryProfile.put(c, Value);
    }*/

    public int getSecondaryProfile(Characteristic.Secondary secondaryCharacteristic)
    {
        return mCharacteristic.getSecondaryCharacteristic(secondaryCharacteristic);
    }

    /*public void setSecondaryProfile(SecondCharacteristic c, int Value)
    {
        this.mSecondaryProfile.put(c, Value);
    }*/

    public int getMovement()
    {
        return mMovement;
    }

    public void setMovement(int Movement)
    {
        this.mMovement = Movement;
    }

    public int getTotalFortune()
    {
        return mTotalFortune;
    }

    public void setTotalFortune(int TotalFortune)
    {
        this.mTotalFortune = TotalFortune;
    }

    public int getActualFortune()
    {
        return mActualFortune;
    }

    public void setActualFortune(int ActualFortune)
    {
        this.mActualFortune = ActualFortune;
    }

    public int getTotalWounds()
    {
        return mTotalWounds;
    }

    public void setTotalWounds(int TotalWounds)
    {
        this.mTotalWounds = TotalWounds;
    }

    public int getActualWounds()
    {
        return mActualWounds;
    }

    public void setActualWounds(int ActualWounds)
    {
        this.mActualWounds = ActualWounds;
    }

            /*
    Under Constructions waiting for Equipment class
     */

    public void addEquipment(int id, String Equipment)
    {
        this.mEquipment.put(id, Equipment);
    }

    public void addWeapons(int id, String Weapon)
    {
        this.mWeapons.put(id, Weapon);
    }

    public void addArmor(int id, String Armor)
    {
        this.mArmor.put(id, Armor);
    }

    public int getDefensePoints(BodyPart bodyPart)
    {
        return mDefensePoints.get(bodyPart);
    }

    public void setDefensePoints(BodyPart bodyPart, int Value)
    {
        this.mDefensePoints.put(bodyPart, Value);
    }

    public void setBasicSkill(String Skillname, String Skill) throws IllegalAccessException
    {
        switch (Skillname)
        {
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

    public void setAdvanSkills(String Skillname, String Skill)
    {
        this.mAdvanSkills.put(Skillname, Skill);
    }

    public static CharacterWarhammer ancestorGurdill() {
        return new CharacterWarhammer(
                "Ancêtre Gurdill",
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
