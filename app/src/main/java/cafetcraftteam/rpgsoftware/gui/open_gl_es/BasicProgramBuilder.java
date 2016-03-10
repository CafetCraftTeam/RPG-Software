package cafetcraftteam.rpgsoftware.gui.open_gl_es;

import android.content.Context;

/**
 * Created by Tago on 02/03/2016.
 */
public class BasicProgramBuilder implements ProgramBuilder {

    private final Context mContext;

    public BasicProgramBuilder(Context context) {
        mContext = context;
    }

    @Override
    public Program build() {
        return new BasicProgram(mContext);
    }
}
