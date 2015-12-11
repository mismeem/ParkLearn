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

public class WikiActivity extends AppCompatActivity {
    Button clicked;
    String ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webview = new WebView(this);
        setContentView(webview);
        Intent intent = getIntent();
        String ID = intent.getStringExtra("id");
        Log.v("wiki id", ID);

/*
        if(ID.equals(R.string.button_acadia)){
            clicked = (Button) findViewById(R.id.button_acadia);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_arches)){
            clicked = (Button) findViewById(R.id.button_arches);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_bigbend)){
            clicked = (Button) findViewById(R.id.button_bigbend);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_craterlake)){
            clicked = (Button) findViewById(R.id.button_craterlake);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_deathvalley)){
            clicked = (Button) findViewById(R.id.button_deathvalley);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_denali)){
            clicked = (Button) findViewById(R.id.button_denali);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_everglades)){
            clicked = (Button) findViewById(R.id.button_everglades);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_glacier)){
            clicked = (Button) findViewById(R.id.button_glacier);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_grandcanyon)){
            clicked = (Button) findViewById(R.id.button_grandcanyon);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_hawaii)){
            clicked = (Button) findViewById(R.id.button_hawaii);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_hotsprings)){
            clicked = (Button) findViewById(R.id.button_hotsprings);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_joshuatree)){
            clicked = (Button) findViewById(R.id.button_joshuatree);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_mesaverde)){
            clicked = (Button) findViewById(R.id.button_mesaverde);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_olympic)){
            clicked = (Button) findViewById(R.id.button_olympic);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_petrifiedforest)){
            clicked = (Button) findViewById(R.id.button_petrifiedforest);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_rainier)){
            clicked = (Button) findViewById(R.id.button_rainier);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_roosevelt)){
            clicked = (Button) findViewById(R.id.button_roosevelt);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_RMNP)){
            clicked = (Button) findViewById(R.id.button_RMNP);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_sequoia)){
            clicked = (Button) findViewById(R.id.button_sequoia);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_shenandoah)){
            clicked = (Button) findViewById(R.id.button_shenandoah);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_smokymountains)){
            clicked = (Button) findViewById(R.id.button_smokymountains);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_windcave)){
            clicked = (Button) findViewById(R.id.button_windcave);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_yellowstone)){
            clicked = (Button) findViewById(R.id.button_yellowstone);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_yosemite)){
            clicked = (Button) findViewById(R.id.button_yosemite);
        }
        else if(intent.getStringExtra("id").equals(R.id.button_zion)){
            clicked = (Button) findViewById(R.id.button_zion);
        }*/
        //String name = (String) clicked.getText();

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
        
    }

}