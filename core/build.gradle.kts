plugins {
    kotlin("jvm")
    java
    kotlin("plugin.serialization")
    id("net.minecrell.plugin-yml.bukkit")
}

version = "1.0.0"

bukkit {
    name = "Penetrator"
    main = "com.vjh0107.penetrator.PenetratorPlugin"
    depend = listOf("BarcodeFramework")
    author = "vjh0107"
    website = "http://github.com/vjh0107"
    apiVersion = "1.19"
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
    compileOnly("dev.jorel:commandapi-shade:8.5.1")

    compileOnly("com.vjh0107:barcodeframework-core:1.0.0") { isTransitive = true }
    compileOnly("com.vjh0107:barcodeframework-common:1.0.0") { isTransitive = true }
    compileOnly("com.vjh0107:barcodeframework-database:1.0.0") { isTransitive = true }

    compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    compileOnly("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
}

tasks {
    jar {
        archiveFileName.set("Penetrator-${project.version}.jar")
        destinationDirectory.set(file("build_output"))
    }
}