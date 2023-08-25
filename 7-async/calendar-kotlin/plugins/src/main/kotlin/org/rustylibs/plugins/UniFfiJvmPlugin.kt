package org.examples.plugins

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Exec
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.register

internal class UniFfiJvmPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = target.run {

        // register a task called buildJvmBinaries which will run something like
        // cargo build --release --target aarch64-apple-darwin
        val buildJvmBinaries by tasks.register<DefaultTask>("buildJvmBinaries") {
            if (operatingSystem == OS.MAC) {
                exec {
                    workingDir("${project.projectDir}/../../calendar-ffi")
                    executable("cargo")
                    val cargoArgs: List<String> = listOf("build", "--target", "x86_64-apple-darwin")
                    args(cargoArgs)
                }
                exec {
                    workingDir("${project.projectDir}/../../calendar-ffi")
                    executable("cargo")
                    val cargoArgs: List<String> = listOf("build", "--target", "aarch64-apple-darwin")
                    args(cargoArgs)
                }
            } else if (operatingSystem == OS.LINUX) {
                exec {
                    workingDir("${project.projectDir}/../../calendar-ffi")
                    executable("cargo")
                    val cargoArgs: List<String> = listOf("build", "--target", "x86_64-unknown-linux-gnu")
                    args(cargoArgs)
                }
            }
        }

        // move the native libs build by cargo from target/.../release/
        // to their place in the calculator-jvm library
        val moveNativeJvmLibs by tasks.register<DefaultTask>("moveNativeJvmLibs") {

            // dependsOn(buildJvmBinaryX86_64MacOS, buildJvmBinaryAarch64MacOS, buildJvmBinaryLinux)
            dependsOn(buildJvmBinaries)

            data class CopyMetadata(val targetDir: String, val resDir: String, val ext: String)
            val libsToCopy: MutableList<CopyMetadata> = mutableListOf()

            if (operatingSystem == OS.MAC) {
                libsToCopy.add(
                    CopyMetadata(
                        targetDir = "aarch64-apple-darwin",
                        resDir = "darwin-aarch64",
                        ext = "dylib"
                    )
                )
                libsToCopy.add(
                    CopyMetadata(
                        targetDir = "x86_64-apple-darwin",
                        resDir = "darwin-x86-64",
                        ext = "dylib"
                    )
                )
            } else if (operatingSystem == OS.LINUX) {
                libsToCopy.add(
                    CopyMetadata(
                        targetDir = "x86_64-unknown-linux-gnu",
                        resDir = "linux-x86-64",
                        ext = "so"
                    )
                )
            }

            libsToCopy.forEach {
                doFirst {
                    copy {
                        with(it) {
                            from("${project.projectDir}/../../calendar-ffi/target/${this.targetDir}/debug/libcalendarffi.${this.ext}")
                            into("${project.projectDir}/../../calendar-kotlin/lib/src/main/resources/${this.resDir}/")
                        }
                    }
                }
            }

            doLast {
                println("Binaries copied from ${project.projectDir}/../../calendar-ffi/target/aarch64-apple-darwin/debug/libcalendarffi.dylib to ${project.projectDir}/../../calendar-kotlin/lib/src/main/resources/darwin-aarch64/")
            }
        }

        val generateJvmBindings by tasks.register<Exec>("generateJvmBindings") {

            dependsOn(moveNativeJvmLibs)

            workingDir("${project.projectDir}/../../calendar-ffi")
            executable("cargo")
            args(
                "run",
                "--bin",
                "uniffi-bindgen",
                "generate",
                "--library",
                "./target/aarch64-apple-darwin/debug/libcalendarffi.dylib",
                "--language",
                "kotlin",
                "--out-dir",
                "../calendar-kotlin/lib/src/main/kotlin",
                "--no-format",
            )

            doLast {
                println("Kotlin JVM bindings file successfully created")
            }
        }

        // we need an aggregate task which will run the 3 required tasks to build the JVM libs in order
        // the task will also appear in the printout of the ./gradlew tasks task with a group and description
        tasks.register("buildKotlinLib") {
            group = "Calendar"
            description = "Aggregate task to build Kotlin JVM library"

            dependsOn(
                buildJvmBinaries,
                moveNativeJvmLibs,
                generateJvmBindings
            )
        }
    }
}
