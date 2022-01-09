apply {
    from("$rootDir/library-build.gradle")
}

dependencies {
    "testImplementation"(project(Modules.trendingRepoDataSource))
}
