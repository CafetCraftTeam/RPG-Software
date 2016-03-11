package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<Float> vertex1 = new ArrayList<>(Arrays.asList(0.0f, 0.0f, 0.0f));
        List<Float> vertex2 = new ArrayList<>(Arrays.asList(-1.0f, -1.0f, 0.0f));
        List<Float> vertex3 = new ArrayList<>(Arrays.asList(1.0f, -1.0f, 0.0f));
        List<Float> vertex4 = new ArrayList<>(Arrays.asList(1.0f, 1.0f, 0.0f));
        List<Float> vertex5 = new ArrayList<>(Arrays.asList(-1.0f, 1.0f, 0.0f));

        List<Float> color1 = new ArrayList<>(Arrays.asList(1.0f, 0.0f, 0.0f, 1.0f));
        List<Float> color2 = new ArrayList<>(Arrays.asList(0.0f, 1.0f, 0.0f, 1.0f));
        List<Float> color3 = new ArrayList<>(Arrays.asList(0.0f, 0.0f, 1.0f, 1.0f));
        List<Float> color4 = new ArrayList<>(Arrays.asList(1.0f, 1.0f, 0.0f, 1.0f));

        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex2, vertex3,
                color1, color1, color1));
        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex3, vertex4,
                color2, color2, color2));
        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex4, vertex5,
                color3, color3, color3));
        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex5, vertex2,
                color4, color4, color4));


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
