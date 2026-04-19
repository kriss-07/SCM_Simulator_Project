# SCM Simulator - Android Integration Guide

Follow these steps to integrate the provided files into a new Android Studio project.

## 1. Create a New Project
1. Open **Android Studio**.
2. Click **New Project** -> Select **Empty Views Activity** -> Click Next.
3. Configure your project:
   - **Name:** SCM Simulator
   - **Package name:** `com.example.scmsimulator`
   - **Language:** **Java** (Make sure to select Java, not Kotlin).
   - **Minimum SDK:** API 24 (or standard default).
4. Click **Finish** and wait for the initial build to complete.

## 2. Copy the Java Files
In the provided files, you will find `models` and `activities` folders.
1. In Android Studio, navigate to `app/src/main/java/com/example/scmsimulator/`.
2. Right-click the `scmsimulator` folder -> **New** -> **Package**. Name it `models`.
3. Right-click the `scmsimulator` folder -> **New** -> **Package**. Name it `activities`.
4. Copy the generated files:
   - Put all the Java models (`CrewMember.java`, `Pilot.java`, `Location.java`, `Threat.java`, `Mission.java`, etc.) into the `models` package.
   - Put all the Activity files (`MainActivity.java`, `RecruitActivity.java`, etc.) into the `activities` package. *(Note: Delete the default `MainActivity.java` that Android Studio generated if it conflicts, or just replace its contents)*.
   - Put `GameManager.java` straight into `com.example.scmsimulator/`.

## 3. Copy the Layout Files (XML)
1. Navigate to `app/src/main/res/layout/`.
2. Copy all the provided `activity_*.xml` files here. *(Overwrite `activity_main.xml`)*.

## 4. Update the AndroidManifest.xml
For your Activities to work, they must be registered in the manifest.
1. Open `app/src/main/AndroidManifest.xml`.
2. Add the activity declarations inside the `<application>` tag, right after the MainActivity:

```xml
        <activity android:name=".activities.MainActivity" android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".activities.RecruitActivity" />
        <activity android:name=".activities.QuartersActivity" />
        <activity android:name=".activities.SimulatorActivity" />
        <activity android:name=".activities.MissionControlActivity" />
        <activity android:name=".activities.StatisticsActivity" />
```
*(Make sure to remove any duplicate MainActivity tags if they exist).*

## 5. Run the Project
Click the **Play** (Run) button at the top of Android Studio to build and launch the simulator on your emulator or physical device. Enjoy!
