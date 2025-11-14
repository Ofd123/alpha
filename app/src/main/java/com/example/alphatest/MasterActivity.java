package com.example.alphatest;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alphatest.Receivers.ChargerReceiver;

public class MasterActivity extends AppCompatActivity
{
    PackageManager packageManager;
    ComponentName componentName;
    ChargerReceiver chargerReceiver;
    IntentFilter filter;
    protected Boolean chargeListen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        packageManager = getPackageManager();
        componentName = new ComponentName(this, ChargerReceiver.class);

        filter = new IntentFilter();
        filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");


        if(chargeListen == null)
        {
            chargerReceiver = new ChargerReceiver();
            chargeListen = false;
        }
    }
    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(chargerReceiver);
        chargeListen = false;
    }

    protected void continueListen()
    {
        registerReceiver(chargerReceiver, filter);
        Toast.makeText(MasterActivity.this, "ChargerReceiver Activated", Toast.LENGTH_SHORT).show();
        chargeListen = true;
    }

    protected void stopListen()
    {
        unregisterReceiver(chargerReceiver);
        Toast.makeText(MasterActivity.this, "ChargerReceiver Deactivated", Toast.LENGTH_SHORT).show();
        chargeListen = false;
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(android.view.MenuItem item)
    {
        String selected = item.getTitle().toString();
        Intent intent;
        switch (selected)
        {
            case "activity1": //login and show from FB-auth the user ID
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case "activity2": //write to a RTDatabase and show the input in a listView
                break;
            case "activity3": //save a picture from gallery in a firebase and show images from fireBase
                break;
            case "activity4": //save a picture from camera in a firebase and show images from fireBase
                break;
            case "activity5": //Broadcast Receiver
                intent = new Intent(this, activity5.class);
                startActivity(intent);
                break;
            case "activity6": // google maps
                break;
            case "activity7": //get data from a picture (gemini)
                break;
            case "activity8": //get data from a site (gemini)
                break;
        }
    return super.onOptionsItemSelected(item);
    }

}
