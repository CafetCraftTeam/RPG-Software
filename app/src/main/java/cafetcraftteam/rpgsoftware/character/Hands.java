package cafetcraftteam.rpgsoftware.character;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;

import cafetcraftteam.rpgsoftware.equipment.Equipment;

/**
 * Class that represent the hand of a CharacterWarhammer
 */
public class Hands {
    /**
     * The hand used by a weapon
     */
    public enum Handle {
        LEFT,
        RIGHT,
        BOTH
    }

    private Equipment mLeft; // the equipment actually in the left hand
    private Equipment mRight; // the equipment actually in the right hand

    /**
     * Constructor of some Hands with the equipment given into it
     *
     * @param left  the equipment in the left hand, could be null which mean there is nothing in
     *              this hand
     * @param right the equipment int the right hand, could be null which mean there is nothing in
     *              this hand
     */
    public Hands(@Nullable Equipment left, @Nullable Equipment right) {
        mLeft = left;
        mRight = right;
    }

    /**
     * Getter of the equipment actually in the left hand
     *
     * @return the equipment actually in the left hand, could be null if there none
     */
    @Nullable
    public Equipment getLeft() {
        return mLeft;
    }

    /**
     * Getter of the equipment actually in the right hand
     *
     * @return the equipment actually in the right hand, could be null if there none
     */
    @Nullable
    public Equipment getRight() {
        return mRight;
    }

    /**
     * Assign the given equipment to the left hand
     *
     * @param leftHandEquipment the equipment to assign to the left hand, could be null
     * @return the previous equipment in the left hand, could be null if there is none
     */
    @Nullable
    public Equipment useLeft(@Nullable Equipment leftHandEquipment) {
        Equipment returnEquipment = mLeft;
        mLeft = leftHandEquipment;
        return returnEquipment;
    }

    /**
     * Assign the given equipment to the right hand
     *
     * @param rightHandEquipment the equipment to assign to the right hand, could be null
     * @return the previous equipment in the right hand, could be null if there is none
     */
    @Nullable
    public Equipment useRight(@Nullable Equipment rightHandEquipment) {
        Equipment returnEquipment = mRight;
        mRight = rightHandEquipment;
        return returnEquipment;
    }

    /**
     * Assign the given equipment to both hand
     *
     * @param bothHandsEquipment the equipment to assign to both hand, could be null
     * @return the previous equipments in both hand as a Pair, with the left in first and the right
     * in second, could be a pair of null if there is none
     */
    @NonNull
    public Pair<Equipment, Equipment> useBoth(@Nullable Equipment bothHandsEquipment) {
        Pair<Equipment, Equipment> previousEquipments = new Pair<>(mLeft, mRight);
        mLeft = bothHandsEquipment;
        mRight = bothHandsEquipment;
        return previousEquipments;
    }
}
