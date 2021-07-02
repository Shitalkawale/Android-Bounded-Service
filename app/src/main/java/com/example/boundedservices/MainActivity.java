package com.example.boundedservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Myservice myservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button(View view)
    {
        String no=myservice.getCurrentTime();
        TextView txt1=findViewById(R.id.output);
        txt1.setText(String.valueOf(no));
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Intent intent=new Intent(MainActivity.this,Myservice.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        unbindService(mConnection);
    }

    ServiceConnection mConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            Myservice.LocalService localService=(Myservice.LocalService)service;
            myservice=localService.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {

        }
    };
}