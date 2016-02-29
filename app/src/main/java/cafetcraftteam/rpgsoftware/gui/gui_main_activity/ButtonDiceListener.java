package cafetcraftteam.rpgsoftware.gui.gui_main_activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import cafetcraftteam.rpgsoftware.DiceActivity;

/**
 * Created by defig on 23.02.2016.
 */
public class ButtonDiceListener implements View.OnClickListener {
    private Activity mParentActivity;

    public ButtonDiceListener(Activity parent_activity){
        mParentActivity = parent_activity;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mParentActivity, "Dice", Toast.LENGTH_SHORT).show();
        Intent intent_dice = new Intent(mParentActivity,DiceActivity.class);
        mParentActivity.startActivity(intent_dice);
    }


}
