package cafetcraftteam.rpgsoftware.character.action;

import cafetcraftteam.rpgsoftware.Dice;
import cafetcraftteam.rpgsoftware.character.CharacterWarhammer;

/**
 * Created by Pujima on 29/03/2016.
 */
public class AllOutAttack extends Attack{

    public int doAction(CharacterWarhammer Char){
        int stat = 0;
        int result = 0;
        Dice dice = new Dice(100);
        //get the statistic
        stat = Char.getProfile().getWeaponSkill();
        stat = stat + Char.getPosture().bonus(this) + 20;
        //throw the dice and get result
        result = stat - dice.diceGenerator();
        //remove old posture and add posture

        return result;
    }
}

