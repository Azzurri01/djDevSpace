package com.example.dimitrijohannesdevspace;

import android.app.Instrumentation;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import androidx.core.widget.NestedScrollView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AboutMeTest {

    @Rule
    public IntentsTestRule<AboutMe> aboutMeIntentsRule
            = new IntentsTestRule<>(AboutMe.class);

    @Test
    public void backButton()
    {
        //Monitor activity after back button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(Menu.class.getName(), null, true);

        //Click button
        onView(withId(R.id.aboutMeBackButton))
                .perform(click());

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if Menu activity is opened
        assertEquals(1, activity.getHits());
    }

    @Test
    public void scroll()
    {
        onView(withId(R.id.aboutMeTextView))
                .perform(swipeUp());
    }
}