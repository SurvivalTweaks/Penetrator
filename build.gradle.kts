plugins {
    kotlin("jvm") version "1.7.10" apply false
    kotlin("plugin.serialization") version "1.7.10" apply false
    java
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1" apply false
}

subprojects {
    repositories {
        mavenCentral()
        mavenLocal()
        maven("https://www.jitpack.io")

        // Paper
        maven("https://papermc.io/repo/repository/maven-public/")
    }
}