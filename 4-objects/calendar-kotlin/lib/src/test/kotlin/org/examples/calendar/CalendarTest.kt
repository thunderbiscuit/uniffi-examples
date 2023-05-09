package org.examples.calendar

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CalendarTest {
    @Test
    fun testCalendarObject() {
        val calendar: Calendar = Calendar(42)

        assertEquals("Your calendar has id 42", calendar.getInfo())
        assertEquals(20, calendar.add(10, 10))
        assertEquals(20, calendar.divide(100, 5))
    }

    @Test
    fun failsWhenAttemptingToDivideBy0() {
        assertFailsWith(
            exceptionClass = CalendarException.DivisionBy0::class,
            block = {
                val calendar: Calendar = Calendar(42)
                calendar.divide(100, 0)
            }
        )

        assertFailsWith(
            exceptionClass = CalendarException::class,
            block = {
                val calendar: Calendar = Calendar(42)
                calendar.divide(100, 0)
            }
        )

        assertFailsWith(
            exceptionClass = Exception::class,
            block = {
                val calendar: Calendar = Calendar(42)
                calendar.divide(100, 0)
            }
        )
    }
}
