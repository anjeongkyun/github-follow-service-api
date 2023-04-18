plugins {
    checkstyle
    id("org.ec4j.editorconfig") version "0.0.3"
    `java-library`
}

project(":api") {
    dependencies {
        implementation(project(":contracts"))
        implementation(project(":domain-model"))
        implementation(project(":data-access"))

        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

        implementation(group = "com.fasterxml.jackson.core", name = "jackson-core", version = "2.13.3")
        implementation(group = "com.fasterxml.jackson.core", name = "jackson-databind", version = "2.13.3")
        implementation(group = "com.fasterxml.jackson.core", name = "jackson-annotations", version = "2.12.4")
        implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-cbor:2.13.3")
        implementation("com.hubspot.jackson:jackson-datatype-protobuf:0.9.13")

        implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    }
    checkstyle {
        configFile = file("../.rules/checkstyle/checkstyle.xml")
        toolVersion = "8.40"
    }
    tasks.jar {
        enabled = true
        dependsOn("editorconfigCheck", "checkstyleMain")
    }
    tasks.bootJar {
        enabled = true
    }
}
