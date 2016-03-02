package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by Tago on 02/03/2016.
 */
public class Triangle {

    private final int COORDINATES_PER_VERTEX = 3;
    private static float[] sVertices = {
            // in counterclockwise order:
            0.0f, 0.622008459f, 0.3f,   // top
            -0.5f, -0.311004243f, 0.0f,   // bottom left
            0.5f, -0.311004243f, 0.0f    // bottom right
    };
    private final int VERTEX_COUNT = sVertices.length / COORDINATES_PER_VERTEX;
    private final int VERTEX_STRIDE = COORDINATES_PER_VERTEX * 4; // 4 bytes per float
    private final FloatBuffer mVertexBuffer;
    private final Program mProgram;

    float mColor[] = { 0.63671875f, 0.76953125f, 0.22265625f, 0.0f };

    public Triangle(Program program) {
        // initialize vertex byte buffer for shape coordinates
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(
                // (number of coordinate values * 4 bytes per float)
                sVertices.length * 4);
        // use the device hardware's native byte order
        byteBuffer.order(ByteOrder.nativeOrder());

        // create a floating point buffer from the ByteBuffer
        mVertexBuffer = byteBuffer.asFloatBuffer();
        // add the coordinates to the FloatBuffer
        mVertexBuffer.put(sVertices);
        // set the buffer to read the first coordinate
        mVertexBuffer.position(0);

        mProgram = program;
    }

    public Triangle() {
        this(new BasicProgram());
    }

    /**
     * Encapsulates the OpenGL ES instructions for drawing this shape.
     *
     * @param mvpMatrix - The Model View Project matrix in which to draw
     *                  this shape.
     */
    public void draw(float[] mvpMatrix) {
        mProgram.use();

        // get reference to vertex shader's vPosition member
        int vPositionRef = GLES20.glGetAttribLocation(mProgram.getOpenGLId(), "vPosition");

        // Enable a handle to the triangle vertices
        GLES20.glEnableVertexAttribArray(vPositionRef);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(
                vPositionRef, COORDINATES_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                VERTEX_STRIDE, mVertexBuffer);

        // get reference to fragment shader's vColor member
        int colorRef = GLES20.glGetUniformLocation(mProgram.getOpenGLId(), "vColor");

        // Set color for drawing the triangle
        GLES20.glUniform4fv(colorRef, 1, mColor, 0);

        // get handle to shape's transformation matrix
        int MVPMatrixRef = GLES20.glGetUniformLocation(mProgram.getOpenGLId(), "uMVPMatrix");
        // MyGLRenderer.checkGlError("glGetUniformLocation");

        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(MVPMatrixRef, 1, false, mvpMatrix, 0);
        // MyGLRenderer.checkGlError("glUniformMatrix4fv");

        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, VERTEX_COUNT);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(vPositionRef);
    }

}
