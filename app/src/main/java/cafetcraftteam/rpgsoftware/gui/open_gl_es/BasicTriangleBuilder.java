package cafetcraftteam.rpgsoftware.gui.open_gl_es;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangleBuilder implements DrawableBuilder
{
    @Override
    public Drawable build()
    {
        return new BasicTriangle();
    }
}
