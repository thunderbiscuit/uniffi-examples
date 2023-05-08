package org.examples.calendar

import kotlin.test.Test
import kotlin.test.assertEquals

class CalendarTest {
    @Test
    fun testMonths() {
        val month1: Month = Month.JANUARY
        assertEquals(Month.JANUARY, month1)
    }
}
