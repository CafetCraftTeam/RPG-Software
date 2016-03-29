package cafetcraftteam.rpgsoftware.character.action;

import cafetcraftteam.rpgsoftware.Dice;
import cafetcraftteam.rpgsoftware.Profile;
import cafetcraftteam.rpgsoftware.character.posture.Posture;

/**
 * Created by Pujima on 30/03/2016.
 */
public class Evade implements Action{
    public int doAction(Profile profile, Posture posture){
        int stat = 0;
        int result = 0;
        Dice dice = new Dice(100);
        //get the statistic
        stat = profile.getAgility();
        stat = stat + posture.bonus(this);
        //throw the dice and get result
        result = stat - dice.diceGenerator();
        //remove old posture and add posture

        return result;
    }
}
