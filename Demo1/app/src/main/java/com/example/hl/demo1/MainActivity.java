package com.example.hl.demo1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button=new Button(this);

        button.setBackgroundColor(Color.RED);
        button.setText("Hello");
        //ConstraintLayout.LayoutParams params1= new ConstraintLayout.LayoutParams(100,100);

        LinearLayout.LayoutParams params2= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        button.setLayoutParams(params2);

        ViewGroup viewGroup=(ViewGroup) LayoutInflater.from(this).inflate(R.layout.layout_main,null);
        //View viewGroup=findViewById(R.id.xxxx);
        viewGroup.addView(button);
        setContentView(viewGroup);//notice；不能为R.layout.layout_main






    }
}
