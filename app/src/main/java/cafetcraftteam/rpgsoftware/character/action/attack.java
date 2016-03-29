package cafetcraftteam.rpgsoftware.character.action;

import cafetcraftteam.rpgsoftware.Dice;
import cafetcraftteam.rpgsoftware.Profile;
import cafetcraftteam.rpgsoftware.character.*;

/**
 * Created by Pujima on 29/03/2016.
 */
public class Attack implements Action{

    public int doAction(cafetcraftteam.rpgsoftware.character.CharacterWarhammer Char){
        int stat = 0;
        int result = 0;
        Dice dice = new Dice(100);
        //get the statistic
        stat = Char.getPosture().getModifiedProfile(Char).getWeaponSkill();
        //throw the dice and get result
        result = stat - dice.diceGenerator();
        //remove old posture and add posture

        return result;
    }
}
