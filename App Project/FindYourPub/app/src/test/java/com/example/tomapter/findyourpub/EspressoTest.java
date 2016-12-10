package com.example.tomapter.findyourpub;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by tomapter on 10/12/2016.
 *


    @RunWith(AndroidJUnit4.class)
    @android.support.test.filters.SmallTest
    public class EspressoTest {

        @Rule
        public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
                MainActivity.class);

        @Test
        public void changeText_sameActivity() {
            onView(withId(R.id.find_me)).perform(click());
        }

        @Test
        public void changeText_newActivity() {
            onView(withId(R.id.editText)).perform(typeText("12/12/16"), closeSoftKeyboard());
            onView(withId(R.id.buttonSend)).perform(click());
            onView(withId(R.id.textView)).check(matches(withText("17 days until 2017!")));
        }
    }*/
