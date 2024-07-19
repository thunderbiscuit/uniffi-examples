# Introduction

This website is the companion to the [uniffi-examples GitHub repository](https://github.com/thunderbiscuit/uniffi-examples), which hosts a series of examples that demonstrate how to develop language bindings libraries using the [uniffi-rs](https://github.com/mozilla/uniffi-rs) library, a tool created and maintained by Mozilla. For more information on the internals of uniffi-rs as well as how to use it, see the [official documentation](https://mozilla.github.io/uniffi-rs/).

To learn how to expose Rust code using the examples, the most important files are located in the `calendar-ffi/src/` directories. The `calendar-ffi/src/lib.rs` file contains the Rust code that is exposed to the other languages. The `calendar-ffi/src/calendar.udl` file contains the API definition used by uniffi-rs to generate the bindings.

To see how to leverage the resulting libraries, explore and play with the tests written in Kotlin in the `calendar-kotlin/lib/src/test/kotlin/org/examples/calendar/CalendarTest.kt` files.

## Build the examples and run the tests

The simplest way to use these examples is with the [just](https://github.com/casey/just) tool installed.

```shell
git clone git@github.com:thunderbiscuit/uniffi-examples.git
cd ./uniffi-examples/1-functions/

just build
just test
```

Note that you can also build the libraries and run the tests using the following commands:

```shell
cd 1-functions/
cd ./scripts/
bash build-macos-aarch64.sh

cd ../calendar-kotlin/
./gradlew test
```
