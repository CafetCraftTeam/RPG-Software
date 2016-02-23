package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.Map;

import cafetcraftteam.rpgsoftware.character.CharacterWarhammer.BodyPart;


/**
 * Class that represent all the aspects of an armour
 */
public class Armour extends Equipment
{
    // the protected parts of the body and the value of the armour on this part
    private final Map<BodyPart, Integer> mProtectedParts;

    /**
     * Constructor of an armour
     *
     * @param name           the name of the armour, must not be null or empty
     * @param encumbering    the encumbering of the armour, must be positive
     * @param price          the price of the equipment, must be positive
     * @param quality        the quality of the equipment as an enum Quality, must be not null
     * @param description    the description of the equipment, could be empty, if null is passed the
     *                       description is set to an empty string
     * @param protectedParts the protected parts and the value of the armour on this parts as a map
     */
    public Armour(@NonNull String name, int encumbering, int price, @NonNull Quality quality,
                  @Nullable String description,
                  @NonNull Map<BodyPart, Integer> protectedParts)
    {
        super(name, encumbering, price, quality, description);

        if (protectedParts == null)
        {
            throw new InstantiationError("Protected parts should not be null");
        }
        // remove all the entry that are equals to zero
        protectedParts.values().removeAll(Collections.singleton(0));
        if (protectedParts.isEmpty())
        {
            throw new InstantiationError("No body parts protected by this armour");
        }
        for (Map.Entry<BodyPart, Integer> entry : protectedParts.entrySet())
        {
            if (entry.getValue() < 0)
            {
                throw new InstantiationError("The value of protection must be greater than zero");
            }
        }

        mProtectedParts = protectedParts;
    }


    /**
     * Getter of the value of protection on the body part specified.
     *
     * @param bodyPart the body part on which the protection is searched
     * @return the value of protection given by this armour on the specified body part.
     * O if this armour give no protection
     */
    public int getArmourPoint(BodyPart bodyPart)
    {
        if (mProtectedParts.containsKey(bodyPart))
        {
            return mProtectedParts.get(bodyPart);
        } else
        {
            return 0;
        }
    }

    /**
     * The body part given is protected or not by this armour
     *
     * @param bodyPart the body part searched
     * @return true if this armour have a protection greater than 0, false otherwise.
     */
    public boolean isProtected(BodyPart bodyPart)
    {
        return mProtectedParts.containsKey(bodyPart);
    }
}
