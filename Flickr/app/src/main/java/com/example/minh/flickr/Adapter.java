package com.example.minh.flickr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by Minh on 10/13/2016.
 */
public class Adapter extends ArrayAdapter<FlickrItem> {


    public Adapter(Context context, int resource, List<FlickrItem> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(R.layout.listview_customization, parent, false);

        FlickrItem item = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tv_date);
        TextView tvLink = (TextView) convertView.findViewById(R.id.tv_link);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.iv_photo);

        tvTitle.setText(item.getTitle());
        tvDate.setText(item.getDateTaken());
        tvLink.setText(item.getLink());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext()).build();
        ImageLoader.getInstance().init(config);
        ImageLoader.getInstance().displayImage(item.getImageLink(), ivPhoto);

        return convertView;
    }
}
