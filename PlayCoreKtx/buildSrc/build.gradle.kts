import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
    kotlin("jvm") version "1.3.72"
    id("java-gradle-plugin")
}

repositories {
    google()
    jcenter()
}

dependencies {
    implementation("com.android.tools.build:gradle-api:4.1.1")
    implementation("com.android.tools.build:gradle:4.1.1")
    implementation(kotlin("stdlib"))
    gradleApi()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}

gradlePlugin {
    plugins {
        create("bundleLocalTesting") {
            id = "com.google.android.samples.appbundle-local-testing"
            implementationClass = "com.google.android.samples.appbundle.BundleLocalTestingPlugin"
        }
    }
}
