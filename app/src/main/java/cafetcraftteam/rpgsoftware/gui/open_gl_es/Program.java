package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.opengl.GLES20;

import java.nio.FloatBuffer;
import java.util.Stack;

import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.FragmentShader;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.VertexShader;

/**
 * Created by Tago on 02/03/2016.
 */
public abstract class Program {
    private static final Stack<Integer> mActualProgramInUse = new Stack<>();

    private final VertexShader mVertexShader;
    private final FragmentShader mFragmentShader;

    protected final int mId;

    private boolean mIsInitialized;

    public Program(VertexShader vertexShader, FragmentShader fragmentShader) {
        mVertexShader = vertexShader;
        mFragmentShader = fragmentShader;

        // create an empty program (code to execute on the GPU)
        mId = GLES20.glCreateProgram();
        // adding the vertex shader to the program
        mVertexShader.attachTo(mId);
        // adding the fragment shader to the program
        mFragmentShader.attachTo(mId);
        // create the executable of the program
        GLES20.glLinkProgram(mId);
    }

    /**
     * Must be override with a call of the super function
     */
    public void initialize() {
        mIsInitialized = true;
    }

    /**
     * Must be override with a call of the super function
     */
    public void use() {
        if (!mIsInitialized) {
            initialize();
        }

        // avoid to fill the stack with the same program
        if (mActualProgramInUse.size() == 0 || mActualProgramInUse.peek() != mId) {
            mActualProgramInUse.add(mId);
        }
        GLES20.glUseProgram(mId);
    }

    public void unUse() {
        if (mActualProgramInUse.pop() != mId) {
            throw new IllegalStateException("The actual program in use is not this one");
        }
        if (mActualProgramInUse.size() > 0) {
            GLES20.glUseProgram(mActualProgramInUse.peek());
        } else {
            GLES20.glUseProgram(0);
        }
    }
}
