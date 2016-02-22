package cafetcraftteam.rpgsoftware;

/**
 * Created by defig on 11.02.2016.
 */
public class Skill {

    private String mName;
    //Verifier le type enum créé par Christoph dans CharacterWarhammer
    private Characteristic.Primary mChar;
    private int mLevel;
    private int mBonus;

    /*
    //Attendre révision de la classe characteristic
    public int computeSkillValue(){
        int temp = 10;
        //Verifier la formule de calcul :
        return CharacterWarhammer.getPrimaryProfile(mChar)*(1+0.1*mLevel) + mBonus;
    }
    */
    public String getName() {
        return mName;
    }
    //Verifier le type de retour
    public Characteristic.Primary getChar() {
        return mChar;
    }

    public int getLevel() {
        return mLevel;
    }

    public int getBonus() {
        return mBonus;
    }

    public void setLevel(int Level) {
        mLevel = Level;
    }

    public void setBonus(int Bonus) {
        mBonus = Bonus;
    }

    //Changer le type de Char par le enum créé dans Charactere Warhamer
    public Skill(String Name, Characteristic.Primary Charact, int Level, int Bonus) throws Exception {
        //Verifier la longueur max d'un nom
        if(Name.length() > 12 || Name.length() < 1) {
            throw new Exception("Le nom est trop long ou trop court");
        }
        else if(Level > 2 || Level < 0) {
            throw new Exception("Le niveau de compétence est trop faible ou trop fort");
        }
        //Verifier la valeur max du bonus
        else if(Bonus > 5 || Level < 0) {
            throw new Exception("Le niveau de bonus est trop faible ou trop fort");
        }

        mName = Name;
        mChar = Charact;
        mLevel = Level;
        mBonus = Bonus;
    }
}
