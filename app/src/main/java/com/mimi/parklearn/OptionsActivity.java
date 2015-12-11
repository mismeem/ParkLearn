package com.mimi.parklearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class OptionsActivity extends AppCompatActivity {
    String id;
    String newString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    public void openWiki(View view){
        Intent intent = new Intent(this, WikiActivity.class);
        intent.putExtra("id", newString);
        startActivity(intent);
    }

    public void openMaps(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("id", newString);
        startActivity(intent);
    }
}
