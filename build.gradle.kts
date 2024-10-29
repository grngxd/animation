plugins {
    id("java")
    id("maven-publish")
}

group = "ru.hogoshi"
version = "4.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "ru.hogoshi"
            artifactId = "Animation"
            version = "4.0"

            afterEvaluate {
                from(components["java"])
            }
        }
    }
}