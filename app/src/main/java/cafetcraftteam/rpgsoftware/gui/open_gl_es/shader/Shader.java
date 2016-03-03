package cafetcraftteam.rpgsoftware.gui.open_gl_es.shader;

import android.opengl.GLES20;

/**
 * Created by Tago on 02/03/2016.
 */
public class Shader {
    public enum ShaderType {
        VERTEX(GLES20.GL_VERTEX_SHADER),
        FRAGMENT(GLES20.GL_FRAGMENT_SHADER);

        ShaderType(int openGLId){
            mOpenGLInt = openGLId;
        }

        private int mOpenGLInt;

        public int getOpenGLInt() {
            return mOpenGLInt;
        }
    }

    private final String mCode;
    private final int mId;

    public Shader(ShaderType type, String code) {
        mCode = code;
        // create a vertex of the type given
        mId = GLES20.glCreateShader(type.getOpenGLInt());

        // adding the code to the shader
        GLES20.glShaderSource(mId, mCode);

        // compile the shader
        GLES20.glCompileShader(mId);
    }

    public int getId() {
        return mId;
    }

    public void attachTo(int programOpenGLId) {
        GLES20.glAttachShader(programOpenGLId, mId);
    }
}
