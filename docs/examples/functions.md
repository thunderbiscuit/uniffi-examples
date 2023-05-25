# Functions

The [functions example](https://github.com/thunderbiscuit/uniffi-examples/tree/master/1-functions) demonstrates how to expose root-level functions.

Note that the `namespace` block _must_ be present in the UDL file, and that root-level functions are defined in it like so:
```uniffi-udl
namespace calendar {
  string welcome(string name);
};
```

If there are no functions to expose, the `namespace` block is left empty:
```uniffi-udl
namespace calendar {};
```
