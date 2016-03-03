package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.opengl.GLES20;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangle extends Triangle
{
    // in counterclockwise order:
    private static float[] sVertex1 = {0.0f, 0.622008459f, 0.3f};   // top
    private static float[] sVertex2 = {-0.5f, -0.311004243f, 0.0f};   // bottom left
    private static float[] sVertex3 = {0.5f, -0.311004243f, 0.0f};    // bottom right

    public BasicTriangle() {
        super(sVertex1, sVertex2, sVertex3, BasicProgramBuilder.build());
    }

    @Override
    public void draw(float[] mvpMatrix)
    {
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

        mProgram.unUse();
    }
}