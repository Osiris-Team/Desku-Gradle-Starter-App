# Desku-Starter-App
Example starter [Desku](https://github.com/Osiris-Team/Desku) app, built with 1JPM.

## ‼️ Good to know
Renaming folders: Use your IDEs' safe refactoring while renaming a folder,
meaning tick a box that says "check for usages" and ensure the path is updated in those usages too!

## Release
`.github/workflows/release.yml` (partially working): creates a release, generates and uploads
all supported, platform-specific installers and binaries. Head over to the 'Actions' tab,
select 'release' and press on 'Run Workflow' to execute it.

## Core 

To build execute: `cd core && java JPM.java`

**`com.author.shared`: the place where you will
develop your application with Desku. It contains the UI and application logic that
is shared by all platforms.**

If you don't want to use a platform below you can simply delete its directory
and remove the module name from ./settings.gradle file.

## Desktop (Windows/Linux/Mac)

To build execute: `cd desktop && java JPM.java`

`com.author.desktop`: uses [Swing](https://de.wikipedia.org/wiki/Swing_(Java)) and [WebView](https://github.com/webview/webview_java).
Its `JPM.java` file generates Windows/Linux/Mac installers with the help of [JavaPackager](https://github.com/fvarrui/JavaPackager).
The `.github/workflows/release.yml` also uses [GraalVM](https://www.graalvm.org/) and [Native Image](https://www.graalvm.org/22.0/reference-manual/native-image/) 
to generate standalone executables/binaries of your app.

## Android

To build execute: `cd android && java JPM.java`

`com.author.android`: uses the [Android WebView](https://developer.android.com/reference/android/webkit/WebView) and requires you
to have [Android Studio](https://developer.android.com/studio) installed.
Create the `local.properties` file in this directory looking like this:
```properties
# Location of the Android SDK:
sdk.dir=C:/Users/INSERT_USER_NAME/AppData/Local/Android/Sdk
```
Note that renaming directories can be a bit tricky, specially for the namespace `com.author.android`
since it's referenced in `JPM.java` and `AndroidManifest.xml`, thus remember to
change those too (you will also have to re-build/re-sync your project).

## iOS

To build execute: `cd ios && java JPM.java`

`com.author.ios` (not tested): uses [RoboVM](https://github.com/MobiVM/robovm) and its [WebView](https://github.com/robovm/robovm-samples/blob/master/ios-no-ib/samplewebapp-no-ib/src/main/java/org/robovm/samples/samplewebapp/ui/WebViewController.java).
Building this requires MacOS.
