FMT Pro Native

Description
FMT Pro Native is an Android application developed using Jetpack Compose. The project utilizes modern Android development practices including dependency injection with Hilt, UI components from Material Design 3, local database management with RoomDB, ViewModel for state management, and is written entirely in Kotlin.

Features
Jetpack Compose: A modern toolkit for building native UI.
Hilt: Dependency injection library for managing dependencies.
Material UI 3: Latest Material Design components.
RoomDB: Efficient and powerful SQLite database management.
ViewModel: Lifecycle-aware state management.
Kotlin: Modern, concise, and safe programming language for Android development.
Getting Started
Prerequisites
Android Studio Bumblebee or later
Kotlin 1.5.31 or later
Gradle 7.0 or later
Installation
Clone the repository:

sh
Copy code
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
Open the project in Android Studio:

Open Android Studio.
Select Open an existing Android Studio project.
Navigate to the cloned directory and select it.
Build the project:

Let Android Studio download and install the necessary dependencies.
Sync the Gradle files and build the project.
Project Structure
app/: Contains the main application code.
data/: Contains the data layer, including Room database entities and DAO interfaces.
di/: Contains Hilt modules and component definitions.
ui/: Contains Composables and UI logic.
viewmodel/: Contains ViewModel classes for managing UI-related data.
utils/: Utility classes and extension functions.
Libraries Used
Jetpack Compose: Declarative UI toolkit.
gradle
Copy code
implementation "androidx.compose.ui:ui:1.0.5"
implementation "androidx.compose.material:material:1.0.5"
implementation "androidx.compose.ui:ui-tooling-preview:1.0.5"
implementation "androidx.compose.runtime:runtime-livedata:1.0.5"
Hilt: Dependency Injection.
gradle
Copy code
implementation "com.google.dagger:hilt-android:2.40.5"
kapt "com.google.dagger:hilt-compiler:2.40.5"
implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
kapt "androidx.hilt:hilt-compiler:1.0.0"
Material UI 3: Latest Material Design components.
gradle
Copy code
implementation "com.google.android.material:material:1.4.0"
implementation "androidx.compose.material3:material3:1.0.0-alpha01"
RoomDB: SQLite Database.
gradle
Copy code
implementation "androidx.room:room-runtime:2.3.0"
kapt "androidx.room:room-compiler:2.3.0"
implementation "androidx.room:room-ktx:2.3.0"
ViewModel: Lifecycle-aware state management.
gradle
Copy code
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0"
Kotlin: Programming language.
gradle
Copy code
implementation "org.jetbrains.kotlin:kotlin-stdlib:1.5.31"
Usage
Define your data models and DAOs in the data package.
Create Hilt modules for dependency injection in the di package.
Implement your ViewModels in the viewmodel package.
Build your UI using Composables in the ui package, leveraging ViewModels for state management.
Run the application on an emulator or physical device.
Contributing
Fork the repository.
Create a new branch.
Make your changes.
Commit your changes.
Push to your fork and submit a pull request.
License
[Your Project Name] is licensed under the MIT License.

Contact
For any questions or feedback, please contact [your-email@example.com].
