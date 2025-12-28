import com.android.build.api.dsl.androidLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.vanniktech.mavenPublish)
    signing
}
signing {
    useGpgCmd()  // Uses your local gpg command; prompts for passphrase if needed
    sign(publishing.publications)
}
group = "io.github.shahzaibali02"
version = "1.0.2"

kotlin {
//    jvm()
    androidLibrary {
        namespace = "com.shahzaib.kmpsharedpref"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withJava()  // If you need JVM artifacts alongside Android

        compilations.configureEach {
            compilerOptions.configure {
                jvmTarget.set(JvmTarget.JVM_11)
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
//    linuxX64()

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

mavenPublishing {

//    configure(
//            KotlinMultiplatform(
//                    javadocJar = JavadocJar.Dokka("dokkaHtml"), // Uses Dokka for docs (recommended for Kotlin)
//                    sourcesJar = true,                          // Always include sources
//                    androidVariantsToPublish = listOf("release") // Only publish release variant (required for Maven Central)
//            )
//    )
    publishToMavenCentral()

    signAllPublications()

    coordinates(groupId = "io.github.shahzaibali02", artifactId = "kmpsharedpref", version = version.toString())

    pom {
        name.set("KMPSHAREDPREF")
        description.set("Kotlin Multiplatform SharedPreferences wrapper")
        url.set("https://github.com/ShahzaibAli02/KMPSHAREDPREF")

        licenses {
            license {
                name.set("Apache-2.0")  // Change if you use a different license
                url.set("https://opensource.org/licenses/Apache-2.0")
            }
        }

        developers {
            developer {
                id.set("shahzaibali02")  // Your GitHub username or ID
                name.set("Shahzaib Ali")  // Your name
                email.set("alishahzaib02@gmail.com")  // Add your email
            }
        }

        scm {
            connection.set("scm:git:git://github.com/ShahzaibAli02/KMPSHAREDPREF.git")
            developerConnection.set("scm:git:ssh://github.com/ShahzaibAli02/KMPSHAREDPREF.git")
            url.set("https://github.com/ShahzaibAli02/KMPSHAREDPREF")
        }
    }
}
