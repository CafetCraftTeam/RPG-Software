package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.opengl.GLES20;

import java.util.Stack;

/**
 * Created by Tago on 02/03/2016.
 */
public class Program {
    private static final Stack<Integer> mActualProgramInUse = new Stack<>();

    private final Shader mVertexShader;
    private final Shader mFragmentShader;

    private final int mId;

    public Program(String vertexShaderCode, String fragmentShaderCode) {
        mVertexShader = new Shader(Shader.ShaderType.VERTEX, vertexShaderCode);
        mFragmentShader = new Shader(Shader.ShaderType.FRAGMENT, fragmentShaderCode);

        // create an empty program (code to execute on the GPU)
        mId = GLES20.glCreateProgram();
        // adding the vertex shader to the program
        mVertexShader.attachTo(mId);
        // adding the fragment shader to the program
        mFragmentShader.attachTo(mId);
        // create the executable of the program
        GLES20.glLinkProgram(mId);
    }

    public void use() {
        mActualProgramInUse.add(mId);
        GLES20.glUseProgram(mId);
    }

    public void unUse() {
        mActualProgramInUse.pop();
        if (mActualProgramInUse.size() > 0)
        {
            GLES20.glUseProgram(mActualProgramInUse.peek());
        } else {
            GLES20.glUseProgram(0);
        }
    }

    public int getOpenGLId() {
        return mId;
    }
}
