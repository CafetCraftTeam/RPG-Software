package cafetcraftteam.rpgsoftware.gui.gui_character;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cafetcraftteam.rpgsoftware.R;


public class CharacterInventoryFragment extends ListFragment {
    private List<InventoryItem> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<>();

        mItems.add(new InventoryItem(ContextCompat.getDrawable(getActivity(), R.drawable.weapon), "title", "description"));
        mItems.add(new InventoryItem(ContextCompat.getDrawable(getActivity(), R.drawable.armor), "title", "description"));
        mItems.add(new InventoryItem(ContextCompat.getDrawable(getActivity(), R.drawable.equipment), "title", "description"));


        // initialize and set the list adapter
        setListAdapter(new InventoryAdapter(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        InventoryItem item = mItems.get(position);

        // do something
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }
}