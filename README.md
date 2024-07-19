# Readme
Please see the [companion documentation website](https://thunderbiscuit.github.io/uniffi-examples/getting-started/introduction.html) for complete documentation on how to use these examples.

This repository hosts a series of examples that demonstrate how to develop language bindings libraries using the [uniffi-rs](https://github.com/mozilla/uniffi-rs) library. For more information on how to use uniffi-rs, see the [official documentation](https://mozilla.github.io/uniffi-rs/).

<br/>

## Build the examples and run the tests
If you work with the [just](https://github.com/casey/just) cli tool, you can build the libraries and run the tests using the following commands:

```shell
cd 1-functions/
just build
just test
```

Otherwise, you can also use:

```shell
cd 1-functions/
cd ./scripts/
bash build-macos-aarch64.sh

cd ../calendar-kotlin/
./gradlew test
```
