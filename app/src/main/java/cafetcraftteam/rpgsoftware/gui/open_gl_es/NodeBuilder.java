package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gautier on 03/03/2016.
 */
public class NodeBuilder implements DrawableBuilder {
    private List<DrawableBuilder> mDrawableBuilders;

    public NodeBuilder(List<DrawableBuilder> drawableBuilders) {
        mDrawableBuilders = drawableBuilders;
    }

    @Override
    public Drawable build() {
        List<Drawable> drawables = new ArrayList<>();

        for (DrawableBuilder drawableBuilder : mDrawableBuilders) {
            drawables.add(drawableBuilder.build());
        }
        return new Node(drawables);
    }
}
