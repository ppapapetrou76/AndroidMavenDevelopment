package com.packt.androidMaven.tests;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import com.packt.androidMaven.AuthorActivity;
import com.packt.androidMaven.BookActivity;
import com.packt.androidMaven.R;
import com.squareup.spoon.Spoon;
import static junit.framework.Assert.assertNotNull;

public class BookActivityTest extends ActivityInstrumentationTestCase2<BookActivity> {

    private BookActivity bookActivity;
    private Button button;

    public BookActivityTest() {
        super(BookActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        bookActivity = (BookActivity) getActivity();
        assertNotNull(bookActivity);
        button = (Button) bookActivity.findViewById(R.id.button1);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void testClickButton() {
        Spoon.screenshot(bookActivity, "Book_Activity_started");
        ActivityMonitor activityMonitor = getInstrumentation().addMonitor(AuthorActivity.class.getName(), null, false);
        bookActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });

        AuthorActivity authorActivity = (AuthorActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        assertNotNull(authorActivity);
        authorActivity.finish();
        Spoon.screenshot(authorActivity, "Author_Activity_opened");
    }

}