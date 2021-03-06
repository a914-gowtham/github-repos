dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        maven { url = java.net.URI("https://jitpack.io") }
    }
}
rootProject.name = "Github Repos"
include(":app")
include(":core")
include(":components")
include(":constants")
include(":trending-repos")
include(":trending-repos:ui-home")
include(":trending-repos:entities")
include(":trending-repos:datasource")
include(":trending-repos:usecases")
include(":trending-repos:datasource-test")
