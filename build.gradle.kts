plugins {
    java
    id("net.neoforged.gradle.userdev") version "7.0.112"
}

group = "com.meownet.usf"
version = "0.0.1"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    withSourcesJar()
}

repositories {
    mavenCentral()
    maven("https://maven.neoforged.net/releases")
    maven("https://maven.blamejared.com")
}

dependencies {
    // Update to match YOUR NeoForge exactly (check your pack’s latest.log for the neoforge line)
    implementation("net.neoforged:neoforge:1.21.1-21.1.65")

    // Only compile against KubeJS APIs; don’t bundle it
    compileOnly("dev.latvian.mods:kubejs:2101.7.2-build.295")

    compileOnly("org.jetbrains:annotations:24.1.0")
}

tasks.processResources {
    filesMatching("META-INF/mods.toml") {
        expand(
            mapOf(
                "mod_version" to project.version,
                "loader_version" to ">=4.0.0"
            )
        )
    }
}
