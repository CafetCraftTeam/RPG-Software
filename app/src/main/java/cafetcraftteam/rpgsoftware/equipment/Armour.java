package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;

import java.util.NoSuchElementException;
import java.util.Set;

import cafetcraftteam.rpgsoftware.BodyPart;

/**
 * Created by Gautier on 14/02/2016.
 */
public class Armour extends Equipment
{
    private int mArmourPoint;
    private final Set<BodyPart> mProtectedParts;

    public Armour(String name, int encumbering, @NonNull Quality quality, String description, int armourPoint,
                  @NonNull Set<BodyPart> protectedParts)
    {
        super(name, encumbering, quality, description);

        if (protectedParts.isEmpty()) {
            throw new InstantiationError("No body parts protected by this armour");
        }

        mArmourPoint = armourPoint;
        mProtectedParts = protectedParts;
    }

    public int getArmourPoint() {
        return mArmourPoint;
    }

    public Set<BodyPart> getProtectedParts() {
        return mProtectedParts;
    }

    public boolean isProtected(BodyPart bodyPart)
    {
        return mProtectedParts.contains(bodyPart);
    }
}
