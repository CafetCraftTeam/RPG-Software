package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.opengl.GLES20;

/**
 * Created by Tago on 02/03/2016.
 */
public class Program {
    private final Shader mVertexShader;
    private final Shader mFragmentShader;

    private final int mId;

    public Program(String vertexShaderCode, String fragementShaderCode) {
        mVertexShader = new Shader(Shader.ShaderType.VERTEX, vertexShaderCode);
        mFragmentShader = new Shader(Shader.ShaderType.FRAGMENT, fragementShaderCode);

        // create an empty program (code to execute on the GPU)
        mId = GLES20.glCreateProgram();
        // adding the vertex shader to the program
        mVertexShader.attachTo(mId);
        // adding the fragment shader to the program
        mFragmentShader.attachTo(mId);
        // create the executable of the program
        GLES20.glLinkProgram(mId);
    }
}
