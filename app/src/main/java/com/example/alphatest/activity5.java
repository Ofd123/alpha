package com.example.alphatest;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alphatest.Receivers.ChargerReceiver;
import com.example.alphatest.Receivers.allMsgsReceiver;

public class activity5 extends AppCompatActivity
{
    Button chargingbtn, broadcastbtn;
    Boolean chargeListen, broadcastListen;
    PackageManager packageManager;
    ComponentName componentName;
    TextView broadcasttv;
    allMsgsReceiver allMsgsReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity5);

        chargingbtn = findViewById(R.id.chargingbtn);
        broadcastbtn = findViewById(R.id.broadcastbtn);
        broadcasttv = findViewById(R.id.broadcasttv);


        packageManager = getPackageManager();
        componentName = new ComponentName(this, ChargerReceiver.class);
        chargeListen = false;
        broadcastListen = false;


    }

    public void toggleChargingToast(View view)
    {
        if(chargeListen)
        {
            packageManager.setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP
            );
            Toast.makeText(activity5.this, "ChargerReceiver Deactivated", Toast.LENGTH_SHORT).show();
            chargingbtn.setBackgroundColor(Color.GREEN);
            chargingbtn.setText("Activate ChargerReceiver");
        }
        else
        {
            packageManager.setComponentEnabledSetting(
                    componentName,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP
            );
            Toast.makeText(activity5.this, "ChargerReceiver Activated", Toast.LENGTH_SHORT).show();
            chargingbtn.setBackgroundColor(Color.RED);
            chargingbtn.setText("Deactivate ChargerReceiver");
        }
    }

    public void toggleBroadcastListening(View view)
    {
    }

    public void back(View view)
    {
    }
}