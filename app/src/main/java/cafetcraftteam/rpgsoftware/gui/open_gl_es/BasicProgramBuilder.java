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

    private final String mVertexShaderCode;
    private final String mFragmentShaderCode;

    public BasicProgramBuilder(Context context) {
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
