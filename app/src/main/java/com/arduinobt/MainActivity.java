package com.arduinobt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.AbstractList;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 3;
    public BluetoothAdapter mBluetoothAdapter;
    public ArrayAdapter mArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }













    // called when user clicks gotoanalog button

    public void goToAnalog(View view) {
        Intent myintent = new Intent(this, AnalogDisplayActivity.class);
        startActivity(myintent);
        // any other stuff to do ?
        Toast.makeText(getApplicationContext(),"Going To Analog Interface", Toast.LENGTH_SHORT).show();



}

    public void clickAtThing (View view){


        Snackbar.make(view, "Clicky!", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();

    }



    public void pair (final View view) {

        new Thread(new Runnable() {
            public void run() {
                Snackbar.make(view, "Checking Bluetooth Eligibility", Snackbar.LENGTH_SHORT)
                        .setAction("Action",null).show();

                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    // Device does not support Bluetooth
                    Snackbar.make(view, "No Bluetooth Adapter Detected", Snackbar.LENGTH_SHORT)
                       .setAction("Action", null).show();

                }
                else

                    Snackbar.make(view, "Bluetooth Adapter Detected", Snackbar.LENGTH_SHORT)
                            .setAction("Action",null).show();
                if (!mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                    Snackbar.make(view, "Enabling Bluetooth Adapter", Snackbar.LENGTH_SHORT)
                            .setAction("Action",null).show();

                }
                else
                    Snackbar.make(view,"Bluetooth Adapter Enabled",Snackbar.LENGTH_SHORT)
                            .setAction("Action",null).show();

            }
        }).start();

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
// If there are paired devices
        if (pairedDevices.size() > 0) {
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                // Add the name and address to an array adapter to show in a ListView
                mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        }



    }










}






