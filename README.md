# Offline User Directory App

## Overview
The **Offline User Directory App** is an Android application built with **Kotlin** and **Jetpack Compose** that displays a list of users fetched from a public API and stored locally using **Room Database**. The app follows an **offline-first architecture**, so users can view previously fetched data even without an internet connection.

- **App Name:** Offline User Directory App
- **API:** [JSONPlaceholder](https://jsonplaceholder.typicode.com/users)
- **Core Features:** Offline caching, local search, clean Compose UI

## Implementation

The app follows an offline-first architecture by storing users fetched from the API in a Room database and always displaying data from Room. Local search queries and API updates are handled via Flow in the ViewModel, ensuring the UI auto-updates and works offline.

---

## Features

1. **Offline-First Architecture**
   - Displays cached user data immediately from Room.
   - Fetches fresh data from API in the background.
   - Updates the local database automatically.
   - Keeps old data visible if API call fails.

2. **Local Search**
   - Search users by **name** or **email**.
   - Queries are performed locally on Room Database.
   - No network request is made for search.

3. **Clean UI**
   - Built using **Jetpack Compose**.
   - Displays user **ID, name, email, and phone**.
   - Scrollable list with updates.

---

## Implementation

- **Data Layer**
  - `Retrofit` fetches users from the API.
  - `Room Database` caches users for offline access.
  - `UserRepository` mediates between API and local database.

- **ViewModel**
  - Exposes **Flow/StateFlow** of users.
  - Handles search queries and offline-first data fetching.

- **UI Layer**
  - **Compose** screens display the user list.
  - Search bar filters users locally.
  - UI automatically updates when Room database changes.

---

## Screenshots

<img width="361" height="805" alt="Screenshot 1" src="https://github.com/user-attachments/assets/f97ab7fa-2665-470e-a420-479a9f13dc4a" />
<img width="360" height="804" alt="Screenshot 2" src="https://github.com/user-attachments/assets/56a2c068-5dc7-414d-be51-27245e4c0c90" />
<img width="358" height="806" alt="Screenshot 3" src="https://github.com/user-attachments/assets/e41a0f70-2c0d-4807-9355-0b01bc9f4b31" />


---

## Setup Instructions

1. Clone this repository: "git clone https://github.com/adamcha1/Offline-User-Directory-App.git"

2. Open the project in Android Studio Otter.

3. Make sure the plugin and dependencies are synced.

4. Build and run the app on the emulator.

5. Make sure the device has Internet permission in AndroidManifest.xml for the first time fetch.
