package com.mimi.parklearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class OptionsActivity extends AppCompatActivity {
    public static String id;
    String newString;

    /*
     * gets the intent from the previous activity which contains the button information
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        assert savedInstanceState != null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Intent intent = getIntent();

        id = intent.getStringExtra("id");



        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("id");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("id");
        }


        Log.v("the id", newString);
    }

    /*
     * uses the intent to open a wikipedia page
     */
    private Intent intent1, intent2;
    public void openWiki(View view){
        intent1 = new Intent(this, WikiActivity.class);
        intent1.putExtra("id", newString);
        startActivity(intent1);

        openedWikiOptions();
        assert wikiRepOK();

    }
    /*
     * uses the intent to open a googlemaps page
     */
    public void openMaps(View view){
        intent2 = new Intent(this, MapsActivity.class);
        intent2.putExtra("id", newString);
        startActivity(intent2);

        openedMapsOptions();
        assert mapsRepOK();
    }

    private boolean wikiRepOK(){
        return intent1 != null && intent1.hasExtra("id");
    }

    private boolean mapsRepOK(){
        return intent2 != null && intent2.hasExtra("id");
    }

    private void openedWikiOptions(){
        if (BuildConfig.DEBUG) {
            Log.d("this tag", intent1.getStringExtra("id"));
            Log.d("open", "opened WikiActivity");
        }
    }

    private void openedMapsOptions(){
        if (BuildConfig.DEBUG) {
            Log.d("this tag", intent2.getStringExtra("id"));
            Log.d("open", "opened MapsActivity");
        }
    }

}
