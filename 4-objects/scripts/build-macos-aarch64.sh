#!/bin/bash

# Move to the Rust library directory
cd ../calendar-ffi/ || exit

# Build the Rust library
cargo build --release --target aarch64-apple-darwin

# Generate Kotlin bindings using uniffi-bindgen
cargo run --bin uniffi-bindgen generate --library ./target/aarch64-apple-darwin/release/libcalendarffi.dylib --language kotlin --out-dir ../calendar-kotlin/lib/src/main/kotlin/ --no-format

# Copy the binary to the Android resources directory
cp ./target/aarch64-apple-darwin/release/libcalendarffi.dylib ../calendar-kotlin/lib/src/main/resources/darwin-aarch64/libcalendarffi.dylib
