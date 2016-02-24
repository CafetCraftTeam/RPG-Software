package cafetcraftteam.rpgsoftware;

import java.util.Random;

/**
 * Created by defig on 10.02.2016.
 */
public class Dice {
    private int mInf;
    private int mMax;

    public int diceGenerator() {
        Random number = new Random();
        return number.nextInt(mMax - mInf + 1) + mInf;
    }

    public int getInf() {
        return mInf;
    }

    public int getMax() {
        return mMax;
    }

    public Dice(int inf, int max) {
        //Contract of the constructor
        if (inf < 1 || max < 1) {
            throw new IllegalArgumentException("The size of dice is not correct");
        }
        if (inf > max) {
            int temp = inf;
            inf = max;
            max = temp;
        }
        mInf = inf;
        mMax = max;
    }

    public Dice(int max) {
        //Contract of the constructor
        if (max < 1) {
            throw new IllegalArgumentException("The maximum of dice is too low");
        }
        mInf = 1;
        mMax = max;
    }
}
