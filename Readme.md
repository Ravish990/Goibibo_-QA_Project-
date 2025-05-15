# 🧪 Goibibo QA Automation Project

An automated UI testing framework for Goibibo using modern testing practices.

## ✨ Key Features

- **Java + Selenium WebDriver** for browser automation
- **TestNG** for test execution and reporting
- **Page Object Model (POM)** for maintainable code
- **Maven** for dependency management
- **Data-Driven Testing** with Excel/CSV
- **Screenshot Capture** for debugging
- **WebDriverManager** for driver setup

## 📁 Project Structure

project2/
├── pom.xml
├── screenshots/               # Captured screenshots
├── test-output/              # TestNG reports
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/         # Base WebDriver setup
│   │   │   ├── pages/        # Page classes
│   │   │   ├── utilities/    # Utility classes
│   │   └── resources/
│   │       └── config.properties
│   ├── test/
│   │   ├── java/
│   │   │   └── testng/       # Test classes
│   │   └── resources/
|   |       |---config.properties
│   │       ├── testData.xlsx # Test data
│   │       └── test.csv


## ⚙️ Prerequisites

- Java 8+
- Maven 3.6+
- Chrome browser

## 🚀 Setup Instructions

1. Clone the repository:
   
   git clone https://github.com/Ravish990/Goibibo_-QA_Project-.git
   cd goibibo

2. Install dependencies:

     mvn clean install
3.  Run all tests:

     mvn test
     
## ✅ Best Practices Implemented

Page Object Model for better maintainability
External configuration for environment flexibility
Organized Maven project structure
WebDriver lifecycle management
Test data externalization