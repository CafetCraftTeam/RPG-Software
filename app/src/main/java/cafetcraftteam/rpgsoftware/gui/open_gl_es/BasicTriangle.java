package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.opengl.GLES20;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangle extends Triangle
{
    public BasicTriangle(float[] vertex1, float[] vertex2, float[] vertex3) {
        super(vertex1, vertex2, vertex3, new BasicProgramBuilder().build());
    }

    @Override
    public void draw(float[] mvpMatrix)
    {
        mProgram.use();

        // get reference to vertex shader's vPosition member
        int vPositionRef = GLES20.glGetAttribLocation(mProgram.getOpenGLId(), "a_Position");

        // Enable a handle to the triangle vertices
        GLES20.glEnableVertexAttribArray(vPositionRef);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(
                vPositionRef, COORDINATES_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                VERTEX_STRIDE, mVertexBuffer);

        // get reference to fragment shader's vColor member
        int colorRef = GLES20.glGetUniformLocation(mProgram.getOpenGLId(), "v_Color");

        // Set color for drawing the triangle
        GLES20.glUniform4fv(colorRef, 1, mColor, 0);

        // get handle to shape's transformation matrix
        int MVPMatrixRef = GLES20.glGetUniformLocation(mProgram.getOpenGLId(), "u_MVPMatrix");
        // MyGLRenderer.checkGlError("glGetUniformLocation");

        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(MVPMatrixRef, 1, false, mvpMatrix, 0);
        // MyGLRenderer.checkGlError("glUniformMatrix4fv");

        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, VERTEX_COUNT);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(vPositionRef);

        mProgram.unUse();
    }
}
