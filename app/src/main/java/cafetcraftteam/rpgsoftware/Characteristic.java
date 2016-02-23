package cafetcraftteam.rpgsoftware;

import java.util.EnumMap;
import java.util.Map;

/**
 * Class that contains all the characteristic of a Warhammer character
 */
public class Characteristic {
    /**
     * Enum containing the abbreviation of the primary profile
     */
    public enum Primary {
        WS, BS, S, T, AG, INT, WP, FEL
    }

    /**
     * Enum containing the abbreviation of the secondary profile
     */
    public enum Secondary {
        A, W, SB, TB, M, MAG, IP, FP
    }

    /**
     * map containing all the values for every characteristic in the primary profile
     */
    private Map<Primary, Integer> mPrimary;
    /**
     * map containing all the values for every characteristic in the secondary profile
     */
    private Map<Secondary, Integer> mSecondary;

    /**
     * Constructor of the Characteristic class
     *
     * @param weaponSkill    the value of weapon skill, must be strictly positive
     * @param ballisticSkill the value of the ballistic skill, must be strictly positive
     * @param strength       the value of the strength, must be strictly positive
     * @param toughness      the value of the toughness, must be strictly positive
     * @param agility        the value of the agility, must be strictly positive
     * @param intelligence   the value of the intelligence, must be strictly positive
     * @param willPower      the value of the will power, must be strictly positive
     * @param fellowship     the value of the fellowship, must be strictly positive
     * @param attacks        the number of attacks, must be positive
     * @param wounds         the number of the wounds, must be strictly positive
     * @param movement       the value of movement, must be strictly positive
     * @param magic          the value of magic, must be positive
     * @param insanityPoints the number of insanity points, must be positive
     * @param fatePoints     the number of fate points, must be positive
     */
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
                          int fatePoints) {
        if (weaponSkill <= 0) {
            throw new InstantiationError("The weapon skill must be strictly positive");
        }
        if (ballisticSkill <= 0) {
            throw new InstantiationError("The ballistic skill must be strictly positive");
        }
        if (strength <= 0) {
            throw new InstantiationError("The strength must be strictly positive");
        }
        if (toughness <= 0) {
            throw new InstantiationError("The toughness must be strictly positive");
        }
        if (agility <= 0) {
            throw new InstantiationError("The agility must be strictly positive");
        }
        if (intelligence <= 0) {
            throw new InstantiationError("The intelligence must be strictly positive");
        }
        if (willPower <= 0) {
            throw new InstantiationError("The will power must be strictly positive");
        }
        if (fellowship <= 0) {
            throw new InstantiationError("The fellowship must be strictly positive");
        }
        if (attacks < 0) {
            throw new InstantiationError("The number of attacks must be positive");
        }
        if (wounds <= 0) {
            throw new InstantiationError("The number of wounds must be strictly positive");
        }
        if (movement <= 0) {
            throw new InstantiationError("The movement must be strictly positive");
        }
        if (magic < 0) {
            throw new InstantiationError("The magic must be positive");
        }
        if (insanityPoints < 0) {
            throw new InstantiationError("The number of insanity points must be positive");
        }
        if (fatePoints < 0) {
            throw new InstantiationError("The number of fate points must be positive");
        }

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

    public int getWeaponSkill() {
        return mPrimary.get(Primary.WS);
    }

    public int getBallisticSkill() {
        return mPrimary.get(Primary.BS);
    }

    public int getStrength() {
        return mPrimary.get(Primary.S);
    }

    public int getToughness() {
        return mPrimary.get(Primary.T);
    }

    public int getAgility() {
        return mPrimary.get(Primary.AG);
    }

    public int getIntelligence() {
        return mPrimary.get(Primary.INT);
    }

    public int getWillPower() {
        return mPrimary.get(Primary.WP);
    }

    public int getAttacks() {
        return mSecondary.get(Secondary.A);
    }

    public int getWounds() {
        return mSecondary.get(Secondary.W);
    }

    public int getStrengthBonus() {
        return mSecondary.get(Secondary.SB);
    }

    public int getToughnessBonus() {
        return mSecondary.get(Secondary.TB);
    }

    public int getMovement() {
        return mSecondary.get(Secondary.M);
    }

    public int getMagic() {
        return mSecondary.get(Secondary.MAG);
    }

    public int getInsanityPoints() {
        return mSecondary.get(Secondary.IP);
    }

    public int getFatePoints() {
        return mSecondary.get(Secondary.FP);
    }

}
