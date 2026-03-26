# WeatherDashboard

## Overview
WeatherDashboard is a comprehensive web application designed to provide users with real-time weather data, forecasts, and insights.

## Table of Contents
- [Setup Instructions](#setup-instructions)
- [API Configuration](#api-configuration)
- [Build Steps](#build-steps)
- [Feature Documentation](#feature-documentation)

## Setup Instructions
1. **Clone the repository**:
   ```bash
   git clone https://github.com/mayankjaiswal43416-netizen/Up.git
   cd Up
   ```
2. **Install dependencies**:
   ```bash
   npm install
   ```
3. **Create a `.env` file** in the root directory and configure the following environment variables:
   ```
   API_KEY=your_api_key_here
   ```
4. **Start the development server**:
   ```bash
   npm start
   ```

## API Configuration
The WeatherDashboard utilizes the OpenWeatherMap API to fetch weather data. To configure the API settings:
1. Sign up at [OpenWeatherMap](https://openweathermap.org/) and get your API key.
2. Replace `your_api_key_here` in the `.env` file with your API key.
3. Ensure your request limits are within the Free Tier limits unless you opt for a paid plan.

## Build Steps
To build the application for production, follow these steps:
1. Ensure all changes are committed.
2. Run the build command:
   ```bash
   npm run build
   ```
3. The production-ready files will be available in the `build/` directory.
4. Optionally, serve the build locally with:
   ```bash
   npm install -g serve
   serve -s build
   ```

## Feature Documentation
- **Real-Time Weather Updates**: Shows current weather data for selected cities.
- **5-Day Forecast**: Displays a 5-day weather forecast with detailed insights.
- **Search Interface**: Users can search for locations easily using an intuitive search bar.
- **User-Friendly Dashboard**: Provides a clean and organized visual layout for better user interaction.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.