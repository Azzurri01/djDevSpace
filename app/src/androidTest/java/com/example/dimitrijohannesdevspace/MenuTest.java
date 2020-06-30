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
public class MenuTest {

    @Rule
    public IntentsTestRule<Menu> activityScenarioRule
            = new IntentsTestRule<>(Menu.class);

    @Test
    public void home()
    {
        //Monitor activity after button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(MainActivity.class.getName(), null, true);

        //Click button
        onView(withId(R.id.homeButton))
                .perform(click());

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if MainActivity activity is opened
        assertEquals(1, activity.getHits());
    }

    @Test
    public void calculation()
    {
        //Monitor activity after button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(Calculation.class.getName(), null, true);

        //Click button
        onView(withId(R.id.calculationButton))
                .perform(click());

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if Calculation activity is opened
        assertEquals(1, activity.getHits());
    }

    @Test
    public void aboutMe()
    {
        //Monitor activity after button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(AboutMe.class.getName(), null, true);

        //Click button
        onView(withId(R.id.aboutMeButton))
                .perform(click());

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if AboutMe activity is opened
        assertEquals(1, activity.getHits());
    }

    @Test
    public void myDevProfile()
    {
        //Monitor activity after button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(MyDevPofile.class.getName(), null, true);

        //Click button
        onView(withId(R.id.myDevProfileButton))
                .perform(click());

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if MyDevProfile activity is opened
        assertEquals(1, activity.getHits());
    }
}