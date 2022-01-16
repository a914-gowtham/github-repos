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



## build.gradle files
There are 3 types of build.gradle files.
1. android application (app module)
1. android-library-build.gradle
    - Android module that contains ui components.
1. library-build.gradle
    - Pure java/kotlin library.


## API
https://docs.github.com/en/rest/reference/repos#list-public-repositories
