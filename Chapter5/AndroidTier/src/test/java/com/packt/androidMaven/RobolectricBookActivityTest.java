
package com.packt.androidMaven;

import android.widget.Button;
import android.widget.TextView;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class RobolectricBookActivityTest {

    private BookActivity bookActivity;

    private TextView textView;
    private Button button;
    
    @Before
    public void init(){
        bookActivity = Robolectric.buildActivity(BookActivity.class).create().get();
        textView = (TextView) bookActivity.findViewById(R.id.text1);
        button = (Button) bookActivity.findViewById(R.id.button1);
    }
        
    @Test
    public void testButtonLabel() {
        String actual = button.getText().toString();
        String expected = "View Author Name!";
        assertThat(expected, equalTo(actual));
    }

    @Test
    public void testTextViewText() {
        String actual = textView.getText().toString();
        String expected = "Book{id=null, title='Maven and Android', format='eBook', color='black', numberOfPages=150, brandNew=null}";
        assertThat(expected, equalTo(actual));
    }
}
