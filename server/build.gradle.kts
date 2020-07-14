import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("org.springframework.boot") version "2.3.0.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE" apply false
    kotlin("jvm")
    kotlin("plugin.spring") version "1.3.72" apply false
    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.72" apply false
}

group = "dev.shtanko.server"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter:2.3.1.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils:kotlin-logging:1.7.9")

    implementation("org.springframework.boot:spring-boot-starter-web:2.3.1.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.3.1.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:2.3.1.RELEASE")
    implementation("org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure:2.3.1.RELEASE")

    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")

    //runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}