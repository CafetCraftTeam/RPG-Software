package cafetcraftteam.rpgsoftware.gui.gui_character;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cafetcraftteam.rpgsoftware.R;


public class CharacterInventoryFragment extends ListFragment {
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_inventory, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        mEventListAdapter = new EventListViewAdapter(view.getContext(),
                new ArrayList<String>(0), getActivity());
        listView.setAdapter(mEventListAdapter);
        listView.setOnItemClickListener(mEventListAdapter);

        mBaseView = view;
        refresh();

        return view;
    }
}
