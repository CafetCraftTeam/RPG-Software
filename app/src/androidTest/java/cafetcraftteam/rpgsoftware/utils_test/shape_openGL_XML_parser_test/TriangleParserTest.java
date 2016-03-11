package cafetcraftteam.rpgsoftware.utils_test.shape_openGL_XML_parser_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.xmlpull.v1.XmlPullParserException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cafetcraftteam.rpgsoftware.gui.open_gl_es.BasicTriangle;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.BasicTriangleBuilder;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.Drawable;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.DrawableBuilder;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.Triangle;
import cafetcraftteam.rpgsoftware.utils.ShapeOpenGLXMLParser;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by Tago on 10/03/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TriangleParserTest {
    private static final String TRIANGLE_FILE = "xml_test/triangle.xml";
    private ShapeOpenGLXMLParser mParser = new ShapeOpenGLXMLParser();

    @Test
    public void triangleParserTest() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(TRIANGLE_FILE);
        List<DrawableBuilder> drawableBuilders = new ArrayList<>();

        try {
            drawableBuilders = mParser.parse(inputStream);
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
            fail("The parsing have throw an exception : " + e.getMessage());
        }

        assertEquals(1, drawableBuilders.size());
        assertTrue("The drawable builder created is not a Basic Triangle builder",
                drawableBuilders.get(0) instanceof BasicTriangleBuilder);
        BasicTriangleBuilder basicTriangleBuilder = (BasicTriangleBuilder) drawableBuilders.get(0);
        BasicTriangle triangle = (BasicTriangle) basicTriangleBuilder.build();

        assertTrue(triangle != null);
    }
}
