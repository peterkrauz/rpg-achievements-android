package com.peterkrauz.rpgachievements

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.peterkrauz.rpgachievements.login.LoginViewModel
import com.peterkrauz.rpgachievements.navhosts.LandingActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.AdditionalMatchers.not

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginFragmentTest : KoinTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(LandingActivity::class.java)

    private val viewModel by inject<LoginViewModel>()

    @Before
    fun setup() {
//        loadKoinModules(LoginComponent.modules())
    }

    @Test
    fun selectingEditText_shouldHighlightBorders() {
        onView(withId(R.id.textInputUsername)).check(matches(isDisplayed()))
        onView(withId(R.id.textInputUsername)).perform(click())
        onView(withId(R.id.textInputUsername)).check(matches(hasFocus()))
    }

    @Test
    fun inputWrongFormattedEmail_shouldProduceFieldError() {
        onView(withId(R.id.textInputUsername)).check(matches(hasErrorText("")))
    }

    @Test
    fun performLogin_shouldDisableTextInputsAndButton_andEnableLoading() {
        onView(withId(R.id.progressBarLoading)).check(matches(not(isDisplayed())))
        onView(withId(R.id.textInputUsername)).check(matches(isEnabled()))
        onView(withId(R.id.textInputPassword)).check(matches(isEnabled()))
        onView(withId(R.id.buttonLogin)).check(matches(isEnabled()))

        viewModel.login(
            email = "abc@def.com",
            password = "123456"
        )

        onView(withId(R.id.progressBarLoading)).check(matches(isDisplayed()))
        onView(withId(R.id.textInputUsername)).check(matches(not(isEnabled())))
        onView(withId(R.id.textInputPassword)).check(matches(not(isEnabled())))
        onView(withId(R.id.buttonLogin)).check(matches(not(isEnabled())))
    }

    @After
    fun teardown() {
//        unloadKoinModules(LoginComponent.modules())
    }
}
