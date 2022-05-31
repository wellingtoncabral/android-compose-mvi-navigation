object Dependencies {

    object Plugins {
        const val application = "com.android.application"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
    }

    object ClassPath {

        object Version {
            const val gradle = "7.0.4"
            const val kotlin = "1.6.10"
        }

        const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    }

    object Android {

        object Version {
            const val coreKtx = "1.7.0"
            const val appCompat = "1.4.1"
            const val activityCompose = "1.4.0"
            const val compose = "1.1.1"
            const val lifecycle = "2.5.0-rc01"
            const val lifecycleExtensions = "2.2.0"
        }

        const val coreKts = "androidx.core:core-ktx:${Version.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"

        // Compose
        const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
        const val composeMaterialIconsExtended = "androidx.compose.material:material-icons-extended:${Version.compose}"

        // Lifecycle
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleExtensions}"

        // Navigation
        const val navigationCompose = "androidx.navigation:navigation-compose:${Version.lifecycle}"
        const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}"
    }

    object ThirdParty {

        object Version {
            const val androidMaterial = "1.6.0"
            const val coilCompose = "1.3.2"
            const val coroutines = "1.6.0"
            const val retrofit = "2.9.0"
            const val koin = "3.1.5"
        }

        // Coroutines
        const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

        // Retrofit
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"

        const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
        const val coilCompose = "io.coil-kt:coil-compose:${Version.coilCompose}"

        // Koin
        const val koinAndroid = "io.insert-koin:koin-android:${Version.koin}"
        const val koinAndroidxCompose = "io.insert-koin:koin-androidx-compose:${Version.koin}"
    }

    object Test {

        object Version {
            const val junit = "4.13.2"
            const val roboeletric = "4.6.1"
            const val mockk = "1.12.4"
            const val okHttp3MockWebServer = "4.9.2"
        }

        const val junit = "junit:junit:${Version.junit}"
        const val roboeletric = "org.robolectric:robolectric:${Version.roboeletric}"
        const val mockk = "io.mockk:mockk:${Version.mockk}"
        const val kotlinxCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${ThirdParty.Version.coroutines}"
        const val koinTest = "io.insert-koin:koin-test:${ThirdParty.Version.koin}"
        const val okHttp3MockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.okHttp3MockWebServer}"
    }

    object AndroidTest {

        object Version {
            const val junit = "1.1.3"
            const val espressoCore = "3.4.0"
        }

        const val junit = "androidx.test.ext:junit:${Version.junit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
        const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Android.Version.compose}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Android.Version.compose}"
    }
}