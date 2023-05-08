package org.examples.calendar

import kotlin.test.Test
import kotlin.test.assertEquals

class CalendarTest {
    @Test
    fun testWelcome() {
        assertEquals("Welcome World, your calendar is ready", welcome(name = "World"))
    }
}
