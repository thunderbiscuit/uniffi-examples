# Structs
Uniffi can expose Rust structs and their associated fields.

Suppose a Rust struct is defined as such:
```rust
pub struct CalendarOptions {
    name: String,
    year: u32,
    private: bool,
}
```
We expose it in the UDL language using the `dictionnary` keyword like so:
```uniffi-udl
namespace calendar {};

dictionary CalendarOptions {
  string name;
  u32 year;
  boolean private;
};
```

And the resulting Kotlin class would look like this:
```kotlin
data class CalendarOptions (
    var name: String, 
    var year: UInt, 
    var private: Boolean
)
```

## Fields with object references
If a dictionary contains a field whose type is an interface, then that field will hold a reference to an underlying instance of a Rust struct. The Rust code for working with such fields must store them as an `Arc` in order to help properly manage the lifetime of the instance. So if the UDL interface looked like this:
```uniffi-udl
interface User {
  // Some sort of "user" object that can own todo items
};

dictionary TodoEntry {
    User owner;
    string text;
}
```

Then the corresponding Rust code would need to look like this:
```rust
struct TodoEntry {
    owner: Arc<User>,
    text: String,
}
```
