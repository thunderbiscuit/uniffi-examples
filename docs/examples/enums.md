# Enums
Uniffi can expose Rust enums.

Suppose a Rust enum is defined as such:
```rust
pub enum Month {
    January,
    February,
    March,
    April,
    May,
    June,
    July,
    August,
    September,
    October,
    November,
    December,
}
```

We expose it in the UDL language using the `enum` keyword like so:
```uniffi-udl
namespace calendar {};

enum Month {
  "January",
  "February",
  "March",
  "April",
  "May",
  "June",
  "July",
  "August",
  "September",
  "October",
  "November",
  "December"
};
```
