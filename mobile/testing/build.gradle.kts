import extensions.implementation

plugins {
    id("common.android-library")
}

dependencies {
    implementation(Dependencies.APPCOMPAT)
    implementation(TestDependencies.MOCKITO)
    implementation(TestDependencies.ASSERTJ)
    implementation(TestDependencies.ROBOELECTRIC)
    implementation(TestDependencies.ROOM)
    implementation(TestDependencies.CORE)
    implementation(TestDependencies.ARCH_CORE)
    implementation(TestDependencies.RULES)
    implementation(TestDependencies.RUNNER)
    implementation(TestDependencies.COROUTINES_TEST)
    implementation(TestDependencies.FRAGMENT_TEST)
    implementation(TestDependencies.EXT)
    implementation(TestDependencies.MOCK_WEB_SERVER)
}
