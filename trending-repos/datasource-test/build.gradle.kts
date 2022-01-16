apply {
    from("$rootDir/library-build.gradle")
}

plugins {
    kotlin(Plugins.serialization) version Kotlin.version
}

dependencies {
    "testImplementation"(Kotlin.serialization)
    "testImplementation"(project(Modules.trendingRepoEntities))
    "testImplementation"(project(Modules.trendingRepoDataSource))
    "testImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")
    "testImplementation"("junit:junit:4.13.2")
    "testImplementation"( "androidx.test:core:1.4.0")
    "testImplementation"("org.mockito.kotlin:mockito-kotlin:4.0.0")
    "testImplementation"("org.mockito:mockito-inline:3.9.0")
    "testImplementation"("com.google.truth:truth:1.1.3")
}
