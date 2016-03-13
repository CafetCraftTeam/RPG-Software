package cafetcraftteam.rpgsoftware.gui.gui_main_activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by defig on 23.02.2016.
 */
public class ButtonActivityListener implements View.OnClickListener {
    private final Activity mParentActivity;
    private final Class mActivityLaunchedClass;

    public ButtonActivityListener(Activity parent_activity, Class activityLaunchedClass){
        mParentActivity = parent_activity;
        mActivityLaunchedClass = activityLaunchedClass;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mParentActivity, "Opening New Activity...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mParentActivity,mActivityLaunchedClass);
        mParentActivity.startActivity(intent);
    }

}
