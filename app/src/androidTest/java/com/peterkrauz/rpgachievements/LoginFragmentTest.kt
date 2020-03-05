package com.peterkrauz.rpgachievements

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.peterkrauz.rpgachievements.navhost.LandingActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginFragmentTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(LandingActivity::class.java)

    @Test
    fun selectingEditText_shouldHighlightBorders() {
        onView(withId(R.id.textInputEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.textInputEmail)).perform(click())
        onView(withId(R.id.textInputEmail)).check(matches(hasFocus()))
    }

}