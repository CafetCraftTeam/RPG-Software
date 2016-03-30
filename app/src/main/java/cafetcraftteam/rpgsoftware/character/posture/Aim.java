package cafetcraftteam.rpgsoftware.character.posture;

import cafetcraftteam.rpgsoftware.character.action.Action;
import cafetcraftteam.rpgsoftware.character.action.Attack;
import cafetcraftteam.rpgsoftware.character.action.Evade;
import cafetcraftteam.rpgsoftware.character.action.Parry;

/**
 * Created by Pujima on 30/03/2016.
 */
public class Aim implements Posture{
    public int bonus(Action action){
        if (action.getClass().isInstance(Attack.class)){
            return 10;
        }
        else{
            return 0;
        }
    }
}
