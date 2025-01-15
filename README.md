# Sources for the Tools in Action about Kotlin & HTMX

Step 1
-

**Scoped branch : `main`**

First create a project using the [Ktor Project Generator with this configuration](https://start.ktor.io/settings?name=liksi&website=org&artifact=org.liksi&kotlinVersion=2.1.0&ktorVersion=3.0.3&buildSystem=GRADLE_KTS&buildSystemArgs.version_catalog=true&engine=CIO&configurationIn=CODE&addSampleCode=true&plugins=).

Add `development=true` to `gradle.properties` 

**Commands**


```shell
  ./gradlew run # run HTTP embedded server
```

```shell
  ./gradlew build -t # to run auto-build for automatic reloading
```

*PS : run these commands in two distinct shells*

Go [here](http://localhost:8080) to see UI

Step 2
-

**Scoped branch : `step-2/libs-styling`**

This branch add limited styling and libs we will use in this project
See `Index.kt` file.
