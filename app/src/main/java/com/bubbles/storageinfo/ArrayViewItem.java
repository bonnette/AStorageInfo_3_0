package com.bubbles.storageinfo;

/**
 * Created by bonnette on 1/18/2015.
 */



        import android.app.Activity;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TextView;
        import com.polites.android.*;



public class ArrayViewItem extends Activity{
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
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.arraylistviewitem);
            TextView txtProduct = findViewById(R.id.product_label);
            GestureImageView imgProduct = findViewById(R.id.product_view);
            Intent i = getIntent();

            // getting attached intent data
            String product = i.getStringExtra("product");
            final int pic = i.getIntExtra("productimg", 0);


            // displaying selected product name
            txtProduct.setText(product);
            imgProduct.setImageResource(arrayImg[pic]);

            final TextView infoclass = findViewById(R.id.info);
            infoclass.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    infoclass.setTextColor(Color.rgb(255, 0, 0)); //blink the selected text
                    Intent Intent = new Intent(view.getContext(), techInfoPage.class);
                    Intent.putExtra("mouse",pic);
                    Intent.putExtra("whichButton",1);
                    startActivity(Intent);

                }

            });

            final TextView techclass = findViewById(R.id.tech);
            techclass.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    techclass.setTextColor(Color.rgb(255,0,0));
                    Intent Intent = new Intent(view.getContext(), techInfoPage.class);
                    Intent.putExtra("mouse",pic);
                    Intent.putExtra("whichButton",2);
                    startActivity(Intent);

                }

            });
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.back_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        //Intent i = new Intent(getApplicationContext(), MainActivity.class);
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    }

