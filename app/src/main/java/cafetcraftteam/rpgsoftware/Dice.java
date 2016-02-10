package cafetcraftteam.rpgsoftware;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by defig on 10.02.2016.
 */
public class Dice {
    public int diceGenerator(){
        Random number = new Random();
        return number.nextInt(5)+1;
    }
}
