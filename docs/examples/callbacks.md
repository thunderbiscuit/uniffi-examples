# Callbacks
We build callbacks using the following UDL syntax:
```uniffi-udl
callback interface Reminder {
  [Throws=CalendarError]
  string remind_me();

  [Throws=CalendarError]
  void ping_me(Event event);
};
```

With the corresponding Rust code:
```rust
pub trait Reminder: Send + Sync + std::fmt::Debug {
    fn remind_me(&self) -> Result<String, CalendarError>;

    fn ping_me(&self, event: Event) -> Result<(), CalendarError>;
}
```

Note that for callbacks you will need to implement the `From<uniffi::UnexpectedUniFFICallbackError>` trait on one of your error types in order to handle unexpected callback errors.  See the Callback Interfaces section of the handbook for more info.
```rust
impl From<uniffi::UnexpectedUniFFICallbackError> for CalendarError {
    fn from(_: uniffi::UnexpectedUniFFICallbackError) -> Self { Self::EventError }
}
```

From the bindings we simply override the `remind_me` and `ping_me` methods:
```kotlin
class CustomReminder : Reminder {
    override fun remindMe(): String {
        return "Don't forget to call your mom!"
    }

    override fun pingMe(event: Event): Unit {
        println("Don't forget you have a $event coming up!")
    }
}
```

See the [tests](https://github.com/thunderbiscuit/uniffi-examples/blob/master/5-callbacks/calendar-kotlin/lib/src/test/kotlin/org/examples/calendar/CalendarTest.kt) for more examples.
