package com.packt.androidmaven.common;

import android.widget.Button;
import android.widget.TextView;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
        private MainActivity mainActivity;

    private Button button;
    private TextView textView;
    @Before
    public void init(){
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        textView = (TextView) mainActivity.findViewById(R.id.text1);
        button = (Button) mainActivity.findViewById(R.id.button1);
    }
    @Test
    public void testButtonLabel() {
        String actual = button.getText().toString();
        String expected = "View Free Activity!";
        assertThat(expected, equalTo(actual));
    }

    @Test
    public void testTextViewText() {
        String actual = textView.getText().toString();
        String expected = "Main Activity";
        assertThat(expected, equalTo(actual));
    }
    
}
