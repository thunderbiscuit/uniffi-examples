plugins {
    id("java-gradle-plugin")
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("uniFfiJvmBindings") {
            id = "org.examples.plugins.generate-kotlin-bindings"
            implementationClass = "org.examples.plugins.UniFfiJvmPlugin"
        }
    }
}
