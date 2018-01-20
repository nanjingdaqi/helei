package com.example.hl.week2;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    private Handler mHandler = new Handler();

    public MyIntentService() {
        super("MyIntentService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyIntentService.this, Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("ServiceOne", Thread.currentThread().getName());
    }




}
