package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;
import android.opengl.GLES20;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangle extends Triangle
{

    private int mPositionHandle;
    private int mColorHandle;
    private int mMVPMatrixHandle;

    public BasicTriangle(float[] vertex1, float[] vertex2, float[] vertex3, Context context) {
        super(vertex1, vertex2, vertex3, new BasicProgramBuilder(context).build());
    }

    @Override
    public void draw(float[] mvpMatrix)
    {
        mProgram.use();

        // Enable a handle to the triangle vertices
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(
                mPositionHandle, COORDINATES_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                VERTEX_STRIDE, mVertexBuffer);

        // Set color for drawing the triangle
        GLES20.glUniform4fv(mColorHandle, 1, mColor, 0);

        // MyGLRenderer.checkGlError("glGetUniformLocation");

        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0);
        // MyGLRenderer.checkGlError("glUniformMatrix4fv");

        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, VERTEX_COUNT);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);

        mProgram.unUse();
    }

    /**
     * Encapsulates the OpenGL ES instructions for initialize this shape.
     */
    @Override
    public void initialize() {
        // get reference to vertex shader's vPosition member
        mPositionHandle = GLES20.glGetAttribLocation(mProgram.getOpenGLId(), "a_Position");

        // get reference to fragment shader's vColor member
        mColorHandle = GLES20.glGetUniformLocation(mProgram.getOpenGLId(), "v_Color");

        // get handle to shape's transformation matrix
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram.getOpenGLId(), "u_MVPMatrix");
    }
}
