plugins {
    id("common.android-library")
}

dependencies {
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.LIFECYCLE_VIEW_MODEL)
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.TIMBER)
    implementation(project(":mobile:common:ui"))
}
