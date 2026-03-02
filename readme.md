# BMI Calculator (MAD Assignment)

A simple Android BMI (Body Mass Index) calculator built with **Kotlin** and **XML layouts**. The app collects basic profile details, calculates BMI using metric units, and shows the BMI category on a separate result screen.

## App Flow

1. **Main screen**: enter **Full Name**, **Age**, **Height (cm)**, and **Weight (kg)**.
2. Tap **Calculate BMI**.
3. **Result screen**: shows BMI (1 decimal place) + category, with a button to calculate again.

## Features

- Clean UI using Material Components
- Input validation with helpful error messages
- BMI calculation using metric units (cm/kg)
- Category highlighting on the result screen
- Data is processed locally (not stored)

## Input Validation Rules

The app validates input before navigating to the result screen:

- **Name**: required, at least 2 characters
- **Age**: 1–120
- **Height**: 50–250 cm
- **Weight**: 2–500 kg

## BMI Calculation

Height is entered in **cm** and converted to **meters**.

Plain formula:

BMI = weight(kg) / (height(m) × height(m))

$$\text{BMI} = \frac{\text{weight (kg)}}{\text{height (m)}^2}$$

BMI categories used:

- **Underweight**: < 18.5
- **Normal Weight**: 18.5 – 24.9
- **Overweight**: 25.0 – 29.9
- **Obese**: ≥ 30.0

## Tech Stack

- **Language**: Kotlin
- **UI**: XML layouts + Material Components
- **Architecture**: Activities + Intents (MainActivity → ResultActivity)
- **Build System**: Gradle (Kotlin DSL)
- **Min SDK**: 24

## Getting Started

### Prerequisites

- Android Studio (recent version)
- JDK 11 (as configured in Gradle)
- Android SDK / Emulator or a physical Android device

### Run in Android Studio

1. Open Android Studio
2. Select **Open** and choose the project folder
3. Let Gradle sync complete
4. Select an emulator/device
5. Click **Run**

### Build from the Command Line (Windows)

From the project root:

- Debug APK: `gradlew.bat assembleDebug`
- Unit tests: `gradlew.bat test`

## Project Structure (Key Files)

- app/src/main/java/com/example/bmi_calculator/MainActivity.kt
- app/src/main/java/com/example/bmi_calculator/ResultActivity.kt
- app/src/main/res/layout/activity_main.xml
- app/src/main/res/layout/activity_result.xml
- app/src/main/AndroidManifest.xml

## Screenshots

Add screenshots here (optional):

- Main Screen
- Result Screen

## Course Information

- **Students**: Mustafa (2023-CS-17) & Talha (2023-CS-169)
- **Course**: Mobile Application Development
- **Instructor**: Rabeeya Saleem
- **Semester**: 6
- **Assignment**: 1
