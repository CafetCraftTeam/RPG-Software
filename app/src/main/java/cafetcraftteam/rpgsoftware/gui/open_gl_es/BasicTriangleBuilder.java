package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;

import java.util.List;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangleBuilder implements DrawableBuilder {
    private final Context mContext;
    // in counterclockwise order:
    private final List<Float> mVertex1;     // top
    private final List<Float> mVertex2;     // bottom left
    private final List<Float> mVertex3;     // bottom right

    private final List<Float> mColor1;
    private final List<Float> mColor2;
    private final List<Float> mColor3;

    public BasicTriangleBuilder(List<Float> vertex1, List<Float> vertex2, List<Float> vertex3,
                                List<Float> color1, List<Float> color2, List<Float> color3,
                                Context context) {
        mVertex1 = vertex1;
        mVertex2 = vertex2;
        mVertex3 = vertex3;
        mColor1 = color1;
        mColor2 = color2;
        mColor3 = color3;
        mContext = context;
    }

    @Override
    public Drawable build() {
        return new BasicTriangle(mVertex1, mVertex2, mVertex3,
                mColor1, mColor2, mColor3,
                new BasicProgramBuilder(mContext));
    }
}
