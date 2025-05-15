# 🧪 Goibibo QA Automation Project

Automated UI testing framework for Goibibo using modern best practices including:

- **Java + Selenium WebDriver**
- **TestNG**
- **Page Object Model (POM)**
- **Maven**
- **Data-Driven Testing** (Excel/CSV)
- **Property-Based Configuration**
- **Screenshot Capture**
- **WebDriverManager**

---

## 📁 Project Structure

project2/
├── pom.xml
├── screenshots/ # Captured screenshots saved here
├── test-output/ # TestNG output reports
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── base/ # Base WebDriver setup (Base.java)
│ │ │ ├── pages/ # Page classes (e.g., LoginPage.java)
│ │ │ ├── utilities/ # Utility classes (e.g., ScreenshotUtil.java)
│ │ └── resources/
│ │ └── config.properties # Configurable properties (URL, phone, etc.)
│
│ ├── test/
│ │ ├── java/
│ │ │ └── testng/ # Test classes (LoginTest, DataReader, etc.)
│ │ └── resources/
│ │ ├── testData.xlsx # Excel test data
│ │ └── test.csv # CSV test data



---

## ⚙️ Setup Instructions

1. **Clone the project**
   ```bash
   git clone <your-repo-url>
   cd project2
Install dependencies


mvn clean install
Requirements

Java 8 or above

Maven 3.6+

Chrome browser

🧾 config.properties
Located at: src/main/resources/config.properties

phone=9905534207

You can access these properties using Properties class in Java to keep your sensitive data out of code.

🧪 Running Tests
Run All Tests
mvn test
Run a Specific Test Class

mvn -Dtest=LoginTest test
📊 Data-Driven Testing
Data is provided from:

testData.xlsx (Excel)

test.csv (CSV)

Data is read using @DataProvider in DataReader.java. Example:


@DataProvider(name = "excelDataProvider")
public Object[][] excelDataProvider() { ... }

@DataProvider(name = "csvDataProvider")
public Object[][] csvDataProvider() { ... }
📸 Screenshots
Captured using ScreenshotUtil.java located in src/main/java/utilities/

Saved in the /screenshots/ directory.

Usage in any class:

java
Copy
Edit
ScreenshotUtil.takeScreenshot(driver, "screenshotName");
✅ Best Practices Followed
Page Object Model (POM) for reusability

Configurable and maintainable code structure

Externalized test data and properties

Organized folder structure using Maven conventions

WebDriver lifecycle managed via Base.java

🚀 Future Improvements
Add TestNG listeners for auto screenshot on failure

Integration with Allure or Extent Reports

Add cross-browser testing via config

Continuous Integration (CI) with Jenkins or GitHub Actions

Headless browser mode for CI

🧑‍💻 Author
This project is built as a part of QA automation learning for testing web applications like Goibibo.

Feel free to contribute, fork, or ask for feature enhancements.


---

Let me know if you want this exported as a downloadable `README.md` file or if you'd like to customize it further.