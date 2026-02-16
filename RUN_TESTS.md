# Running TestNG Tests - Quick Guide

## ✨ Simplest Way to Run Tests

Open PowerShell in your project directory and run:

```powershell
mvn test
```

This will automatically pick up your **testng.xml** configuration thanks to the Maven Surefire plugin we added to pom.xml.

---

## 📋 Alternative Commands

### Run tests with verbose output
```powershell
mvn test -X
```

### Run tests and generate HTML report
```powershell
mvn test; mvn surefire-report:report
```

### Run specific test class
```powershell
mvn test -Dtest=com.combined.automation.stepDefinitions.LoginTest
```

### Run in IDE (JetBrains IntelliJ)
1. Right-click on **testng.xml** → Select **"Run 'testng.xml'"**
2. Or press **Ctrl+Shift+F10** on Windows

---

## 📊 View Test Reports

After running tests, check the reports:

### Surefire Reports (text format)
```
target/surefire-reports/
```

### HTML Report
```
target/site/surefire-report.html
```

Open the HTML report in your browser for a visual summary.

---

## ✅ What Gets Tested

Your testng.xml runs 6 test classes:
- ✔️ LoginTest
- ✔️ DropDown
- ✔️ WebTable
- ✔️ StaleTest
- ✔️ ShadowRootElement
- ✔️ AppTest

---

## 🔧 Troubleshooting

### Tests not running?
1. Ensure testng.xml is in the root of your project
2. Check if Java is installed: `java -version`
3. Check if Maven is installed: `mvn -version`

### Want to skip tests during Maven build?
```powershell
mvn clean install -DskipTests
```

### Clean build and run tests
```powershell
mvn clean test
```

---

## 📌 Notes

- Tests run **sequentially** (parallel="false" in testng.xml)
- Verbose level is set to **2** for detailed logging
- All dependencies are configured in pom.xml
- Reports are auto-generated in the `target` folder


