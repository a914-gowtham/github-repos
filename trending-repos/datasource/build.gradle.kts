apply {
    from("$rootDir/library-build.gradle")
}

plugins {
    kotlin(Plugins.serialization) version Kotlin.version
    id(Plugins.sqlDeLightPlugin)
}

dependencies {
    "implementation"(project(Modules.trendingRepoEntities))
    "implementation"(project(Modules.constants))
    "implementation"(SqlDelight.runtime)
    "implementation"(Kotlin.serialization)
    "implementation"(Kotlin.coroutines)
    "implementation"(OkHttp.retrofit)
    "implementation"(OkHttp.loggingInterceptorAlone)
    "implementation"(OkHttp.converter)
}

sqldelight {
    database("GithubDatabase") {
        packageName = "com.gowtham.lib.cache"
        sourceFolders = listOf("sqldelight")
    }
}
