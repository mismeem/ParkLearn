package com.mimi.parklearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class ParkListActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_list);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        final Button button0 = (Button) findViewById(R.id.button_RMNP);
        button0.setOnClickListener(this);

        final Button button1 = (Button) findViewById(R.id.button_hotsprings);
        button1.setOnClickListener(this);

        final Button button2 = (Button) findViewById(R.id.button_roosevelt);
        button2.setOnClickListener(this);

        final Button button3 = (Button) findViewById(R.id.button_craterlake);
        button3.setOnClickListener(this);

        final Button button4 = (Button) findViewById(R.id.button_windcave);
        button4.setOnClickListener(this);

        final Button button5 = (Button) findViewById(R.id.button_bigbend);
        button5.setOnClickListener(this);

        final Button button6 = (Button) findViewById(R.id.button_shenandoah);
        button6.setOnClickListener(this);

        final Button button7 = (Button) findViewById(R.id.button_arches);
        button7.setOnClickListener(this);

        final Button button8 = (Button) findViewById(R.id.button_rainier);
        button8.setOnClickListener(this);

        final Button button9 = (Button) findViewById(R.id.button_smokymountains);
        button9.setOnClickListener(this);

        final Button button10 = (Button) findViewById(R.id.button_joshuatree);
        button10.setOnClickListener(this);

        final Button button11 = (Button) findViewById(R.id.button_glacier);
        button11.setOnClickListener(this);

        final Button button12 = (Button) findViewById(R.id.button_mesaverde);
        button12.setOnClickListener(this);

        final Button button13 = (Button) findViewById(R.id.button_olympic);
        button13.setOnClickListener(this);

        final Button button14 = (Button) findViewById(R.id.button_petrifiedforest);
        button14.setOnClickListener(this);

        final Button button15 = (Button) findViewById(R.id.button_acadia);
        button15.setOnClickListener(this);

        final Button button16 = (Button) findViewById(R.id.button_sequoia);
        button16.setOnClickListener(this);

        final Button button17 = (Button) findViewById(R.id.button_zion);
        button17.setOnClickListener(this);

        final Button button18 = (Button) findViewById(R.id.button_everglades);
        button18.setOnClickListener(this);

        final Button button19 = (Button) findViewById(R.id.button_denali);
        button19.setOnClickListener(this);

        final Button button20 = (Button) findViewById(R.id.button_deathvalley);
        button20.setOnClickListener(this);

        final Button button21 = (Button) findViewById(R.id.button_yosemite);
        button21.setOnClickListener(this);

        final Button button22 = (Button) findViewById(R.id.button_grandcanyon);
        button22.setOnClickListener(this);

        final Button button23 = (Button) findViewById(R.id.button_hawaii);
        button23.setOnClickListener(this);

        final Button button24 = (Button) findViewById(R.id.button_yellowstone);
        button24.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, OptionsActivity.class);
        CharSequence cs = ((Button) view).getText();
        Log.v("this tag", cs.toString());
        intent.putExtra("id", cs.toString());
        startActivity(intent);
        
    }

}
