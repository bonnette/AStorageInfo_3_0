package com.bubbles.storageinfo;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends ListActivity {


    String[] hparrays = new String[] { "HPE StoreServ 20000", "HPE StoreServ 9000","HPE StoreServ 8000", "HPE Nimble",
            "HPE MSA", "HPE Software Defined Storage", "HPE SimpliVity", "HPE StoreEasy 3000", "HPE StoreEasy 1000", "HPE StoreOnce 6600", "HPE StoreOnce 5000",
            "HPE StoreOnce 3000", "HPE TFinity Tape Library", "HPE T950 Tape Library", "HPE StoreEver MSL", "HPE Tape"};

    // Array of integers points to images stored in /res/drawable-hdpi/
    int[] arrayImg = new int[]{
            R.drawable.ss20800,
            R.drawable.ss9000,
            R.drawable.ss8000,
            R.drawable.nimble,
            R.drawable.p2000,
            R.drawable.sds,
            R.drawable.simpliv,
            R.drawable.se3000,
            R.drawable.se1000,
            R.drawable.so6000,
            R.drawable.so5000,
            R.drawable.so3000,
            R.drawable.tfin,
            R.drawable.t950,
            R.drawable.mslimg,
            R.drawable.tapeimg
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomListAdapter adapter=new CustomListAdapter(this,hparrays,arrayImg );
        setListAdapter(adapter);
        ListView lv = getListView();

        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String product = (String) getListAdapter().getItem(position);

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), ArrayViewItem.class);
                // sending data to new activity
                i.putExtra("product", product);
                i.putExtra("productimg", position);
                startActivity(i);

            }
        });


    }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    return super.onCreateOptionsMenu(menu);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        Intent i = new Intent(getApplicationContext(), AboutPageView.class);
        startActivity(i);
                return super.onOptionsItemSelected(item);
    }

}
