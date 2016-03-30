package cafetcraftteam.rpgsoftware.character.posture;

import cafetcraftteam.rpgsoftware.character.action.Action;
import cafetcraftteam.rpgsoftware.character.action.Attack;

/**
 * Created by Pujima on 30/03/2016.
 */
public class None implements Posture{
    public int bonus(Action action){
            return 0;
    }
}
