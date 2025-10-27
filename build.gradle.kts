plugins {
    id("java")
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
    // Compile against NeoForge API — don't bundle it
    compileOnly("net.neoforged:neoforge:21.1.213")

    // Optional compile-time helpers
    compileOnly("dev.latvian.mods:kubejs:2101.7.2-build.295")
    compileOnly("org.jetbrains:annotations:24.1.0")
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    filesMatching(listOf("META-INF/mods.toml", "META-INF/neoforge.mods.toml")) {
        expand(mapOf("mod_version" to project.version, "loader_version" to ">=4.0.0"))
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
