package cafetcraftteam.rpgsoftware;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cafetcraftteam.rpgsoftware.gui.gui_character.ViewPageAdapter;
import cafetcraftteam.rpgsoftware.gui.sliding_tab.SlidingTabLayout;


public class CharacterActivity extends AppCompatActivity {

    private static final String TAG = "CharacterActivity";
    private ViewPager mPager;
    private ViewPageAdapter mAdapter;
    private SlidingTabLayout mTabs;

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

        // Assigning the Sliding Tab Layout View
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setDistributeEvenly(true); // This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        mTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return ContextCompat.getColor(getApplicationContext(), R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        mTabs.setViewPager(mPager);
    }

}
