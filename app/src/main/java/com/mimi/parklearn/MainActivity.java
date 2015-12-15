package com.mimi.parklearn;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button2;

    /*
    * This method creates the startup window
    * it adds in a button which will lead to the Park list activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        assert savedInstanceState == null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = (Button) findViewById(R.id.button2);

        assert repOK();
    }

    //when button is clicked, opens ParkListActivity
    public void openParkList(View view){
        Intent intent = new Intent(this, ParkListActivity.class);
        startActivity(intent);

        openedtest();

    }

    private void openedtest(){
        if (BuildConfig.DEBUG) {
            Log.d("open", "opened ParkListActivity");
        }
    }

    private boolean repOK(){
        return button2.isClickable();
    }

}
