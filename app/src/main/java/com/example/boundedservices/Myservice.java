package com.example.boundedservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Myservice extends Service
{

    class LocalService extends Binder
    {
        Myservice getService()
        {
            return  Myservice.this;
        }
    }

    IBinder binder=new LocalService();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public String getCurrentTime()
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US);
        return (dateFormat.format(new Date()));
    }



}
