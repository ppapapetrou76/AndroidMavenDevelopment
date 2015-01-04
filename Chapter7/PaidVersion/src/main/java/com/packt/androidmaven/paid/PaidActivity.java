package com.packt.androidmaven.paid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PaidActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("Thank you for purchasing my app!");

        setContentView(textView);
    }
}
