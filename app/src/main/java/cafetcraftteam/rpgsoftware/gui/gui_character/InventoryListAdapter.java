package cafetcraftteam.rpgsoftware.gui.gui_character;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pujima on 15/02/2016.
 */
public class InventoryListAdapter implements BaseAdapter {

    private static final String TAG = "InventoryListAdapter";

    private Context mContext;               // the context where the adapter is used
    private List<Equipment> mInventory;            // the events at the current day

    public EventListViewAdapter(Context context, List<Equipment> inventory) {
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
        return  mInventory.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;

        if (rootView == null) {
            LayoutInflater inflater = (LayoutInflater.from(mContext));
            rootView = inflater.inflate(R.layout.list_event, parent, false);
        }

        if (mInventory != null) {
            // setting the title of the event as the text in the list
            TextView titleText = (TextView) rootView.findViewById(R.id.list_event_title);
            titleText.setText(mInventory.get(position).getTitle());

            // setting a default image as the image in the list
            ImageView imageView = (ImageView) rootView.findViewById(R.id.list_event_image);
            imageView.setImageBitmap(mInventory.get(position).getPicture());
            //imageView.setImageResource(R.drawable.basket);
        }

        return rootView;
    }
}