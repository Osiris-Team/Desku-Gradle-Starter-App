# Desku-Gradle-Starter-App
Example starter [Desku](https://github.com/Osiris-Team/Desku) app, built with Gradle.

## Platforms

- `core` / `com.author.core`: Main module with the application logic shared by all platforms.
- `desktop` / `com.author.desktop`: Primary desktop platform using Swing and JCEF. `build.gradle` file generates Windows/Linux/Mac installers and binaries
with the help of [JavaPackager](https://github.com/fvarrui/JavaPackager).
- `android` / `com.author.android`: Android mobile platform. Needs Android SDK.
- `ios` / `com.author.ios`: iOS mobile platform using RoboVM.
- `.github/workflows/release.yml` workflow file that creates a release, generates and uploads
    all supported, platform-specific installers/binaries. Head over to the 'Actions' tab,
    select 'release' and press on 'Run Workflow' to execute it.

## Android
Create the `local.properties` file in this directory looking like this:
```properties
# Location of the Android SDK:
sdk.dir=C:/Users/INSERT_USER_NAME/AppData/Local/Android/Sdk
```
Note that renaming directories can be a bit tricky, specially for the namespace `com.author.android`
since it's referenced in `build.gradle` and `AndroidManifest.xml`, thus remember to
change those too.

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
