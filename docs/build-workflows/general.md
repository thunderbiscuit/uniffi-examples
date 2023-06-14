# General Approach
To build final libraries that are usable by developers on different platforms, you roughly need to do the following:

1. Build the native libraries for each platform you want to support.
2. Build the binding code for each platform you want to support.
3. Bundle these two artifacts together and make sure the bindings code can find the native libraries.

This can be done more or less "manually" using shell scripts. Here is an example of how you'd do it in Python:
```shell
#!/usr/bin/env bash
OS=$(uname -s)

# Step 1: Generating native binaries
cargo build
case $OS in
  "Darwin")
    echo "Copying macOS libcalendarffi.dylib..."
    cp ./target/release/libcalendarffi.dylib ../calendar-python/src/calendar/libcalendarffi.dylib
    ;;
  "Linux")
    echo "Copying linux libcalendarffi.so..."
    cp ./target/release/libcalendarffi.so ../calendar-python/src/calendar/libcalendarffi.so
    ;;
esac

# Step 2: Generating bdk.py
cargo run --bin uniffi-bindgen generate src/calendar.udl --language python --out-dir ../calendar-python/src/calendar/ --no-format
```

Once those two steps are completed, you'd build and publish the library using the standard Python tooling (or using GitHub Actions):
```shell
python3 setup.py bdist_wheel
python3 -m twine upload dist/*
```

## Leveraging this workflow for different build tools and languages
This approach is how you can go about building and publishing the libraries for the different languages you wish to support. The only difference is that you'll need to use the appropriate tooling for each language. Note that in some cases, it often more idiomatic to use extensions on build tools than shell scripts.
