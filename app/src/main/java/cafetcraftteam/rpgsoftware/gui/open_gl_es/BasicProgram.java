package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;
import android.opengl.GLES20;

import java.nio.Buffer;

import cafetcraftteam.rpgsoftware.R;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.FragmentShader;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.VertexShader;
import cafetcraftteam.rpgsoftware.utils.Utils;

/**
 * Created by Tago on 10/03/2016.
 */
public class BasicProgram extends Program {
    private static final String POSITION_NAME = "a_Position";
    private static final String COLOR_NAME = "v_Color";
    private static final String MVP_NAME = "u_MVPMatrix";

    private int mPositionHandle;
    private int mColorHandle;
    private int mMVPMatrixHandle;
    private boolean mIsVertexInstantiated = false;
    private boolean mIsMVPMatrixInstantiated = false;
    private boolean mIsColorInstanciated = false;


    public BasicProgram(Context context) {
        super(new VertexShader(Utils.readFile(context, R.raw.basic_vertex)),
                new FragmentShader(Utils.readFile(context, R.raw.basic_fragment))
        );
    }

    @Override
    public void use() {
        super.use();

        GLES20.glEnableVertexAttribArray(mPositionHandle);
    }

    @Override
    public void initialize() {
        super.initialize();

        // get reference to vertex shader's position member
        mPositionHandle = GLES20.glGetAttribLocation(mId, POSITION_NAME);

        // get reference to fragment shader's color member
        mColorHandle = GLES20.glGetUniformLocation(mId, COLOR_NAME);

        // get handle to shape's transformation matrix
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mId, MVP_NAME);
    }

    public void setPosition(int size,
                            int type,
                            boolean normalized,
                            int stride,
                            Buffer vertexBuffer) {
        // set the shape coordinate data
        GLES20.glVertexAttribPointer(
                mPositionHandle, size,
                type, normalized,
                stride, vertexBuffer);

        mIsVertexInstantiated = true;
    }

    public void setColor(int count, float[] v, int offset) {
        // Set color for drawing the shape
        GLES20.glUniform4fv(mColorHandle, count, v, offset);

        mIsColorInstanciated = true;
    }

    public void setMVPMatrix(int count, boolean transpose, float[] mvpMatrix, int offset) {
        // set the projection and view transformation
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, count, transpose, mvpMatrix, offset);

        mIsMVPMatrixInstantiated = true;
    }

    public void draw(int mode, int first, int count) {
        if (!mIsVertexInstantiated) {
            throw new IllegalStateException("The vertex buffer is not instantiated");
        }
        if (!mIsColorInstanciated) {
            throw new IllegalStateException("The color is not instantiated");
        }
        if (!mIsMVPMatrixInstantiated) {
            throw new IllegalStateException("The MVP matrix is not instantiated");
        }
        // Draw the shape
        GLES20.glDrawArrays(mode, first, count);
    }
}
