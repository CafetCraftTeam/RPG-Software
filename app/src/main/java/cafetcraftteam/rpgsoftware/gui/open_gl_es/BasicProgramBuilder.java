package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;

import cafetcraftteam.rpgsoftware.R;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.FragmentShader;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.VertexShader;
import cafetcraftteam.rpgsoftware.utils.Utils;

/**
 * Created by Tago on 02/03/2016.
 */
public class BasicProgramBuilder implements ProgramBuilder {

    private static final String sVertexShaderCode =
            // This matrix member variable provides a hook to manipulate
            // the coordinates of the objects that use this vertex shader
            "uniform mat4 u_MVPMatrix;              \n" +
            "attribute vec4 a_Position;             \n" +
            "void main() {                          \n" +
            // the matrix must be included as a modifier of gl_Position
            // Note that the uMVPMatrix factor *must be first* in order
            // for the matrix multiplication product to be correct.
            "  gl_Position = u_MVPMatrix * a_Position;\n" +
            "}                                      \n";
    private static final String sFragmentShaderCode =
            "precision mediump float;   \n" +
            "uniform vec4 v_Color;       \n" +
            "void main() {              \n" +
            "  gl_FragColor = v_Color;   \n" +
            "}                          \n";
    private final String mVertexShaderCode;
    private final String mFragmentShaderCode;

    private final Context mContext;

    public BasicProgramBuilder(Context context) {
        mContext = context;

        mVertexShaderCode = Utils.readFile(context, R.raw.basic_vertex);
        mFragmentShaderCode = Utils.readFile(context, R.raw.basic_fragment);
    }

    @Override
    public Program build(){
        return new Program(
                new VertexShader(mVertexShaderCode),
                new FragmentShader(mFragmentShaderCode)
        );
    }
}
