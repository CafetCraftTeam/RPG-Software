package cafetcraftteam.rpgsoftware;

import java.util.Random;

/**
 * Created by defig on 10.02.2016.
 */
public class Dice {
    private int mInf;
    private int mMax;

    public int diceGenerator(){
        Random number = new Random();
        return number.nextInt(mMax-mInf)+mInf;
    }

    public int getInf(){
        return mInf;
    }

    public int getMax(){
        return mMax;
    }

    public Dice(int Inf,int Max){
        mInf = Inf;
        mMax = Max;
    }
}
