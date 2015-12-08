package com.mimi.parklearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OptionsActivity extends AppCompatActivity {
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
    }

    public void openWiki(View view){
        Intent intent = new Intent(this, WikiActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void openMaps(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
