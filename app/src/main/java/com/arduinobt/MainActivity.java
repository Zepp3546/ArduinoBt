package com.arduinobt;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // is this what i need

    //MenuItem item = menu.findItem(<id>);
    //item.setVisible(<true/false>);




    // called when user clicks gotoanalog button

    public void goToAnalog(View view) {
        Intent myintent = new Intent(this, AnalogDisplayActivity.class);
        startActivity(myintent);
        // any other stuff to do ?

    }

    public void clickAtThing (View view){


        Snackbar.make(view, "Clicky!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }




    public void bignasty( View view) {
        ImageView puspic = (ImageView) findViewById(R.id.imageView1);
        puspic.setVisibility(View.VISIBLE);

    }




}






