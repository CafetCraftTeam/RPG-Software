package cafetcraftteam.rpgsoftware.gui.open_gl_es;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangleBuilder implements DrawableBuilder
{
    // in counterclockwise order:
    private float[] mVertex1 = {0.0f, 0.622008459f, 0.3f};   // top
    private float[] mVertex2 = {-0.5f, -0.311004243f, 0.0f};   // bottom left
    private float[] mVertex3 = {0.5f, -0.311004243f, 0.0f};    // bottom right

    public BasicTriangleBuilder() {}

    public BasicTriangleBuilder(float[] vertex1, float[] vertex2, float[] vertex3) {
        mVertex1 = vertex1;
        mVertex2 = vertex2;
        mVertex3 = vertex3;
    }

    @Override
    public Drawable build()
    {
        return new BasicTriangle(mVertex1, mVertex2, mVertex3);
    }
}
