pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android Assignment"
include(":app")
include(":core")
include(":core:base")
include(":core:common")
include(":core:local")
include(":core:network")
include(":universities")
include(":details")
