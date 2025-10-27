rootProject.name = "usf-adminmod"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.neoforged.net/releases")
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        maven("https://maven.neoforged.net/releases")
        mavenCentral()
        maven("https://maven.blamejared.com")
    }
}
