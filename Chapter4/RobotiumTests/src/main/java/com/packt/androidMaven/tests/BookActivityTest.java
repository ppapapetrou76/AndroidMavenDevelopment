package com.packt.androidMaven.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import com.packt.androidMaven.AuthorActivity;
import com.packt.androidMaven.BookActivity;
import com.robotium.solo.Solo;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class BookActivityTest extends ActivityInstrumentationTestCase2<BookActivity> {

    private Solo solo;

    public BookActivityTest() {
        super(BookActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    @SmallTest
    public void testClickButton() throws Exception {
        solo.clickOnButton("View Author Name!");
        if (solo.waitForActivity(AuthorActivity.class)) {
            assertTrue(solo.searchText("Patroklos Papapetrou"));
        } else {
            fail("No author activity started!");
        }
    }
}
