package com.example.hl.week2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ServiceOne extends Service {
    public ServiceOne() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void onCreate(){




        Toast.makeText(this,Thread.currentThread().getName(),Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            public void run() {
                Log.d ("ServiceOne",Thread.currentThread().getName() );
                try {
                    Thread.sleep(5000);
                    Log.d ("ServiceOne",Thread.currentThread().getName() );
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }
        }).start();



    }

    /*private void doSth(long tm) {
        long ctm = System.currentTimeMillis();
        while (System.currentTimeMillis() - ctm < tm * 1000) {

        }
    }
*/
}
