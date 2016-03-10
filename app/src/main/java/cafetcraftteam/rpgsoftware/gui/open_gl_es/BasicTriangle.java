package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;
import android.opengl.GLES20;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangle extends Triangle {

    public BasicTriangle(float[] vertex1, float[] vertex2, float[] vertex3, Context context) {
        super(vertex1, vertex2, vertex3, new BasicProgramBuilder(context).build());
    }

    @Override
    public void draw(float[] mvpMatrix) {
        mProgram.use();

        // Prepare the triangle coordinate data
        ((BasicProgram) mProgram).setPosition(COORDINATES_PER_VERTEX, GLES20.GL_FLOAT, false,
                VERTEX_STRIDE, mVertexBuffer);

        // Set color for drawing the triangle
        ((BasicProgram) mProgram).setColor(1, mColor, 0);

        // MyGLRenderer.checkGlError("glGetUniformLocation");

        // Apply the projection and view transformation
        ((BasicProgram) mProgram).setMVPMatrix(1, false, mvpMatrix, 0);
        // MyGLRenderer.checkGlError("glUniformMatrix4fv");

        // Draw the triangle
        ((BasicProgram) mProgram).draw(GLES20.GL_TRIANGLES, 0, VERTEX_COUNT);

        // Disable vertex array
        // GLES20.glDisableVertexAttribArray(mPositionHandle);

        mProgram.unUse();
    }

    /**
     * Encapsulates the OpenGL ES instructions for initialize this shape.
     */
    @Override
    public void initialize() {
        mProgram.initialize();
    }
}
