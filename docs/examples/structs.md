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
