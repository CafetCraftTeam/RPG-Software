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
}
