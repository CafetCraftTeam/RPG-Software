package cafetcraftteam.rpgsoftware.gui.gui_main_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import cafetcraftteam.rpgsoftware.R;
import cafetcraftteam.rpgsoftware.gui.DiceActivity;
import cafetcraftteam.rpgsoftware.gui.PersoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_des = (Button)findViewById(R.id.button_des);
        Button button_perso = (Button)findViewById(R.id.button_perso);

        button_des.setOnClickListener(new ButtonActivityListener(this, DiceActivity.class));

        button_perso.setOnClickListener(new ButtonActivityListener(this, PersoActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
