import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.gradle.api.tasks.testing.logging.TestExceptionFormat.*

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0"
    id("org.gradle.java-library")
    id("org.gradle.maven-publish")
    id("org.gradle.signing")
}

repositories {
    mavenCentral()
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<Test> {
    testLogging {
        events(PASSED, SKIPPED, FAILED, STANDARD_OUT, STANDARD_ERROR)
        showExceptions = true
        showCauses = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("net.java.dev.jna:jna:5.12.0")

    testImplementation(kotlin("test"))
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "org.examples"
                artifactId = "calendar-kotlin"
                version = "0.1.0"

                from(components["java"])
                pom {
                    name.set("calculator-kotlin")
                    description.set("Calendar Kotlin language bindings for the JVM.")
                    url.set("")
                    licenses {
                        license {
                            name.set("APACHE 2.0")
                            url.set("")
                        }
                    }
                }
            }
        }
    }
}
