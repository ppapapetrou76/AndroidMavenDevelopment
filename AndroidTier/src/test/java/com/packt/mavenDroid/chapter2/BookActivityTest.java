package com.packt.mavenDroid.chapter2;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BookActivityTest extends AndroidTestCase {
    private ViewGroup mRoot;
    private TextView textView;
    private Button button;
    
    @Override
    protected void setUp() throws Exception {
       /* super.setUp();

        // inflate the layout
        final Context context = getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        mRoot = (ViewGroup) inflater.inflate(R.layout.activity_main, null);

        // manually measure it, and lay it out
        mRoot.measure(500, 500);
        mRoot.layout(0, 0, 500, 500);

        textView = (TextView) mRoot.findViewById(R.id.text1);
        button = (Button) mRoot.findViewById(R.id.button1);*/
    }

    /**
     * The name 'test preconditions' is a convention to signal that if this
     * test doesn't pass, the test case was not set up properly and it might
     * explain any and all failures in other tests.  This is not guaranteed
     * to run before other tests, as junit uses reflection to find the tests.
     */
    @SmallTest
    public void testPreconditions() {
        assertNotNull(textView);
        assertNotNull(button);
        assertTrue("Button should be lower than the text",
                button.getBottom() < textView.getBottom());
    }
}
