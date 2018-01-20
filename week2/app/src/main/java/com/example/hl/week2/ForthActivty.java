package com.example.hl.week2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ForthActivty extends AppCompatActivity {

    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_four);



        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("content://com.example.hl.provider/score");
                ContentValues values=new ContentValues();
                values.put("name","zhangsan");
                values.put("score","78");
             Uri newUri=getContentResolver().insert(uri,values);
             newId=newUri.getPathSegments().get(1);
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("content://com.example.hl.provider/score");
                Cursor cursor=getContentResolver().query(uri,null,null,null,null);
                if(cursor!=null){

                    while (cursor.moveToNext()){
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        int score=cursor.getInt(cursor.getColumnIndex("score"));
                        Log.d("FA","name"+name);
                        Log.d("FA","score"+score);

                    }
                    cursor.close();
                }

            }
        });


    }
}
