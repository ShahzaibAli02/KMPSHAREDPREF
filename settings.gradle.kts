pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()

        // GitHub Packages (needed when THIS project consumes private packages)
        maven {
            url = uri("https://maven.pkg.github.com/ShahzaibAli02/KMPSHAREDPREF")
            credentials {
                username = providers.gradleProperty("gpr.user").orNull
                password = providers.gradleProperty("gpr.key").orNull
            }
        }
    }
}

rootProject.name = "multiplatform-library-template"
include(":library")
