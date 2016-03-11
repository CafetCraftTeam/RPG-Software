package cafetcraftteam.rpgsoftware.utils_test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.io.IOException;

import cafetcraftteam.rpgsoftware.utils.Utils;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by Gautier on 11/03/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UtilsTest {
    @Test
    public void readFileWithoutContext() {

        // read a simple file (just one line)
        String simpleFilePath = "simple.test";
        try {
            assertEquals("Only for the test\n", Utils.readFile(simpleFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            fail("The lecture of the file throw an exception");
        }

        // trying to read a file that doesn't exist throw an exception
        String noFilePath = "noFile";
        try {
            Utils.readFile(noFilePath);
        } catch (FileNotFoundException e) {
            assertEquals("The file have not been found : " + noFilePath, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // reading a multiple line file
        String multipleLineFilePath = "multiple.test";
        try {
            assertEquals("Just\nfor\ntesting\non\nmultiple\nlines\n",
                    Utils.readFile(multipleLineFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            fail("reading a multiple line file as throw an exception");
        }

        // reading an empty file
        String emptyFilePath = "empty.test";
        try {
            assertEquals("",
                    Utils.readFile(emptyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            fail("reading an empty file as throw an exception");
        }
    }
}
