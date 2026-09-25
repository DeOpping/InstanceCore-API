plugins {
    kotlin("jvm")
    `java-library`
    `maven-publish`
}

group = "io.github.deopping.instancecore"
version = "0.1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }

    withSourcesJar()
}

kotlin {
    jvmToolchain(25)
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.2.build.+")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}