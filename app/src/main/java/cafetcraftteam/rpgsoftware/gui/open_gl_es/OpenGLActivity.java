package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cafetcraftteam.rpgsoftware.utils.ShapeOpenGLXMLParser;

/**
 * Created by Tago on 02/03/2016.
 */
public class OpenGLActivity extends Activity {
    private GLSurfaceView mGLView;

    private static final String SHAPE_FILE = "xml/basic_shape.xml";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create the drawables that will be displayed
        List<DrawableBuilder> drawablesBuilder = new ArrayList<>();

        ShapeOpenGLXMLParser parser = new ShapeOpenGLXMLParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(SHAPE_FILE);
        try {
            drawablesBuilder = parser.parse(inputStream);
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        // create the root node that containing all the scene
        NodeBuilder rootNodeBuilder = new NodeBuilder(drawablesBuilder);

        // Create a GLSurfaceView instance and set it as the ContentView for this Activity
        mGLView = new MyGLSurfaceView(this, new MyGLRenderer(rootNodeBuilder));
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
