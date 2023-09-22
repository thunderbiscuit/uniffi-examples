package org.examples.calendar

import kotlin.test.Test
import kotlin.test.assertEquals
import org.examples.clock.ClockType

class CalendarTest {
    @Test
    fun testClockType() {
        val clockType: ClockType = ClockType.ANALOG
    }

    // This test will fail at runtime with error:
    // java.lang.UnsatisfiedLinkError: Unable to load library 'clock_ffi':
    // To make the test pass, you must build the clock_ffi library and include the dylib in the classpath.
    @Test
    fun testCalendar() {
        val clockType: ClockType = ClockType.ANALOG
        val calendar = Calendar(42, clockType)
    }
}
