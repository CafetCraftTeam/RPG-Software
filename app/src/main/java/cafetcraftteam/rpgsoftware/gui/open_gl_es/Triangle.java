package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by Tago on 02/03/2016.
 */
public abstract class Triangle implements Drawable {

    protected final int COORDINATES_PER_VERTEX;

    protected final static int VERTEX_COUNT = 3;
    private final static int BYTES_PER_FLOAT = 4;
    protected final int VERTEX_STRIDE;
    protected final FloatBuffer mVertexBuffer;
    protected final Program mProgram;

    float mColor[] = {0.63671875f, 0.76953125f, 0.22265625f, 0.0f};

    public Triangle(float[] vertex1, float[] vertex2, float[] vertex3, Program program) {
        if (vertex1.length != vertex2.length || vertex1.length != vertex3.length) {
            throw new IllegalArgumentException("The vertices must have the same dimension");
        }
        if (vertex1.length != 2 && vertex1.length != 3) {
            throw new IllegalArgumentException("The vertices must have a dimension of 2 or 3");
        }

        COORDINATES_PER_VERTEX = vertex1.length;
        VERTEX_STRIDE = COORDINATES_PER_VERTEX * BYTES_PER_FLOAT; // 4 bytes per float

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
        mVertexBuffer.put(vertex1);
        mVertexBuffer.put(vertex2);
        mVertexBuffer.put(vertex3);
        // set the buffer to read the first coordinate
        mVertexBuffer.position(0);
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
