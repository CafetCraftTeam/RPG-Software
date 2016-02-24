package cafetcraftteam.rpgsoftware.gui.gui_character;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cafetcraftteam.rpgsoftware.R;

/**
 * Created by Pujima on 22/02/2016.
 */
public class InventoryAdapter extends ArrayAdapter<InventoryItem> {

    public InventoryAdapter(Context context, List<InventoryItem> items) {
        super(context, R.layout.list_inventory_item, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_inventory_item, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.mIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            viewHolder.mTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.mDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        InventoryItem item = getItem(position);
        viewHolder.mIcon.setImageDrawable(item.mIcon);
        viewHolder.mTitle.setText(item.mTitle);
        viewHolder.mDescription.setText(item.mDescription);

        return convertView;
    }

    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     *
     *
     */
    private static class ViewHolder {
        ImageView mIcon;
        TextView mTitle;
        TextView mDescription;
    }
}
