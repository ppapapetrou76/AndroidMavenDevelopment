package com.packt.androidmaven.common;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FreeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("Hey I'm a free activity!");

        setContentView(textView);
    }
}
