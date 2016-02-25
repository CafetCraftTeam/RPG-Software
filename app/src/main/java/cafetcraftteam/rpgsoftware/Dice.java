package cafetcraftteam.rpgsoftware;

import java.util.Random;

/**
 * Created by defig on 10.02.2016.
 */
public class Dice
{
    private final int mInf;
    private final int mMax;

    public int diceGenerator()
    {
        Random number = new Random();
        return number.nextInt(mMax - mInf) + mInf;
    }

    public int getInf()
    {
        return mInf;
    }

    public int getMax()
    {
        return mMax;
    }

    public Dice(int inf, int max)
    {
        mInf = inf;
        mMax = max;
    }

    public Dice(int max)
    {
        mInf = 1;
        mMax = max;
    }
}
