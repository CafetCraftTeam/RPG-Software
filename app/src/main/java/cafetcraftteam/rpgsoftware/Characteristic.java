package cafetcraftteam.rpgsoftware;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Gautier on 22/02/2016.
 */
public class Characteristic
{
    public enum Primary
    {
        WS, BS, S, T, AG, INT, WP, FEL
    }

    public enum Secondary
    {
        A, W, SB, TB, M, MAG, IP, FP
    }

    private Map<Primary, Integer> mPrimary;
    private Map<Secondary, Integer> mSecondary;

    public Characteristic(int weaponSkill,
                          int ballisticSkill,
                          int strength,
                          int toughness,
                          int agility,
                          int intelligence,
                          int willPower,
                          int fellowship,
                          int attacks,
                          int wounds,
                          int movement,
                          int magic,
                          int insanityPoints,
                          int fatePoints)
    {
        mPrimary = new EnumMap<>(Primary.class);
        mPrimary.put(Primary.WS, weaponSkill);
        mPrimary.put(Primary.BS, ballisticSkill);
        mPrimary.put(Primary.S, strength);
        mPrimary.put(Primary.T, toughness);
        mPrimary.put(Primary.AG, agility);
        mPrimary.put(Primary.INT, intelligence);
        mPrimary.put(Primary.WP, willPower);
        mPrimary.put(Primary.FEL, fellowship);

        mSecondary = new EnumMap<>(Secondary.class);
        mSecondary.put(Secondary.A, attacks);
        mSecondary.put(Secondary.W, wounds);
        mSecondary.put(Secondary.SB, strength / 10);
        mSecondary.put(Secondary.TB, toughness / 10);
        mSecondary.put(Secondary.M, movement);
        mSecondary.put(Secondary.MAG, magic);
        mSecondary.put(Secondary.IP, insanityPoints);
        mSecondary.put(Secondary.FP, fatePoints);
    }

    public int getWeaponSkill()
    {
        return mPrimary.get(Primary.WS);
    }

    public int getBallisticSkill()
    {
        return mPrimary.get(Primary.BS);
    }

    public int getStrength()
    {
        return mPrimary.get(Primary.S);
    }

    public int getToughness()
    {
        return mPrimary.get(Primary.T);
    }

    public int getAgility()
    {
        return mPrimary.get(Primary.AG);
    }

    public int getIntelligence()
    {
        return mPrimary.get(Primary.INT);
    }

    public int getWillPower()
    {
        return mPrimary.get(Primary.WP);
    }

    public int getAttacks()
    {
        return mSecondary.get(Secondary.A);
    }

    public int getWounds()
    {
        return mSecondary.get(Secondary.W);
    }

    public int getStrengthBonus()
    {
        return mSecondary.get(Secondary.SB);
    }

    public int getToughnessBonus()
    {
        return mSecondary.get(Secondary.TB);
    }

    public int getMovement()
    {
        return mSecondary.get(Secondary.M);
    }

    public int getMagic()
    {
        return mSecondary.get(Secondary.MAG);
    }

    public int getInsanityPoints()
    {
        return mSecondary.get(Secondary.IP);
    }

    public int getFatePoints()
    {
        return mSecondary.get(Secondary.FP);
    }

}
