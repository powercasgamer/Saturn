pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://repo.stellardrift.ca/repository/snapshots/")
        maven("https://repo.deltapvp.net/")
        mavenLocal()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "SaturnParent"

sequenceOf(
    "kotlin",
    "unsafe"
).forEach {
    include("saturn-$it")
    project(":saturn-$it").projectDir = file(it)
}
