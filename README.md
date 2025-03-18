# Sources for the Tools in Action about Kotlin & HTMX

The application is built using the following tech & fmks :
- [kotlin](https://kotlinlang.org/)
- [ktor](ktor.io)
- [htmx](htmx.org)
- [tailwindcss](https://tailwindcss.com/)


This proof of concept aims to show the simplicity of the alliance of Kotlin + Htmx & Ktor to add a GUI on your API/Project or even build an app in couple hours.
This project is organized following Git branches. 

You can navigate to diff using the [Pull requests](https://github.com/NoxFr/kotlin-htmx/pulls) declared or you can jump directly on last branch [step-7/add-beer](https://github.com/NoxFr/kotlin-htmx/tree/step-7/add-beer/src/main/kotlin/org/liksi) to see final version.

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

Step 3
-

**Scoped branch : `step-3/add-api`**

This branch add basic API in ktor to demonstrate the use case and use the service in the `Index.kt` file.
See `api` package


Step 4
-

**Scoped branch : `step-4/components`**

This branch refactor the application to split logic into components.

Step 5
-

**Scoped branch : `step-5/webjars`**

This branch show the use of webjars for HTMX and style the application

Step 6
-

**Scoped branch : `step-6/beer-details`**

This branch add beer detail dialog component and API routing for beer details

Step 7
-

**Scoped branch : `step-7/add-beer`**

This final branch add form to create and add a new beer.
