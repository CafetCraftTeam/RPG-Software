package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tago on 02/03/2016.
 */
public class OpenGLActivity extends Activity {
    private GLSurfaceView mGLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create the node that will be displayed
        List<DrawableBuilder> drawablesBuilder = new ArrayList<>();

        // in counterclockwise order:
        float[] vertex1 = {0.0f, 0.0f, 0.0f};
        float[] vertex2 = {-1.0f, -1.0f, 0.0f};
        float[] vertex3 = {1.0f, -1.0f, 0.0f};
        float[] vertex4 = {1.0f, 1.0f, 0.0f};
        float[] vertex5 = {-1.0f, 1.0f, 0.0f};

        float[] color1 = {1.0f, 0.0f, 0.0f, 1.0f};
        float[] color2 = {0.0f, 1.0f, 0.0f, 1.0f};
        float[] color3 = {0.0f, 0.0f, 1.0f, 1.0f};
        float[] color4 = {1.0f, 1.0f, 0.0f, 1.0f};

        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex2, vertex3,
                color1, color1, color1, this));
        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex3, vertex4,
                color2, color2, color2, this));
        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex4, vertex5,
                color3, color3, color3, this));
        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex5, vertex2,
                color4, color4, color4, this));


        NodeBuilder masterNodeBuilder = new NodeBuilder(drawablesBuilder);

        // Create a GLSurfaceView instance and set it as the ContentView for this Activity
        mGLView = new MyGLSurfaceView(this, new MyGLRenderer(masterNodeBuilder));
        setContentView(mGLView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // The following call pauses the rendering thread.
        // If your OpenGL application is memory intensive,
        // you should consider de-allocating objects that
        // consume significant memory here.
        mGLView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The following call resumes a paused rendering thread.
        // If you de-allocated graphic objects for onPause()
        // this is a good place to re-allocate them.
        mGLView.onResume();
    }
}
