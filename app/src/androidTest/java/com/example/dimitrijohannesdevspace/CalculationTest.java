package com.example.dimitrijohannesdevspace;

import android.app.Instrumentation;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Assert;
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
public class CalculationTest {

    @Rule
    public IntentsTestRule<Calculation> calculationIntentsRule
            = new IntentsTestRule<>(Calculation.class);

    @Test
    public void calcDensity()
    {
        double mass = 20;
        double volume = 10;
        double density = mass/volume;

        assertEquals(2.00, density);
    }

    @Test
    public void calcMass()
    {
        int density = 20;
        int volume = 10;
        int mass = density*volume;

        Assert.assertEquals(200, mass);
    }

    @Test
    public void calcVolume()
    {
        double mass = 20;
        double density = 10;
        double volume = mass/density;

        assertEquals(2.00, volume);
    }

    @Test
    public void BackButton()
    {
        //Monitor activity after button is clicked
        Instrumentation.ActivityMonitor activity = getInstrumentation().addMonitor(Menu.class.getName(), null, true);

        //Click button
        onView(withId(R.id.calcBackButton))
                .perform(click());

        //Wait for activity
        activity.waitForActivityWithTimeout(5);

        //Test if MainActivity activity is opened
        assertEquals(1, activity.getHits());
    }
}