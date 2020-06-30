package com.example.dimitrijohannesdevspace;

import android.app.Instrumentation;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    public static final String visitor = "Student";

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void Menu_sameActivity()
    {
        //Type visitor name
        onView(withId(R.id.visitorEditText))
                .perform(typeText(visitor), closeSoftKeyboard());

        //Test visitor name matches string
        onView(withId(R.id.visitorEditText))
                .check(matches(withText(visitor)));
    }

    @Test
    public void Menu_newActivity()
    {
        //Monitor activity after button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(Menu.class.getName(), null, true);

        //Type visitor name
        onView(withId(R.id.visitorEditText))
                .perform(typeText(visitor), closeSoftKeyboard());

        //Click next button
        onView(withId(R.id.nextButton))
                .perform(click());

        //Test if text enter matches textview in Menu
        //onView(withId(R.id.visitorWelcomeTextView))
               // .check(matches(withText("Dear... " + visitor)));

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if calculation activity is opened
        assertEquals(1, activity.getHits());
    }
}