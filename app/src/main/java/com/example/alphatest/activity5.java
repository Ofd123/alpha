package com.example.alphatest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

public class activity5 extends MasterActivity
{
    Button activateBtn, deactivateBtn;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity5);

        activateBtn = findViewById(R.id.activateBRbtn);
        deactivateBtn = findViewById(R.id.DeactivateBRbtn);
    }


    public void ActivateBtn(View view)
    {
        if(!chargeListen)
        {
            continueListen();
        }
    }

    public void DeactivateBtn(View view)
    {
        if(chargeListen)
        {
            stopListen();
        }
    }
}