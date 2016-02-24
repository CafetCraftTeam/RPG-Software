package cafetcraftteam.rpgsoftware.gui.gui_character;

import android.graphics.drawable.Drawable;

/**
 * Created by Pujima on 22/02/2016.
 */
public class InventoryItem {
    public final Drawable mIcon;       // the drawable for the ListView item ImageView
    public final String mTitle;        // the text for the ListView item title
    public final String mDescription;  // the text for the ListView item description

    public InventoryItem(Drawable icon, String title, String mDescription) {
        this.mIcon = icon;
        this.mTitle = title;
        this.mDescription = mDescription;
    }
}