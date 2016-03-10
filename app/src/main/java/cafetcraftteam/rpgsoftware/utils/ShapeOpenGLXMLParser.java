package cafetcraftteam.rpgsoftware.utils;

import android.content.Context;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cafetcraftteam.rpgsoftware.gui.open_gl_es.BasicTriangleBuilder;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.Drawable;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.Triangle;

/**
 * Created by Tago on 10/03/2016.
 */
public class ShapeOpenGLXMLParser {
    private static final String namespace = null;
    private static final String SHAPE = "Shape";
    private static final String NODE = "Node";
    private static final String TRIANGLE = "Triangle";
    private static final String VERTEX = "Vertex";
    private Context mContext;

    public ShapeOpenGLXMLParser(Context context) {
        mContext = context;
    }

    public List<Drawable> parse(InputStream input) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(input, null);
            parser.nextTag();

            return readFeed(parser);
        } finally {
            input.close();
        }
    }

    private List<Drawable> readFeed(XmlPullParser parser) throws IOException, XmlPullParserException {
        List<Drawable> drawables = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, null, SHAPE);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();

            if (name.equals(TRIANGLE)) {
                drawables.add(readTriangle(parser));
            }
        }

        return drawables;
    }

    private Drawable readTriangle(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, TRIANGLE);
        List<List<Float>> vertices = new ArrayList<>();
        List<List<Float>> colors = new ArrayList<>();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(VERTEX)) {
                vertices.add(readVertex(parser));
            }
        }

        return new BasicTriangleBuilder(vertices.get(0), vertices.get(1), vertices.get(2),
                colors.get(0), colors.get(1), colors.get(2),
                mContext).build();
    }

    private List<Float> readVertex(XmlPullParser parser) {
        return null;
    }

    // Skips tags the parser isn't interested in. Uses depth to handle nested tags. i.e.,
    // if the next tag after a START_TAG isn't a matching END_TAG, it keeps going until it
    // finds the matching END_TAG (as indicated by the value of "depth" being 0).
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
