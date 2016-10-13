package com.example.minh.getdata;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Minh on 10/13/2016.
 */
public class Adapter extends ArrayAdapter<Item>{


    public Adapter(Context context, int resource, Item[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(R.layout.listview_customization, parent, false);

        Item item = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tv_body);
        TextView tvUserId = (TextView) convertView.findViewById(R.id.tv_userid);

        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());
        tvUserId.setText(item.getUserId());


        return convertView;
    }
}
