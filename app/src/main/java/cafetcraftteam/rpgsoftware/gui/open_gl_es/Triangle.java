package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import org.apache.commons.lang3.ArrayUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tago on 02/03/2016.
 */
public abstract class Triangle implements Drawable {

    protected final int COORDINATES_PER_VERTEX;
    protected final static int SIZE_OF_THE_COLORS = 4; // 4 float per color

    protected final static int VERTEX_COUNT = 3;
    private final static int BYTES_PER_FLOAT = 4; // 4 bytes per float
    protected final int VERTEX_STRIDE;
    protected final int COLOR_STRIDE;
    protected final FloatBuffer mVertexBuffer;
    protected final FloatBuffer mColorBuffer;
    protected final Program mProgram;

    public Triangle(List<Float> vertex1, List<Float> vertex2, List<Float> vertex3,
                    List<Float> color1, List<Float> color2, List<Float> color3,
                    Program program) {
        if (vertex1.size() != vertex2.size() || vertex1.size() != vertex3.size()) {
            throw new IllegalArgumentException("The vertices must have the same dimension");
        }
        if (vertex1.size() != 2 && vertex1.size() != 3) {
            throw new IllegalArgumentException("The vertices must have a dimension of 2 or 3");
        }
        if (color1.size() != SIZE_OF_THE_COLORS
                || color2.size() != SIZE_OF_THE_COLORS
                || color3.size() != SIZE_OF_THE_COLORS) {
            throw new IllegalArgumentException("The colors must have the 4 float");
        }

        COORDINATES_PER_VERTEX = vertex1.size();
        VERTEX_STRIDE = COORDINATES_PER_VERTEX * BYTES_PER_FLOAT;
        COLOR_STRIDE = SIZE_OF_THE_COLORS * BYTES_PER_FLOAT;

        mProgram = program;

        // initialize vertex byte buffer for shape coordinates
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(
                // (number of coordinate values * 4 bytes per float)
                COORDINATES_PER_VERTEX * VERTEX_COUNT * BYTES_PER_FLOAT);
        // use the device hardware's native byte order
        byteBuffer.order(ByteOrder.nativeOrder());
        // create a floating point buffer from the ByteBuffer
        mVertexBuffer = byteBuffer.asFloatBuffer();

        // add the coordinates to the FloatBuffer
        mVertexBuffer.put(ArrayUtils.toPrimitive(vertex1.toArray(new Float[0])));
        mVertexBuffer.put(ArrayUtils.toPrimitive(vertex2.toArray(new Float[0])));
        mVertexBuffer.put(ArrayUtils.toPrimitive(vertex3.toArray(new Float[0])));
        // set the buffer to read the first coordinate
        mVertexBuffer.position(0);

        // initialize color byte buffer
        byteBuffer = ByteBuffer.allocateDirect(
                // (number of color values * 4 bytes per float)
                SIZE_OF_THE_COLORS * VERTEX_COUNT * BYTES_PER_FLOAT);
        // use the device hardware's native byte order
        byteBuffer.order(ByteOrder.nativeOrder());
        // create a floating point buffer from the ByteBuffer
        mColorBuffer = byteBuffer.asFloatBuffer();

        // add the coordinates to the FloatBuffer
        mColorBuffer.put(ArrayUtils.toPrimitive(color1.toArray(new Float[0])));
        mColorBuffer.put(ArrayUtils.toPrimitive(color2.toArray(new Float[0])));
        mColorBuffer.put(ArrayUtils.toPrimitive(color3.toArray(new Float[0])));
        // set the buffer to read the first coordinate
        mColorBuffer.position(0);

    }

    /**
     * Encapsulates the OpenGL ES instructions for drawing this shape.
     *
     * @param mvpMatrix - The Model View Project matrix in which to draw
     *                  this shape.
     */
    @Override
    public abstract void draw(float[] mvpMatrix);

    /**
     * Encapsulates the OpenGL ES instructions for initialize this shape.
     * If overridden must call the super method
     */
    @Override
    public void initialize() {
        mProgram.initialize();
    }
}
