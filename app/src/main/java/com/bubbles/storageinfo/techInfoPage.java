package com.bubbles.storageinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;

/**
 * Created by bonnette on 1/19/2015.
 */
public class techInfoPage extends Activity {
    private WebView webview;

    String[] InfoArrays = new String[] { "ss20800Info.html", "ss9000Info.html","ss8000Info.html", "nimbleInfo.html",
            "p2000Info.html", "sdsInfo.html", "simplivInfo.html", "se3000Info.html", "se1000Info.html", "so6000Info.html", "so5000Info.html",
            "so3000Info.html", "tfinInfo.html", "t950Info.html", "mslInfo.html", "tapeInfo.html"};

    String[] PtsArrays = new String[] { "ss20800Pts.html","ss9000Pts.html","ss8000Pts.html", "nimblePts.html",
            "p2000Pts.html", "sdsPts.html", "simplivPts.html", "se3000Pts.html", "se1000Pts.html", "so6000Pts.html", "so5000Pts.html",
            "so3000Pts.html", "tfinPts.html", "t950Pts.html", "mslPts.html", "tapePts.html"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.techinfopage);
        Intent i=getIntent();
        final int whichArray = i.getIntExtra("mouse", 0);
        final int whichbutton = i.getIntExtra("whichButton",0);
//Log.d("hello",""+whichbutton);

        webview = this.findViewById(R.id.webView);
if (whichbutton == 1) {
    webview.loadUrl("file:///android_asset/" + InfoArrays[whichArray]);
}   else {webview.loadUrl("file:///android_asset/" + PtsArrays[whichArray]);}
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
        //Intent i = new Intent(getApplicationContext(), ArrayViewItem.class);
        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
