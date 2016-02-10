package cafetcraftteam.rpgsoftware;

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
    private Map mWeapons;
    private Map mArmor;
    private Map mDefensePoints;
    private Map mEquipment;

            /*
    Abilities and Talents
     */

    private Map mBasicAbilities;
    private Map mAdvanAbilities;

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
    }



}
