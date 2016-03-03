package cafetcraftteam.rpgsoftware.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gautier on 03/03/2016.
 */
public class Tools
{
    public static String readFile(String path, Context context)
    {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try
        {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(path)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null)
            {
                //process line
                builder.append(mLine);
            }
        } catch (IOException e)
        {
            //log the exception
        } finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                } catch (IOException e)
                {
                    //log the exception
                    e.printStackTrace();
                }
            }
        }

        return builder.toString();
    }
}
