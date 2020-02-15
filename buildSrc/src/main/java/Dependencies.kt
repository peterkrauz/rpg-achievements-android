object ConfigVersion {
    const val applicationId = "com.peterkrauz.rpgachievements"
    const val compileSdk = 29
    const val buildTools = "29.0.0"
    const val minSdk = 24
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val ktx = "1.1.0"
    const val kotlin = "1.3.61"
    const val constraintLayout = "1.1.3"
    const val appCompat = "1.1.0"
    const val retrofit = "2.7.0"
    const val okHttp = "3.12.6"
    const val navigation = "2.2.0"
    const val coroutines = "1.3.0"
    const val moshi = "1.9.0"
    const val lifecycle = "2.2.0"
    const val koin = "2.0.1"
    const val coil = "0.9.1"
    const val material = "1.0.0"
    const val threeTen = "1.2.2"
}

object TestVersions {
    const val junit = "4.12"
    const val testExtJunit = "1.1.1"
    const val espresso = "3.2.0"
}

object Libraries {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModelktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleRuntimektx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleLiveDataktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"

    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val threeTen = "com.jakewharton.threetenabp:threetenabp:${Versions.threeTen}"
}

object TestLibraries {
    const val junit = "junit:junit:${TestVersions.junit}"
    const val testExtJunit = "androidx.test.ext:junit:${TestVersions.testExtJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"
}

object ModulePaths {
    const val app = ":app"
    const val data = ":data"
    const val domain = ":domain"
    const val network = ":network"
}
