package cafetcraftteam.rpgsoftware.character.action;

import cafetcraftteam.rpgsoftware.Dice;
import cafetcraftteam.rpgsoftware.character.CharacterWarhammer;
import cafetcraftteam.rpgsoftware.character.posture.Cautious;

/**
 * Created by Pujima on 29/03/2016.
 */
public class CautiousAttack extends Attack{

    public int doAction(CharacterWarhammer Char){
        int stat = 0;
        int result = 0;
        Dice dice = new Dice(100);
        //get the statistic
        stat = Char.getProfile().getWeaponSkill();
        stat = stat + Char.getPosture().bonus(this) - 10;
        //throw the dice and get result
        result = stat - dice.diceGenerator();
        //remove old posture and add posture
        Char.setPosture(new Cautious());

        return result;
    }
}

