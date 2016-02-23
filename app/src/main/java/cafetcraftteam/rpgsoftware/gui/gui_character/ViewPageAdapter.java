package cafetcraftteam.rpgsoftware.gui.gui_character;

/**
 * Created by Pujima on 14/02/2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cafetcraftteam.rpgsoftware.gui.gui_character.CharacterGeneralFragment;
import cafetcraftteam.rpgsoftware.gui.gui_character.CharacterInventoryFragment;
import cafetcraftteam.rpgsoftware.gui.gui_character.CharacterSkillFragment;

/**
 * Fragment page adapter that holds the creation and management of the 3 main tabs
 */
public class ViewPageAdapter extends FragmentPagerAdapter {
    private List<CharSequence> mTitles; // This will Store the Titles of the Tabs

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPageAdapter(FragmentManager fragmentManager, List<CharSequence> titles) {
        super(fragmentManager);

        mTitles = titles;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CharacterGeneralFragment();
            case 2:
                return new CharacterSkillFragment();
            default:
                return new CharacterInventoryFragment();
        }
    }

    // This method return the Number of tabs for the tabs Strip
    @Override
    public int getCount() {
        return mTitles.size();
    }

    // This method return the titles for the Tabs in the CalendarTabs Strip
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}


