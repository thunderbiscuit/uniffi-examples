package org.examples.calendar

import kotlin.test.Test
import kotlin.test.assertEquals

class CalendarTest {

    class CustomReminder : Reminder {
        override fun remindMe(): String {
            return "Don't forget to call your mom!"
        }

        override fun pingMe(event: Event): Unit {
            println("Don't forget you have a $event coming up!")
        }
    }

    @Test
    fun testReminderCallback() {
        val customReminder = CustomReminder()
        val calendar: Calendar = Calendar(customReminder)

        assertEquals("Today is a good day", calendar.today())
        assertEquals("Don't forget to call your mom!", calendar.myReminder())
    }

    @Test
    fun testPingMeCallback() {
        val customReminder = CustomReminder()
        val calendar: Calendar = Calendar(customReminder)

        calendar.start()
    }
}
