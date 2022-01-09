apply {
    from("$rootDir/library-build.gradle")
}

plugins {
    kotlin(Plugins.serialization) version Kotlin.version
    id(Plugins.sqlDeLightPlugin)
}

dependencies {
    "implementation"(project(Modules.trendingRepoEntities))
    "implementation"(SqlDelight.runtime)
}

sqldelight {
    database("GithubDatabase") {
        packageName = "com.gowtham.lib.cache"
        sourceFolders = listOf("sqldelight")
    }
}
