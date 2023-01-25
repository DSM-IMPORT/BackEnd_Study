plugins {
    kotlin("plugin.allopen") version "1.6.21"
}


dependencies {
    implementation(project(":hexagonal-domain"))
    implementation("org.springframework:spring-tx:6.0.3")
}