package cafetcraftteam.rpgsoftware.equipment;

import cafetcraftteam.rpgsoftware.BodyPart;

/**
 * Created by Gautier on 14/02/2016.
 */
public class Armour extends Equipment
{
    private int mArmourPoint;
    private final BodyPart mProtectedPart;

    public Armour(String name, int encumbering, Quality quality, String description, int armourPoint,
                  BodyPart protectedPart)
    {
        super(name, encumbering, quality, description);

        mArmourPoint = armourPoint;
        mProtectedPart = protectedPart;
    }

    public int getArmourPoint() {
        return mArmourPoint;
    }

    public BodyPart getProtectedPart() {
        return mProtectedPart;
    }
}
