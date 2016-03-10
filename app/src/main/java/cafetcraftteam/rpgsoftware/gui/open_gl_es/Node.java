package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import java.util.List;

/**
 * A collection of Drawable that will be drawn at the same time in the given order
 */
public class Node implements Drawable {
    private List<Drawable> mChildren;

    public Node(List<Drawable> children) {
        mChildren = children;
    }

    @Override
    public void draw(float[] mvpMatrix) {
        for (Drawable drawable : mChildren) {
            drawable.draw(mvpMatrix);
        }
    }

    @Override
    public void initialize() {
        for (Drawable drawable : mChildren) {
            drawable.initialize();
        }
    }
}
