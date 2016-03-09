package cafetcraftteam.rpgsoftware.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Gautier on 03/03/2016.
 */
public class Utils
{
    public static String readFile(Context context, int resourcesId)
    {
        InputStream inputStream = context.getResources().openRawResource(resourcesId);
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        try
        {
            // do reading, usually loop until end of file reading
            while ((line = bufferedReader.readLine()) != null)
            {
                //process line
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e)
        {
            //log the exception
            e.printStackTrace();
            return null;
        }

        return stringBuilder.toString();
    }
}
