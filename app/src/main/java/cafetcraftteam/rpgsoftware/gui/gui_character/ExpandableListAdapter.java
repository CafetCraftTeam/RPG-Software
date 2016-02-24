package cafetcraftteam.rpgsoftware.gui.gui_character;

/**
 * Created by Pujima on 22/02/2016.
 */

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import cafetcraftteam.rpgsoftware.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private final LayoutInflater mInf;
    private String[] mGroups;
    private String[][] mChildren;

    public ExpandableListAdapter(Context context,String[] groups, String[][] children) {
        this.context = context;
        this.mGroups = groups;
        this.mChildren = children;
        mInf = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mGroups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildren[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChildren[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = mInf.inflate(R.layout.list_skill_item, parent, false);
            holder = new ViewHolder();

            holder.text = (TextView) convertView.findViewById(R.id.lblListItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(getChild(groupPosition, childPosition).toString());

        return convertView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInf.inflate(R.layout.list_skill_group, parent, false);

            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.lblListHeader);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(getGroup(groupPosition).toString());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class ViewHolder {
        TextView text;
    }

}