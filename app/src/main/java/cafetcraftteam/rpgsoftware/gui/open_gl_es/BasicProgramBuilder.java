package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.FragmentShader;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.VertexShader;

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

    @Override
    public Program build(){
        return new Program(
                new VertexShader(sVertexShaderCode),
                new FragmentShader(sFragmentShaderCode)
        );
    }
}
