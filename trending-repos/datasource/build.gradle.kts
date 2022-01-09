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
    "implementation"(Kotlin.serialization)
    "implementation"("com.squareup.retrofit2:retrofit:2.9.0")
    "implementation"("com.squareup.okhttp3:logging-interceptor:4.9.2")
    "implementation"("com.squareup.retrofit2:converter-moshi:2.9.0")
}

sqldelight {
    database("GithubDatabase") {
        packageName = "com.gowtham.lib.cache"
        sourceFolders = listOf("sqldelight")
    }
}
