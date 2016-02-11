package cafetcraftteam.rpgsoftware;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;

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
    private Map mPrimaryProfile;
    private Map mSecondaryProfile;

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
    private HashMap<String,Integer> mDefensePoints;
    private HashMap<Integer,String> mEquipment;

            /*
    Abilities and Talents
     */

    private HashMap<String,String> mBasicSkills;
    private HashMap<String,String> mAdvanSkills;

    CharacterWarhammer(String Name, String RealName, String Campaign, String Year, String Race, int Age, String Sex, String Eyecolor, int Height, String Haircolor, int Weight, String SA, int NbBrSis, String BirthPlace, String DistinctifSign){
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

        mDefensePoints.put("head", 0);
        mDefensePoints.put("torso", 0);
        mDefensePoints.put("leftarm", 0);
        mDefensePoints.put("rightarm", 0);
        mDefensePoints.put("leftleg", 0);
        mDefensePoints.put("rightleg", 0);
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

    public String getmProfession() {
        return mProfession;
    }

    public void setmProfession(String mProfession) {
        this.mProfession = mProfession;
    }

    public Map getmPrimaryProfile() {
        return mPrimaryProfile;
    }

    public void setmPrimaryProfile(Map mPrimaryProfile) {
        this.mPrimaryProfile = mPrimaryProfile;
    }

    public Map getmSecondaryProfile() {
        return mSecondaryProfile;
    }

    public void setmSecondaryProfile(Map mSecondaryProfile) {
        this.mSecondaryProfile = mSecondaryProfile;
    }

    public int getmMovement() {
        return mMovement;
    }

    public void setmMovement(int mMovement) {
        this.mMovement = mMovement;
    }

    public int getmTotalFortune() {
        return mTotalFortune;
    }

    public void setmTotalFortune(int mTotalFortune) {
        this.mTotalFortune = mTotalFortune;
    }

    public int getmActualFortune() {
        return mActualFortune;
    }

    public void setmActualFortune(int mActualFortune) {
        this.mActualFortune = mActualFortune;
    }

    public int getmTotalWounds() {
        return mTotalWounds;
    }

    public void setmTotalWounds(int mTotalWounds) {
        this.mTotalWounds = mTotalWounds;
    }

    public int getmActualWounds() {
        return mActualWounds;
    }

    public void setmActualWounds(int mActualWounds) {
        this.mActualWounds = mActualWounds;
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

    public int getDefensePoints(String bodypart) throws IllegalAccessException{
        switch (bodypart) {
            case "head":
                return mDefensePoints.get(bodypart);
            case "torso":
                return mDefensePoints.get(bodypart);
            case "leftarm":
                return mDefensePoints.get(bodypart);
            case "rightarm":
                return mDefensePoints.get(bodypart);
            case "leftleg":
                return mDefensePoints.get(bodypart);
            case "rightleg":
                return mDefensePoints.get(bodypart);
            default:
                throw new IllegalArgumentException("No body part is called like " + bodypart);
        }
    }

    public void setDefensePoints(String bodypart, int Value) throws IllegalAccessException{
        switch (bodypart) {
            case "head":
                this.mDefensePoints.put("head", Value);
                break;
            case "torso":
                this.mDefensePoints.put("torso", Value);
                break;
            case "leftarm":
                this.mDefensePoints.put("leftarm", Value);
                break;
            case "rightarm":
                this.mDefensePoints.put("rightarm", Value);
                break;
            case "leftleg":
                this.mDefensePoints.put("leftleg", Value);
                break;
            case "rightleg":
                this.mDefensePoints.put("rightleg", Value);
                break;
            default:
                throw new IllegalArgumentException("No body part is called like " + bodypart);
        }
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
