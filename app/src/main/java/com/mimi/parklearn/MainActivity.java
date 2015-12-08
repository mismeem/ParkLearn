package com.mimi.parklearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openParkList(View view){
        Intent intent = new Intent(this, ParkListActivity.class);
        startActivity(intent);
    }
}
