# Async
Note that building the scaffolding code uses the new library flag (released in uniffi 0.24). Here is the code run by the plugin:
```shell
cargo run --bin uniffi-bindgen generate --library ./target/aarch64-apple-darwin/debug/libcalendarffi.dylib --language kotlin --out-dir ../calendar-kotlin/lib/src/main/kotlin --no-format
```

For the `--library` flag to work, your need to have `"lib"` as a crate-type in your `Cargo.toml` file.
