package cafetcraftteam.rpgsoftware.character;

import cafetcraftteam.rpgsoftware.equipment.Equipment;

/**
 * Class that represent the hand of a CharacterWarhammer
 */
public class Hand {
    /**
     * The hand used by a weapon
     */
    public enum Handle {
        LEFT,
        RIGHT,
        BOTH
    }

    private Equipment mLeft;
    private Equipment mRight;

    public Hand(Equipment left, Equipment right) {
        mLeft = left;
        mRight = right;
    }

    public Equipment getLeft() {
        return mLeft;
    }

    public Equipment getRight() {
        return mRight;
    }

    public void useLeft(Equipment equipment) {
        mLeft = equipment;
    }

    public void useRight(Equipment equipment) {
        mRight = equipment;
    }

    public void useBoth(Equipment equipment) {
        mLeft = equipment;
        mRight = equipment;
    }
}
