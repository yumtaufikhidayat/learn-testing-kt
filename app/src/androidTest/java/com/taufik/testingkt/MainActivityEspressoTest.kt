package com.taufik.testingkt

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityEspressoTest {
    private val dummyVolume = "504.0"
    private val dummyCircumference = "100.0"
    private val dummySurfaceArea = "396.0"
    private val dummyLength = "12.0"
    private val dummyWidth = "7.0"
    private val dummyHeight = "6.0"
    private val emptyInput = ""
    private val fieldEmpty = "Field ini tidak boleh kosong"

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assertGetCircumference() {
        onView(withId(R.id.etLength)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.etWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.etHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.btnCalculateCircumference)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCalculateCircumference)).perform(click())

        onView(withId(R.id.tvResult)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResult)).check(matches(withText(dummyCircumference)))
    }

    @Test
    fun assertGetSurfaceArea() {
        onView(withId(R.id.etLength)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.etWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.etHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.btnCalculateSurfaceArea)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCalculateSurfaceArea)).perform(click())

        onView(withId(R.id.tvResult)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResult)).check(matches(withText(dummySurfaceArea)))
    }

    @Test
    fun assertGetVolume() {
        onView(withId(R.id.etLength)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.etWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.etHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.btnCalculateVolume)).check(matches(isDisplayed()))
        onView(withId(R.id.btnCalculateVolume)).perform(click())

        onView(withId(R.id.tvResult)).check(matches(isDisplayed()))
        onView(withId(R.id.tvResult)).check(matches(withText(dummyVolume)))
    }

    @Test
    fun assertEmptyInput() {
        // pemeriksaan input untuk length
        onView(withId(R.id.etLength)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.etLength)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etLength)).perform(typeText(dummyLength), closeSoftKeyboard())

        // pemeriksaan input untuk width
        onView(withId(R.id.etWidth)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.etWidth)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etWidth)).perform(typeText(dummyWidth), closeSoftKeyboard())

        // pemeriksaan input untuk height
        onView(withId(R.id.etHeight)).perform(typeText(emptyInput), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())

        onView(withId(R.id.etHeight)).check(matches(hasErrorText(fieldEmpty)))
        onView(withId(R.id.etHeight)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btnSave)).check(matches(isDisplayed()))
        onView(withId(R.id.btnSave)).perform(click())
    }
}