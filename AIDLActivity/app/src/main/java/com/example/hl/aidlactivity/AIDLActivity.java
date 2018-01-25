package com.example.hl.aidlactivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hl.week3.S;

public class AIDLActivity extends AppCompatActivity {
    S binder;
    private Context mContext= getApplicationContext();;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aidl);
      //  Intent mIntent = new Intent(this, AIDLService.class);
       Intent mIntent = new Intent();
       mIntent.setAction("com.example.hl.week3.AIDLService");

        mIntent.setPackage("com.example.hl.week3");
        bindService(mIntent, connection, BIND_AUTO_CREATE);


        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(binder == null){
                        return;
                    }
                    int pid = binder.getPid();
                    Log.d("TAG","0");

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("disconnect....thread:"+Thread.currentThread().getName());
            binder = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("connect.....thread:"+Thread.currentThread().getName());

            binder = S.Stub.asInterface(service);
        }
    };

    @Override
    protected void onDestroy() {
        unbindService(connection);
        super.onDestroy();
        System.out.println("on destory.....");
    }




}
