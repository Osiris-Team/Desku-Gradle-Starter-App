# Desku-Gradle-Starter-App
Example starter [Desku](https://github.com/Osiris-Team/Desku) app, built with Gradle.

## ‼️ Good to know
- Renaming folders: Use your IDEs' safe refactoring while renaming a folder,
meaning tick a box that says "check for usages" and ensure the path is updated in those usages too!
- ./settings.gradle contains a dependency checker/enforcer plugin that fails your build to ensure, that if there are multiple versions
of the same dependency the correct dependency is picked (see `rule(enforcer.rules.ForceDependencies)`).

## Release
`.github/workflows/release.yml` (partially working): creates a release, generates and uploads
all supported, platform-specific installers and binaries. Head over to the 'Actions' tab,
select 'release' and press on 'Run Workflow' to execute it.

## Core 
**`com.author.core`: the place where you will
develop your application with Desku. It contains the UI and application logic that
is shared by all platforms.**

If you don't want to use a platform below you can simply delete its directory
and remove the module name from ./settings.gradle file.

## Desktop (Windows/Linux/Mac)
`com.author.desktop`: uses [Swing](https://de.wikipedia.org/wiki/Swing_(Java)) and [WebView](https://github.com/webview/webview_java). 
Its `build.gradle` file generates Windows/Linux/Mac installers with the help of [JavaPackager](https://github.com/fvarrui/JavaPackager).
The `.github/workflows/release.yml` also uses [GraalVM](https://www.graalvm.org/) and [Native Image](https://www.graalvm.org/22.0/reference-manual/native-image/) 
to generate standalone executables/binaries of your app.

## Android
`com.author.android`: uses the [Android WebView](https://developer.android.com/reference/android/webkit/WebView) and requires you
to have [Android Studio](https://developer.android.com/studio) installed.
Create the `local.properties` file in this directory looking like this:
```properties
# Location of the Android SDK:
sdk.dir=C:/Users/INSERT_USER_NAME/AppData/Local/Android/Sdk
```
Note that renaming directories can be a bit tricky, specially for the namespace `com.author.android`
since it's referenced in `build.gradle` and `AndroidManifest.xml`, thus remember to
change those too (you will also have to re-build/re-sync your project).

## iOS
`com.author.ios` (not tested): uses [RoboVM](https://github.com/MobiVM/robovm) and its [WebView](https://github.com/robovm/robovm-samples/blob/master/ios-no-ib/samplewebapp-no-ib/src/main/java/org/robovm/samples/samplewebapp/ui/WebViewController.java).
Building this requires MacOS.

## Gradle
This project uses [Gradle](http://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `android:lint`: performs Android project validation.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `desktop:jar`: builds application's runnable jar, which can be found at `desktop/build/libs`.
- `desktop:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
