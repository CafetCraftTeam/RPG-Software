package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangleBuilder implements DrawableBuilder {
    private final Context mContext;
    // in counterclockwise order:
    private final float[] mVertex1;     // top
    private final float[] mVertex2;     // bottom left
    private final float[] mVertex3;     // bottom right
    private static final float[] COLOR = {0.63671875f, 0.76953125f, 0.22265625f, 1.0f};

    public BasicTriangleBuilder(float[] vertex1, float[] vertex2, float[] vertex3, Context context) {
        mVertex1 = vertex1;
        mVertex2 = vertex2;
        mVertex3 = vertex3;
        mContext = context;
    }

    @Override
    public Drawable build() {
        return new BasicTriangle(mVertex1, mVertex2, mVertex3, COLOR, COLOR, COLOR, mContext);
    }
}
