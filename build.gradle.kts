import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "2.7.3"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
	id("java")
	`java-library`
}

repositories {
	mavenCentral()
}

allprojects {
	repositories {
		mavenCentral()
		maven(url = "https://jitpack.io")
	}
}

subprojects {
	group = "org.github.follow.service"
	version = "0.0.1-SNAPSHOT"

	apply(plugin = "java")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

	repositories {
		mavenCentral()
		maven(url = "https://jitpack.io")
	}

	tasks {
		compileJava {
			sourceCompatibility = "11"
		}
	}

	dependencies {
		implementation("org.projectlombok:lombok")
		implementation("org.apache.httpcomponents:httpclient:4.5.12")
		annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
		annotationProcessor("org.projectlombok:lombok")
		testImplementation("org.springframework.boot:spring-boot-starter-test") {
			exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		}
	}

	configurations {
		compileOnly {
			extendsFrom(configurations["annotationProcessor"])
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

tasks.getByName<BootJar>("bootJar") {
	enabled = false
}

tasks.getByName<Jar>("jar") {
	enabled = true
}
