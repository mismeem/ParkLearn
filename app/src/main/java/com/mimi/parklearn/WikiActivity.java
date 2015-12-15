package com.mimi.parklearn;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

/*
 * gets the intent from the last activity which contains the appropriate park name string
 * opens a webview of the corresponding wikipedia page
 */
public class WikiActivity extends AppCompatActivity {
    Button clicked;
    String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        assert savedInstanceState != null;

        super.onCreate(savedInstanceState);
        WebView webview = new WebView(this);
        setContentView(webview);
        Intent intent = getIntent();
        String ID = intent.getStringExtra("id");

        Log.d("wiki id", ID);

        String forlink = "";
        for (int i = 0; i < ID.length(); i++) {
            if (ID.charAt(i) == ' ') {
                forlink = forlink + '_';
            } else {
                forlink = forlink + ID.charAt(i);
            }
        }
        String url = "https://en.wikipedia.org/wiki/";


        Uri uri = Uri.parse(url + forlink);
        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent1);
        webview.loadUrl(url + forlink);

        checkOpenedWikipedia(url, ID);

    }

    private void checkOpenedWikipedia(String url, String ID){
        if(BuildConfig.DEBUG){
            Log.d("wiki url", url+ID);
        }
    }

}