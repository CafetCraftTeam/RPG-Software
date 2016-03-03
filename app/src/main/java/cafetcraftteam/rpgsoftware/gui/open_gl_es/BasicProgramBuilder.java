package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.FragmentShader;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.VertexShader;

/**
 * Created by Tago on 02/03/2016.
 */
public class BasicProgramBuilder {

    private static final String sVertexShaderCode =
            // This matrix member variable provides a hook to manipulate
            // the coordinates of the objects that use this vertex shader
            "uniform mat4 uMVPMatrix;" +
            "attribute vec4 vPosition;" +
            "void main() {" +
            // the matrix must be included as a modifier of gl_Position
            // Note that the uMVPMatrix factor *must be first* in order
            // for the matrix multiplication product to be correct.
            "  gl_Position = uMVPMatrix * vPosition;" +
            "}";
    private static final String sFragmentShaderCode =
            "precision mediump float;" +
            "uniform vec4 vColor;" +
            "void main() {" +
            "  gl_FragColor = vColor;" +
            "}";

    public static Program build(){
        return new Program(
                new VertexShader(sVertexShaderCode),
                new FragmentShader(sFragmentShaderCode)
        );
    }
}
