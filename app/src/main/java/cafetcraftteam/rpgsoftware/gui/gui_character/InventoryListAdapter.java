package cafetcraftteam.rpgsoftware.gui.gui_character;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cafetcraftteam.rpgsoftware.R;


/**
 * Created by Pujima on 15/02/2016.
 */
public class InventoryListAdapter extends BaseAdapter
{
    private class Equipment {

        public String getName()
        {
            return "name";
        }
    }

    private static final String TAG = "InventoryListAdapter";

    private Context mContext;               // the context where the adapter is used
    private List<Equipment> mInventory;            // the events at the current day

    public InventoryListAdapter(Context context, List<Equipment> inventory) {
        super();

        mContext = context;
        mInventory = inventory;
    }

    @Override
    public int getCount() {
        if (mInventory != null) {
            return mInventory.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return  mInventory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  mInventory.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;

        if (rootView == null) {
            LayoutInflater inflater = (LayoutInflater.from(mContext));
            rootView = inflater.inflate(R.layout.list_inventory, parent, false);
        }

        if (mInventory != null) {
            // setting the title of the event as the text in the list
            TextView titleText = (TextView) rootView.findViewById(R.id.list_inventory_name);
            titleText.setText(mInventory.get(position).getName());

            /*
            // setting a default image as the image in the list
            ImageView imageView = (ImageView) rootView.findViewById(R.id.list_event_image);
            imageView.setImageBitmap(mInventory.get(position).getPicture());
            //imageView.setImageResource(R.drawable.basket);
            */
        }

        return rootView;
    }
}