package cafetcraftteam.rpgsoftware.utils_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import cafetcraftteam.rpgsoftware.R;
import cafetcraftteam.rpgsoftware.utils.Utils;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Gautier on 11/03/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UtilsTest {
    private static final String FILE_NAME = "test.txt";

    @Test
    public void readFileWithoutContext() throws IOException {
        assertEquals("Only for the test\n", Utils.readFile(FILE_NAME));
    }
}
