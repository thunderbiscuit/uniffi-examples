# Objects
Rust structs with methods and associated functions will be exposed in bindings as objects. Note that uniffi cannot expose Rust structs that have _both_ data and methods/functions; one must choose one or the other. [Structs that only contain data fields](structs.md) use the `dictionnary` keyword and become data classes in Kotlin, and structs that only contain methods/functions use the `interface` keyword and become objects in Kotlin.

## Example
See the [4-objects](https://github.com/thunderbiscuit/uniffi-examples/tree/master/4-objects) directory for a full example. Suppose a Rust struct is defined as such:
```rust
struct Calendar {
    id: i32
}

impl Calendar {
    fn new(id: i32) -> Self {
        Calendar { id }
    }

    fn get_info(&self) -> String {
        format!("Your calendar has id {}", self.id)
    }

    fn add(&self, a: i32, b: i32) -> i32 {
        a + b
    }

    fn divide(&self, a: i32, b: i32) -> Result<i32, CalendarError> {
        if b == 0 {
            Err(CalendarError::DivisionBy0)
        } else {
            let answer: i32 = a / b;
            Ok(answer)
        }
    }
}
```

It's UDL representation would be:
```uniffi-udl
namespace calendar {};

interface Calendar {
  constructor(i32 id);

  string get_info();

  i32 add(i32 a, i32 b);

  [Throws=CalendarError]
  i32 divide(i32 a, i32 b);
};

[Error]
enum CalendarError {
  "DivisionBy0",
};
```

And the generated Kotlin class would be:
```kotlin
public class Calendar(id: Int) {
    fun getInfo(): String
    
    fun add(a: Int, b: Int): Int
    
    @Throws(CalendarException::class)
    fun divide(a: Int, b: Int): Int
}
```
