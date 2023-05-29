package org.examples.plugins

val operatingSystem: OS = when {
    System.getProperty("os.name").contains("mac", ignoreCase = true) -> OS.MAC
    System.getProperty("os.name").contains("linux", ignoreCase = true) -> OS.LINUX
    else -> OS.OTHER
}

enum class OS {
    MAC,
    LINUX,
    OTHER,
}

val macOSArch: MACOS_ARCH = when {
    System.getProperty("os.arch").contains("aarch64", ignoreCase = true) -> MACOS_ARCH.AARCH64
    System.getProperty("os.arch").contains("x86_64", ignoreCase = true) -> MACOS_ARCH.X86_64
    else -> MACOS_ARCH.OTHER
}

enum class MACOS_ARCH {
    AARCH64,
    X86_64,
    OTHER,
}
