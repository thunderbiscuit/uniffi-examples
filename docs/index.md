# Uniffi Examples
Welcome to the companion documentation website for the [uniffi-examples repository](https://github.com/thunderbiscuit/uniffi-examples).

The repository hosts a series of examples that demonstrate how to develop language bindings libraries using the [uniffi-rs](https://github.com/mozilla/uniffi-rs) library. For more information on how to use uniffi-rs, see the [official documentation](https://mozilla.github.io/uniffi-rs/).

<br/>

## Prerequisites
The examples in this repository output a Kotlin library meant to run on the JVM, version 11 or later. To build the examples, you'll need to install the following tools:
1. [Rust](https://www.rust-lang.org/tools/install) (if you are building on macOS, also install the required intel and M1 JVM targets):
```shell
rustup target add x86_64-apple-darwin aarch64-apple-darwin
```
2. A JVM version 11 or later (a great tool to install that is [SDKMAN!](https://sdkman.io/))
3. Kotlin (a fantastic tool to install that is [SDKMAN!](https://sdkman.io/))
4. Gradle (you guessed it... [SDKMAN!](https://sdkman.io/))
