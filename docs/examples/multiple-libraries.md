# Multiple Libraries
The [multiple libraries](https://github.com/thunderbiscuit/uniffi-examples/tree/master/6-multiple-libraries) directory adds a new directory; `clock-ffi`, which contains an enum type our `calendar-ffi` library depends on.

This new enum `ClockType` is defined in the `clock-ffi` library as it would be in any other uniffi library, similar to how we've done in [3-enums](./enums.md). To use the `ClockType` in calendar-ffi, we let uniffi-rs know this type is defined in a separate udl file by using the following syntax:
```uniffi-udl
[External="clock_ffi"]
typedef extern ClockType;
```

We can then import the `ClockType` enum in our Rust code just like we would any other type:
```rust
use clock_ffi::ClockType;
```

Note that for the bindings file to import the types correctly, it needs to know what namespace this other library uses. By default uniffi assumes this is the name of the library, but you can override this by defining it in the `uniffi.toml` like so:
```toml
[bindings.kotlin.external_packages]
# Map the crate names from [External={name}] into Kotlin package names
clock_ffi = "org.examples.clock"
```
