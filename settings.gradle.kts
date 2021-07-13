enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()

        maven {
            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
            authentication {
                create("basic", org.gradle.authentication.http.BasicAuthentication::class)
            }
            credentials {
                // Do not change the username below.
                // This should always be `mapbox` (not your username).
                username = "mapbox"
                // Use the secret token you stored in gradle.properties as the password
                password = System.getenv("MAPBOX_SECRET_TOKEN")
                    ?: extra["mapbox.secretToken"] as? String
            }
        }

        jcenter {
            content {
                includeGroup("org.jetbrains.kotlinx")
            }
        }
    }
}
rootProject.name = "MapboxPodstest"
include(":androidApp")
include(":shared")