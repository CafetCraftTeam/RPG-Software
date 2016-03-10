package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;
import android.opengl.GLES20;

/**
 * Created by Gautier on 03/03/2016.
 */
public class BasicTriangle extends Triangle {
    private BasicProgram mProgram;

    public BasicTriangle(float[] vertex1, float[] vertex2, float[] vertex3,
                         float[] color1, float[] color2, float[] color3,
                         Context context) {
        super(vertex1, vertex2, vertex3,
                color1, color2, color3,
                new BasicProgramBuilder(context).build());
        mProgram = (BasicProgram) super.mProgram;
    }

    @Override
    public void draw(float[] mvpMatrix) {
        // Prepare the triangle coordinate data
        mProgram.setPosition(COORDINATES_PER_VERTEX, GLES20.GL_FLOAT, false,
                VERTEX_STRIDE, mVertexBuffer);

        // Set color for drawing the triangle
        mProgram.setColor(SIZE_OF_THE_COLORS, GLES20.GL_FLOAT, false,
                COLOR_STRIDE, mColorBuffer);

        // MyGLRenderer.checkGlError("glGetUniformLocation");

        // Apply the projection and view transformation
        mProgram.setMVPMatrix(1, false, mvpMatrix, 0);
        // MyGLRenderer.checkGlError("glUniformMatrix4fv");

        // Draw the triangle
        mProgram.draw(GLES20.GL_TRIANGLES, 0, VERTEX_COUNT);

        // Disable vertex array
        // GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
}
