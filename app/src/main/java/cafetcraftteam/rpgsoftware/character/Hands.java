package cafetcraftteam.rpgsoftware.character;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
     * Unsheathe the equipment given with the left hand. This hand must be empty, otherwise an
     * IllegalStateException is thrown
     *
     * @param equipment the equipment to handle in the left hand, must be not null
     */
    public void unsheatheLeft(@NonNull Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("The equipment must not be null");
        }

        // verify that the left hand is empty
        if (mLeft != null) {
            throw new IllegalStateException("The left hand must be empty to unsheathe something " +
                    "with it");
        }

        mLeft = equipment;
    }

    /**
     * Unsheathe the equipment given with the right hand. This hand must be empty, otherwise an
     * IllegalStateException is thrown
     *
     * @param equipment the equipment to handle in the right hand, must be not null
     */
    public void unsheatheRight(@NonNull Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("The equipment must not be null");
        }

        // verify that the right hand is empty
        if (mRight != null) {
            throw new IllegalStateException("The right hand must be empty to unsheathe something" +
                    " with it");
        }

        mRight = equipment;
    }

    /**
     * Unsheathe the equipment given with both hand. The hands must be empty, otherwise an
     * IllegalStateException is thrown
     *
     * @param equipment the equipment to handle in both hand, must be not null
     */
    public void unsheatheBoth(@NonNull Equipment equipment) {
        // verify that the both hand is empty
        if (equipment == null) {
            throw new IllegalArgumentException("The equipment must not be null");
        }
        if (mLeft != null || mRight != null) {
            throw new IllegalStateException("Both hands must be empty to unsheathe something with it");
        }

        mLeft = equipment;
        mRight = equipment;
    }

    /**
     * Sheathe the equipment actually in the left hand. This hand must not be empty, otherwise an
     * IllegalStateException is thrown
     *
     * @return the equipment previously in the left hand, always not null
     */
    @NonNull
    public Equipment sheatheLeft() {
        // verify that the left hand is not empty
        if (mLeft == null) {
            throw new IllegalStateException("The left hand must not be empty");
        }

        Equipment sheatheEquipment = mLeft;
        mLeft = null;
        return sheatheEquipment;
    }

    /**
     * Sheathe the equipment actually in the right hand. This hand must not be empty, otherwise an
     * IllegalStateException is thrown
     *
     * @return the equipment previously in the right hand, always not null
     */
    @NonNull
    public Equipment sheatheRight() {
        // verify that the right hand is not empty
        if (mRight == null) {
            throw new IllegalStateException("The right hand must not be empty");
        }

        Equipment sheatheEquipment = mRight;
        mRight = null;
        return sheatheEquipment;
    }

    /**
     * Sheathe the equipment actually in both hand. The hand must not be both empty, otherwise an
     * IllegalStateException is thrown
     *
     * @return the equipments previously in the both hand as a list, with the left equipment in
     * first and the right one in second, always not null, but if one of the hands was empty, the
     * array contains only the equipment of the not empty hands
     */
    @NonNull
    public List<Equipment> sheatheBoth() {
        // verify that the both hand are not empty
        if (mLeft == null && mRight == null) {
            throw new IllegalStateException("Both hand must not be empty");
        }

        List<Equipment> sheatheEquipments = new ArrayList<>();
        if (mLeft != null) {
            sheatheEquipments.add(mLeft);
        }
        if (mRight != null) {
            sheatheEquipments.add(mRight);
        }
        mLeft = null;
        mRight = null;

        return sheatheEquipments;
    }
}
