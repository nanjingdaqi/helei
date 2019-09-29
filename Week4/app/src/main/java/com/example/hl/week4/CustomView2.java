package com.example.hl.week4;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView2 extends View  {

    public CustomView2(Context context, AttributeSet attrs){
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.test);

        String text = ta.getString(R.styleable.test_testAttr);
        int textAttr = ta.getInteger(R.styleable.test_text, -1);
        Log.e("hl.week4.CustomView2", "text = " + text + " , textAttr = " + textAttr);

        ta.recycle();

    }




}
