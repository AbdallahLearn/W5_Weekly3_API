# Country & City Explorer App

## Project Overview
The **Country & City Explorer** is an Android application built using **Jetpack Compose** that allows users to browse countries, view states within a country, and explore cities in a state. The app follows the **MVI (Model-View-Intent) pattern** and implements **Clean Architecture**, ensuring modular, maintainable, and scalable code.

## Features Implemented
- **Country List Screen**
  - Fetches country data asynchronously using a REST API.
  - Displays a list of countries using `LazyColumn`.
  - Shows only the country name and code.
  - Clicking on a country navigates to the **States List Screen**.
- **State & City Detail Screens with Navigation**
  - Clicking on a country fetches its states using `/countries/{country_code}/states`.
  - Clicking on a state fetches its cities using `/countries/{country_code}/states/{state_code}/cities`.
  - Implements a **generic network response handler** using sealed classes.
  - Uses **Coroutines & Flow** for efficient API calls.
- **Dark Mode & Theming**
  - Supports both **light and dark themes** using MaterialTheme API.
  - Custom typography and color schemes.
  - Theme toggle switch in the UI.
- **Clean Architecture Implementation**
  - **Data Layer**: API service, Repository implementation.
  - **Domain Layer**: UseCases for business logic.
  - **Presentation Layer**: ViewModel, UI components.

## Technologies Used
- **Jetpack Compose** (UI Toolkit)
- **Kotlin**
- **Coroutines & Flow** (For asynchronous programming)
- **Retrofit** (For REST API integration)
- **StateFlow** (For state management in MVI architecture)
- **Navigation Component** (For handling navigation between screens)
- **MaterialTheme API** (For UI theming)

## API Reference
The app fetches data from the following API endpoints:
- **Get Countries:** `GET /countries`
- **Get States in a Country:** `GET /countries/{country_code}/states`
- **Get Cities in a State:** `GET /countries/{country_code}/states/{state_code}/cities`

[API Documentation](https://documenter.getpostman.com/view/1134062/T1LJjU52#dd5bd0d9-2602-4161-8c77-3af30cd2f41a)

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/AbdallahLearn/W5_Weekly3_API.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle dependencies.
4. Run the app on an emulator or a physical device.

## Future Enhancements
- Implement **authentication handling** using interceptors.
- Add **network request logging**.
- Handle **connection timeouts** efficiently.
- Support **offline caching** for API data.

---
This project is part of an assignment to practice **REST API integration, Clean Architecture, and Jetpack Compose best practices**. 🚀

