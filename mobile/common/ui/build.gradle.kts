plugins {
    id("common.android-library")
}

dependencies {
    implementation(Dependencies.Android.APPCOMPAT)
    implementation(Dependencies.Android.LIFECYCLE_VIEW_MODEL)
    implementation(Dependencies.Android.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.Android.CONSTRAIN_LAYOUT)
    implementation(Dependencies.Android.CORE_KTX)
    implementation(Dependencies.JetBrains.KOTLIN)
    implementation(Dependencies.Log.TIMBER)
}
