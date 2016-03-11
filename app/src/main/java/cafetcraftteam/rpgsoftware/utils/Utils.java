package cafetcraftteam.rpgsoftware.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Gautier on 03/03/2016.
 */
public class Utils {
    public static String readFile(Context context, int resourcesId) {
        InputStream inputStream = context.getResources().openRawResource(resourcesId);
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            // do reading, usually loop until end of file reading
            while ((line = bufferedReader.readLine()) != null) {
                //process line
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            //log the exception
            e.printStackTrace();
            return null;
        }

        return stringBuilder.toString();
    }

    /**
     * Read a file in the resources directory at the given file path. Return this file as a string
     * @param filePath the path to the file within the resources directory
     * @return A string containing all the file
     * @throws IOException if the asked file is not found throw an FileNotFoundException, if there
     * some problem during the lecture of the file throw an IOException
     */
    public static String readFile(String filePath) throws IOException {
        ClassLoader classLoader = Utils.class.getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new FileNotFoundException("The file have not been found : " + filePath);
        }
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            // do reading, usually loop until end of file reading
            while ((line = bufferedReader.readLine()) != null) {
                //process line
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            bufferedReader.close();
            reader.close();
            inputStream.close();
        }

        return stringBuilder.toString();
    }
}
