package cafetcraftteam.rpgsoftware;

import java.util.HashMap;

/**
 * Created by Pujima on 10/02/2016.
 */
public class CharacterWarhammer extends Character {

    /*
    Personal Details
     */
    private final int mAge ;
    private final String mSex;
    private final String mEyecolor;
    private final int mHeight ;
    private final String mHaircolor;
    private final int mWeight ;
    private final String mSA ;
    private final int mNbBrSis ;
    private final String mBirthPlace;
    private final String mDistinctifSign;


        /*
    Main Profile
     */
    
    private String mProfession;
    private HashMap<Characteristic,Integer> mPrimaryProfile;
    private HashMap<Characteristic,Integer> mSecondaryProfile;

    private int mMovement;
    private int mTotalFortune;
    private int mActualFortune;
    private int mTotalWounds;
    private int mActualWounds;

            /*
    Equipment
     */
    private HashMap<Integer,String> mWeapons;
    private HashMap<Integer,String> mArmor;
    private HashMap<Bodypart,Integer> mDefensePoints;
    private HashMap<Integer,String> mEquipment;

            /*
    Abilities and Talents
     */

    private HashMap<String,String> mBasicSkills;
    private HashMap<String,String> mAdvanSkills;

    CharacterWarhammer(String Name, String RealName, String Campaign, String Year, String Race,
                       int Age, String Sex, String Eyecolor, int Height, String Haircolor,
                       int Weight, String SA, int NbBrSis, String BirthPlace, String DistinctifSign)
    {
        super(Name, RealName, Campaign, Year, Race);
        mAge = Age;
        mSex = Sex;
        mEyecolor = Eyecolor;
        mHeight = Height;
        mHaircolor = Haircolor;
        mWeight = Weight;
        mSA = SA;
        mNbBrSis = NbBrSis;
        mBirthPlace = BirthPlace;
        mDistinctifSign = DistinctifSign;
        mDefensePoints.put(Bodypart.HEAD, 0);
        mDefensePoints.put(Bodypart.TORSO, 0);
        mDefensePoints.put(Bodypart.LEFTARM, 0);
        mDefensePoints.put(Bodypart.RIGHTARM, 0);
        mDefensePoints.put(Bodypart.LEFTLEG, 0);
        mDefensePoints.put(Bodypart.RIGHTLEG, 0);
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

    public String getProfession() {
        return mProfession;
    }

    public void setmProfession(String Profession) {
        this.mProfession = Profession;
    }

    public Integer getPrimaryProfile(Characteristic c) {
        return mPrimaryProfile.get(c);
    }

    public void setPrimaryProfile(Characteristic c, int Value) {
        this.mPrimaryProfile.put(c, Value);
    }

    public Integer getSecondaryProfile(Characteristic c) {
        return mSecondaryProfile.get(c);
    }

    public void setSecondaryProfile(Characteristic c, int Value) {
        this.mSecondaryProfile.put(c, Value);
    }

    public int getMovement() {
        return mMovement;
    }

    public void setmMovement(int Movement) {
        this.mMovement = Movement;
    }

    public int getTotalFortune() {
        return mTotalFortune;
    }

    public void setmTotalFortune(int TotalFortune) {
        this.mTotalFortune = TotalFortune;
    }

    public int getActualFortune() {
        return mActualFortune;
    }

    public void setmActualFortune(int ActualFortune) {
        this.mActualFortune = ActualFortune;
    }

    public int getTotalWounds() {
        return mTotalWounds;
    }

    public void setmTotalWounds(int TotalWounds) {
        this.mTotalWounds = TotalWounds;
    }

    public int getActualWounds() {
        return mActualWounds;
    }

    public void setmActualWounds(int ActualWounds) {
        this.mActualWounds = ActualWounds;
    }

            /*
    Under Constructions waiting for Equipment class
     */

    public void addEquipment(int id, String Equipment) {
        this.mEquipment.put(id, Equipment);
    }

    public void addWeapons(int id, String Weapon) {
        this.mWeapons.put(id, Weapon);
    }

    public void addArmor(int id, String Armor) {
        this.mArmor.put(id, Armor);
    }

    public int getDefensePoints(Bodypart bodypart){
        return mDefensePoints.get(bodypart);
    }

    public void setDefensePoints(Bodypart bodypart, int Value){
        this.mDefensePoints.put(bodypart, Value);
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
}
