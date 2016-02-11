package cafetcraftteam.rpgsoftware;

/**
 * Created by Gautier on 11/02/2016.
 */
public class Weapon extends Equipment
{
    private String mGroup;
    private String mQualities;

    public Weapon(String name, int encumbering, Quality quality, String description, String group,
                  String qualities)
    {
        super(name, encumbering, quality, description);
        mGroup = group;
        mQualities = qualities;
    }

    public String getGroup()
    {
        return mGroup;
    }

    public String getQualities()
    {
        return mQualities;
    }
}
