package com.bubbles.storageinfo;

/**
 * Created by Bonnette on 1/15/2015.
 */


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final int[] imgid;

    public CustomListAdapter(Activity context, String[] itemname, int[] imgid) {
        super(context, R.layout.simplerow, itemname);

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        if(convertView == null){ // This saves memory
        convertView =inflater.inflate(R.layout.simplerow, parent, false);
        }

        TextView txtTitle = convertView.findViewById(R.id.hparrayname);
        ImageView imageView = convertView.findViewById(R.id.hparraypic);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        return convertView;

    }

}
