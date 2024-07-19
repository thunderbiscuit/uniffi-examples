# Building ready-to-use libraries
**The uniffi tool will help you produce two important artifacts:**
1. The native binaries that are platform-specific and will internally be called by your Kotlin/Swift application.
2. The "binding" code that calls into this native library (this defines the public API exposed to a Kotlin dev, for example).

<br>

**The uniffi library does not help you with the following:**
1. Bundling these artifacts together so as to ship a working library that will be usable on all platforms you target.
2. Publishing these libraries to public repositories so that other developers can use them.

The pages in this section are meant to provide mental models and help you with these two tasks. They also include information on specific approaches that the Bitcoin Development Kit has chosen to accomplish these tasks, but keep in mind that they are what worked for us but may not be the best approach for your project.
