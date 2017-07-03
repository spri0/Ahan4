package edu.gsu.httpcs.testproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import edu.gsu.httpcs.testproject.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by spri0 on 6/21/17.
 */

public class ListNormalAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<String> list;
    private LayoutInflater inflater;

    public ListNormalAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_normal_item, parent, false);
        TextView tv = (TextView) convertView.findViewById(R.id.item_normal_tv);
        tv.setText(list.get(position));
        return tv;
    }
}
