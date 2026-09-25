pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.jvm") version "2.4.20"
    }

    repositories {
        gradlePluginPortal()

        maven("https://repo.papermc.io/repository/maven-public/") {
            name = "papermc"
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()

        maven("https://repo.papermc.io/repository/maven-public") {
            name = "papermc"
        }
    }
}

rootProject.name = "InstanceCore-API"