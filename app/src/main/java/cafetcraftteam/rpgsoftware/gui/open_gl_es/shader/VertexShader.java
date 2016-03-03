package cafetcraftteam.rpgsoftware.gui.open_gl_es.shader;

import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.Shader;

/**
 * Created by Gautier on 03/03/2016.
 */
public class VertexShader extends Shader
{
    public VertexShader(String code)
    {
        super(ShaderType.VERTEX, code);
    }
}
