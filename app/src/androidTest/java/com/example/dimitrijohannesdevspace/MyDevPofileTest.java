package com.example.dimitrijohannesdevspace;

import android.app.Instrumentation;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MyDevPofileTest {

    @Rule
    public IntentsTestRule<MyDevPofile> myDevProfileIntentsRule
            = new IntentsTestRule<>(MyDevPofile.class);

    @Test
    public void backButton()
    {
        //Monitor activity after back button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(Menu.class.getName(), null, true);

        //Click button
        onView(withId(R.id.myDevProfileBackButton))
                .perform(click());

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if Menu activity is opened
        assertEquals(1, activity.getHits());
    }
}