package org.examples.calendar

import kotlin.test.Test
import kotlin.test.assertEquals

class CalendarTest {
    @Test
    fun testCalendarOptions() {
        val calOptions: CalendarOptions = CalendarOptions(name = "My Cal", year = 2040u, private = true)
        assertEquals("My Cal", calOptions.name)
        assertEquals(2040u, calOptions.year)
        assertEquals(true, calOptions.private)
    }
}
