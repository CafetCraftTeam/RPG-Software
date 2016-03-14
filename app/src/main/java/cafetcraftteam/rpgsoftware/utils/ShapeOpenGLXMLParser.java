package cafetcraftteam.rpgsoftware.utils;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cafetcraftteam.rpgsoftware.gui.open_gl_es.BasicTriangleBuilder;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.DrawableBuilder;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.NodeBuilder;

/**
 * Created by Tago on 10/03/2016.
 */
public class ShapeOpenGLXMLParser {
    private static final String NAMESPACE = null;
    private static final String ROOT = "Root";
    private static final String NODE = "Node";
    private static final String TRIANGLE = "Triangle";
    private static final String VERTEX = "Vertex";
    private static final String COLOR = "Color";
    private static final String X_TAG = "x";
    private static final String Y_TAG = "y";
    private static final String Z_TAG = "z";
    private static final String RED = "red";
    private static final String GREEN = "green";
    private static final String BLUE = "blue";
    private static final String ALPHA = "alpha";

    public List<DrawableBuilder> parse(InputStream input) throws XmlPullParserException, IOException {
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

    private List<DrawableBuilder> readFeed(XmlPullParser parser)
            throws IOException, XmlPullParserException {
        List<DrawableBuilder> drawables = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, NAMESPACE, ROOT);
        drawables.addAll(scan(parser));
        parser.require(XmlPullParser.END_TAG, NAMESPACE, ROOT);

        return drawables;
    }

    private List<DrawableBuilder> scan(XmlPullParser parser) throws XmlPullParserException, IOException {
        List<DrawableBuilder> drawables = new ArrayList<>();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();

            switch (name) {
                case TRIANGLE:
                    drawables.add(readBasicTriangle(parser));
                    break;
                case NODE:
                    drawables.add(readNode(parser));
                    break;
                default:
                    skip(parser);
                    break;
            }
        }

        return drawables;
    }

    private DrawableBuilder readNode(XmlPullParser parser)
            throws IOException, XmlPullParserException {
        List<DrawableBuilder> drawableBuilders = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, NAMESPACE, NODE);

        drawableBuilders.addAll(scan(parser));

        parser.require(XmlPullParser.END_TAG, NAMESPACE, NODE);

        return new NodeBuilder(drawableBuilders);
    }

    private DrawableBuilder readBasicTriangle(XmlPullParser parser)
            throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, NAMESPACE, TRIANGLE);
        List<List<Float>> vertices = new ArrayList<>();
        List<List<Float>> colors = new ArrayList<>();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals(VERTEX)) {
                vertices.add(readVertex(parser));
            } else if (name.equals(COLOR)) {
                colors.add(readColor(parser));
            }
        }

        if (vertices.size() != 3) {
            throw new XmlPullParserException("The triangle must have 3 vertices not : "
                    + vertices.size());
        }
        if (colors.size() != 3 && colors.size() != 1) {
            throw new XmlPullParserException("The triangle must have 1 or 3 color not : "
                    + colors.size());
        }

        if (colors.size() == 1) {
            colors.add(colors.get(0));
            colors.add(colors.get(0));
        }

        parser.require(XmlPullParser.END_TAG, NAMESPACE, TRIANGLE);

        return new BasicTriangleBuilder(vertices.get(0), vertices.get(1), vertices.get(2),
                colors.get(0), colors.get(1), colors.get(2));
    }

    private List<Float> readColor(XmlPullParser parser)
            throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, NAMESPACE, COLOR);

        List<Float> color = new ArrayList<>();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            String name = parser.getName();
            switch (name) {
                case RED:
                    parser.require(XmlPullParser.START_TAG, NAMESPACE, RED);
                    color.add(readFloat(parser));
                    parser.require(XmlPullParser.END_TAG, NAMESPACE, RED);
                    break;
                case GREEN:
                    parser.require(XmlPullParser.START_TAG, NAMESPACE, GREEN);
                    color.add(readFloat(parser));
                    parser.require(XmlPullParser.END_TAG, NAMESPACE, GREEN);
                    break;
                case BLUE:
                    parser.require(XmlPullParser.START_TAG, NAMESPACE, BLUE);
                    color.add(readFloat(parser));
                    parser.require(XmlPullParser.END_TAG, NAMESPACE, BLUE);
                    break;
                case ALPHA:
                    parser.require(XmlPullParser.START_TAG, NAMESPACE, ALPHA);
                    color.add(readFloat(parser));
                    parser.require(XmlPullParser.END_TAG, NAMESPACE, ALPHA);
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        parser.require(XmlPullParser.END_TAG, NAMESPACE, COLOR);

        if (color.size() != 4) {
            throw new XmlPullParserException("The color must have 4 coordinates not : "
                    + color.size());
        }

        return color;
    }

    private List<Float> readVertex(XmlPullParser parser)
            throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, NAMESPACE, VERTEX);

        List<Float> vertex = new ArrayList<>();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            String name = parser.getName();
            switch (name) {
                case X_TAG:
                    parser.require(XmlPullParser.START_TAG, NAMESPACE, X_TAG);
                    vertex.add(readFloat(parser));
                    parser.require(XmlPullParser.END_TAG, NAMESPACE, X_TAG);
                    break;
                case Y_TAG:
                    parser.require(XmlPullParser.START_TAG, NAMESPACE, Y_TAG);
                    vertex.add(readFloat(parser));
                    parser.require(XmlPullParser.END_TAG, NAMESPACE, Y_TAG);
                    break;
                case Z_TAG:
                    parser.require(XmlPullParser.START_TAG, NAMESPACE, Z_TAG);
                    vertex.add(readFloat(parser));
                    parser.require(XmlPullParser.END_TAG, NAMESPACE, Z_TAG);
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        parser.require(XmlPullParser.END_TAG, NAMESPACE, VERTEX);

        if (vertex.size() != 2 && vertex.size() != 3) {
            throw new XmlPullParserException("The vertex must have 2 or 3 coordinates not : "
                    + vertex.size());
        }

        return vertex;
    }

    private Float readFloat(XmlPullParser parser) throws IOException, XmlPullParserException {
        Float coordinate;
        if (parser.next() == XmlPullParser.TEXT) {
            coordinate = Float.parseFloat(parser.getText());
            parser.nextTag();
        } else {
            throw new XmlPullParserException("This entry must only contains a number");
        }

        return coordinate;
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
