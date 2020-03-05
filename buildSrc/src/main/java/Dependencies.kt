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
    const val firebase = "17.2.2"
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

    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebase}"
}

object TestVersions {
    const val junit = "4.12"
    const val coreArch = "2.0.0"
    const val mockito = "2.8.9"
    const val mockitoKotlin = "2.2.0"
    const val espresso = "3.2.0"
    const val testRunner = "0.5"
    const val testExtJunit = "1.1.1"
    const val supportAnnotations = "24.0.0"
    const val hamcrest = "1.3"
}

object TestLibraries {
    const val junit = "junit:junit:${TestVersions.junit}"
    const val hamcrest = "org.hamcrest:hamcrest-all:${TestVersions.hamcrest}"
    const val mockitoCore = "org.mockito:mockito-core:${TestVersions.mockito}"
    const val mockitoAndroid = "org.mockito:mockito-android:${TestVersions.mockito}"
    const val testExtJunit = "androidx.test.ext:junit:${TestVersions.testExtJunit}"
    const val testRunner = "com.android.support.test:runner:${TestVersions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"
    const val coreArchTesting = "androidx.arch.core:core-testing:${TestVersions.coreArch}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${TestVersions.espresso}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${TestVersions.mockitoKotlin}"
    const val idlingResource = "androidx.test.espresso:espresso-idling-resource:${TestVersions.espresso}"
    const val supportAnnotations = "com.android.support:support-annotations:${TestVersions.supportAnnotations}"
}

object ModulePaths {
    const val app =      ":app"
    const val data =     ":data"
    const val common =   ":common"
    const val domain =   ":domain"
    const val network =  ":network"

    const val login =    ":presentation:login"
    const val commonUi = ":presentation:common-ui"
}
