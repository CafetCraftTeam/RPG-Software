package cafetcraftteam.rpgsoftware.gui.gui_main_activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import cafetcraftteam.rpgsoftware.CharacterActivity;

/**
 * Created by defig on 23.02.2016.
 */
public class ButtonPersoListener implements View.OnClickListener {

    private final Activity mParentActivity;

    public ButtonPersoListener(Activity parentActivity) {
        mParentActivity = parentActivity;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mParentActivity, "Perso", Toast.LENGTH_SHORT).show();
        Intent intent_perso = new Intent(mParentActivity,CharacterActivity.class);
        mParentActivity.startActivity(intent_perso);
    }
}
