package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tago on 02/03/2016.
 */
public class OpenGLActivity extends Activity
{
    private GLSurfaceView mGLView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // create the node that will be displayed
        List<DrawableBuilder> drawablesBuilder = new ArrayList<>();

        // in counterclockwise order:
        float[] vertex1 = {-0.5f, 0.5f, 0.5f};
        float[] vertex2 = {-0.5f, -0.5f, 0.5f};
        float[] vertex3 = {0.5f, -0.5f, 0.5f};
        float[] vertex4 = {0.5f, 0.5f, 0.5f};
        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex2, vertex3));
        drawablesBuilder.add(new BasicTriangleBuilder(vertex1, vertex3, vertex4));

        NodeBuilder masterNodeBuilder = new NodeBuilder(drawablesBuilder);

        // Create a GLSurfaceView instance and set it as the ContentView for this Activity
        mGLView = new MyGLSurfaceView(this, new MyGLRenderer(masterNodeBuilder));
        setContentView(mGLView);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        // The following call pauses the rendering thread.
        // If your OpenGL application is memory intensive,
        // you should consider de-allocating objects that
        // consume significant memory here.
        mGLView.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        // The following call resumes a paused rendering thread.
        // If you de-allocated graphic objects for onPause()
        // this is a good place to re-allocate them.
        mGLView.onResume();
    }
}
