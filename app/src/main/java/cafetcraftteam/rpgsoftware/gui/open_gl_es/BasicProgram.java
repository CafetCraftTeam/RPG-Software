package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;
import android.opengl.GLES20;

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


    public BasicProgram(Context context) {
        super(new VertexShader(Utils.readFile(context, R.raw.basic_vertex)),
                new FragmentShader(Utils.readFile(context, R.raw.basic_fragment))
        );
    }

    @Override
    public void initialize() {
        // get reference to vertex shader's position member
        mPositionHandle = GLES20.glGetAttribLocation(mId, POSITION_NAME);

        // get reference to fragment shader's color member
        mColorHandle = GLES20.glGetUniformLocation(mId, COLOR_NAME);

        // get handle to shape's transformation matrix
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mId, MVP_NAME);
    }
}
