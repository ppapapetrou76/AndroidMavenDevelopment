package com.packt.androidMaven.tests;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import com.packt.androidMaven.BookActivity;
import com.packt.androidMaven.R;

public class BookActivityTest extends ActivityUnitTestCase<BookActivity> {

    BookActivity bookActivity;

    private TextView textView;
    private Button button;

    public BookActivityTest() {
        super(BookActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        startActivity(new Intent(getInstrumentation().getTargetContext(), BookActivity.class), null, null);
        bookActivity = (BookActivity) getActivity();
        textView = (TextView) bookActivity.findViewById(R.id.text1);
        button = (Button) bookActivity.findViewById(R.id.button1);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void testPreconditions() {
        assertNotNull(button);
        assertNotNull(textView);
    }

    @SmallTest
    public void testButtonLabel() {
        String actual = button.getText().toString();
        String expected = "View Author Name!";

        assertEquals(expected, actual);
    }

    @SmallTest
    public void testTextViewText() {
        String actual = textView.getText().toString();
        String expected = "Book{id=null, title='Maven and Android', format='eBook', color='black', numberOfPages=150, brandNew=null}";
        assertEquals(expected, actual);
    }
}