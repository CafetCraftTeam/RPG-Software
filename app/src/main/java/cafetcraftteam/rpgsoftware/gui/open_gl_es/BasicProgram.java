package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;

import cafetcraftteam.rpgsoftware.R;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.FragmentShader;
import cafetcraftteam.rpgsoftware.gui.open_gl_es.shader.VertexShader;
import cafetcraftteam.rpgsoftware.utils.Utils;

/**
 * Created by Tago on 10/03/2016.
 */
public class BasicProgram extends Program {
    public BasicProgram(Context context) {
        super(new VertexShader(Utils.readFile(context, R.raw.basic_vertex)),
                new FragmentShader(Utils.readFile(context, R.raw.basic_fragment))
        );
    }
}
