package cafetcraftteam.rpgsoftware.equipment;

import android.support.annotation.NonNull;

import java.util.Map;

import cafetcraftteam.rpgsoftware.character.CharacterWarhammer;


/**
 * Created by Gautier on 14/02/2016.
 */
public class Armour extends Equipment
{
    private final Map<CharacterWarhammer.BodyPart, Integer> mProtectedParts;

    public Armour(String name, int encumbering, int price, @NonNull Quality quality,
                  String description, @NonNull Map<CharacterWarhammer.BodyPart, Integer> protectedParts)
    {
        super(name, encumbering, price, quality, description);

        if (protectedParts.isEmpty()) {
            throw new InstantiationError("No body parts protected by this armour");
        }

        mProtectedParts = protectedParts;
    }

    public int getArmourPoint(CharacterWarhammer.BodyPart bodyPart) {
        if (mProtectedParts.containsKey(bodyPart))
        {
            return mProtectedParts.get(bodyPart);
        }
        else {
            return 0;
        }
    }

    public boolean isProtected(CharacterWarhammer.BodyPart bodyPart)
    {
        return mProtectedParts.containsKey(bodyPart);
    }
}
