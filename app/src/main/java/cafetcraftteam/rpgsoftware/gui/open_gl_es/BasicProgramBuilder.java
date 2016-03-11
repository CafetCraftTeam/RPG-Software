package cafetcraftteam.rpgsoftware.gui.open_gl_es;

/**
 * Created by Tago on 02/03/2016.
 */
public class BasicProgramBuilder implements ProgramBuilder {

    @Override
    public Program build() {
        return new BasicProgram();
    }
}
