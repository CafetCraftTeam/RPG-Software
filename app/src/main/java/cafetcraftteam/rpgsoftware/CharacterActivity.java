package cafetcraftteam.rpgsoftware;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CharacterActivity extends AppCompatActivity {

    private static final String TAG = "CharacterActivity";
    private ViewPager mPager;
    private ViewPageAdapter mAdapter;

    private List<CharSequence> mTitles = new ArrayList<CharSequence>(
            Arrays.asList("General", "Inventory", "Skill"));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        // Creating the ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs.
        mAdapter = new ViewPageAdapter(getSupportFragmentManager(), mTitles);

        // Assigning ViewPager View and setting the adapter
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
    }

}
