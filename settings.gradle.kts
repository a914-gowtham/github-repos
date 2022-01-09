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
