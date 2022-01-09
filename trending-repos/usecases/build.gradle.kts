apply {
    from("$rootDir/library-build.gradle")
}

plugins {
    kotlin(Plugins.serialization) version Kotlin.version
}


dependencies {
    "implementation"(project(Modules.trendingRepoDataSource))
    "implementation"(project(Modules.trendingRepoEntities))
}