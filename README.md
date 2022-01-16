# github-repos
Multi-module demo app that gets data from a Github api

## List and Refresh
<img src="https://github.com/a914-gowtham/github-repos/blob/master/art/demo1.gif" width="25%">

## Search and Cache
<img src="https://github.com/a914-gowtham/github-repos/blob/master/art/demo2.gif" width="25%">


## Module Design

| Module name        | Type                 | Description                                                      |
| -------------      | -------------        | -------------                                                    |
| [app](/app/)                | Android Application  | MainActivity, BaseApplication, Theme, Hilt setup.                |
| [core](/core/)               | Java/Kotlin Library  | Core business models and utils classes.                      |
| [datasource](/trending-repos/datasource/)    | Java/Kotlin Library  | Data-sources (network and cache) for the trending repos Module.            |
| [datasource-test](/trending-repos/datasource-test/)    | Java/Kotlin Library  | Data-source test cases.            |
| [entities](/trending-repos/entities/)        | Java/Kotlin Library  | Domain models and classes for the trending repos Module.                   |
| [usecases](/trending-repos/usecases/)   | Java/Kotlin Library  | Use-cases for the trending repos Module.                                   |
| [ui-home](/trending-repos/ui-home/)        | Android Library      | UI components for the HomeList screen.                           |
| [constants](/constants/)          | Java/Kotlin Library  | Random constants.                                                |
| [components](/components/)         | Android Library      | Common Composables and Android utils                   |

## Architecture
<img src="/art/arch.png" width="40%" height="40%" />


## Libraries and Decisions Overview
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines & Flow](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [SQLDelight](https://github.com/cashapp/sqldelight) - Generates typesafe Kotlin APIs from SQL and it supports a variety of dialects and platforms
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design quality, robust, testable, and maintainable apps.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
- [Dependency Injection](https://developer.android.com/training/dependency-injection) - 
  - [Dagger-Hilt](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
  - [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack) - DI for injecting `ViewModel`.
- [Retrofit](https://square.github.io/retrofit/) - A popular type-safe HTTP client for Android and Java
- [Kotlin Serializer](https://github.com/Kotlin/kotlinx.serialization) - Convert Specific Classes to and from JSON.Runtime library with core serialization API and support libraries with various serialization formats.
- [Coil-kt](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines.
- [Mockito-Kotlin](https://github.com/mockito/mockito-kotlin) - Most popular Mocking framework for writing unit tests 


## build.gradle files
There are 3 types of build.gradle files.
1. android application (app module)
1. android-library-build.gradle
    - Android module that contains ui components.
1. library-build.gradle
    - Pure java/kotlin library.


## API
https://docs.github.com/en/rest/reference/repos#list-public-repositories
