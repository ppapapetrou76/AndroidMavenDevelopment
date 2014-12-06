package com.packt.androidmaven.common;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity {

    private Button button;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextValue();

        addListenerOnButton();
        addListenerOnPaidButton();
    }

    private void setTextValue() {
        textView = (TextView) findViewById(R.id.text1);
        textView.setText("Main Activity");
    }

    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FreeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnPaidButton() {
        button = (Button) findViewById(R.id.paidbutton);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.packt.paid.intent.action.Launch");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(view.getContext(), "You need to purchase the full version!", LENGTH_SHORT).show();
                }
            }
        });
    }
}
