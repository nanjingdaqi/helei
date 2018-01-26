package com.example.hl.week3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;


public class AIDLService extends Service {

    public void onCreate() {
        super.onCreate();
        System.out.println("on create....");
    }

    //向客户端公开接口
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("on bind....");
        return mBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("on un bind...............");
        return super.onUnbind(intent);
    }


    //接口的实现
    private final S.Stub mBinder = new S.Stub() {

        @Override
        public int getPid() throws RemoteException {
            System.out.println("get pid Thread: " + Thread.currentThread().getName());
            System.out.println("DDService getPid ");
            return 0;
        }

    };
}