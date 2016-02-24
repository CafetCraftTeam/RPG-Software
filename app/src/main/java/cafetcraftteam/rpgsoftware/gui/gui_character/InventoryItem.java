package cafetcraftteam.rpgsoftware.gui.gui_character;

import android.graphics.drawable.Drawable;

/**
 * Created by Pujima on 22/02/2016.
 */
public class InventoryItem {
    public final Drawable icon;       // the drawable for the ListView item ImageView
    public final String title;        // the text for the ListView item title
    public final String description;  // the text for the ListView item description

    public InventoryItem(Drawable icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }
}