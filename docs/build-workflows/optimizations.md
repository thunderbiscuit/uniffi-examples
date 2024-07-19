# Optimizations
When compiling Rust binaries, a range of options can be used to reduce the size of the final binary that must be shipped with the library. Here is an example of a `Cargo.toml` file that uses these options, which are used in bdk-ffi. These options are then used when calling `cargo build --profile release-smaller` to build the final binary.

```toml
[profile.release-smaller]
inherits = "release"
opt-level = 'z'     # Optimize for size.
lto = true          # Enable Link Time Optimization
codegen-units = 1   # Reduce number of codegen units to increase optimizations.
panic = 'abort'     # Abort on panic
strip = 'debuginfo' # Strip symbols from binary*
```
