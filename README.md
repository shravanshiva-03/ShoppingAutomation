# 🛒 Shopping Automation - Selenium Test Framework

This project automates multiple test scenarios on the **SauceDemo** web application using a Selenium-based automation framework.  
It follows automation best practices with a scalable and maintainable structure.

---

## 🚀 Features

- ✔️ Page Object Model (POM)
- ✔️ TestNG for test execution & grouping
- ✔️ Maven dependency management
- ✔️ Parameterized test data using `config.properties`
- ✔️ Reusable utility methods
- ✔️ Multiple test scenarios (Smoke + Functional)
- ✔️ Clean & structured framework (easy maintenance)

---

## 🧪 Automated Test Scenarios

| Test Case | Description |
|----------|------------|
| 🔹 Login Test | Valid login with correct credentials |
| 🔹 Invalid Login Test | Error validation for wrong credentials |
| 🔹 Add Single Product Test | Add a single product and verify cart |
| 🔹 Add Multiple Products Test | Validate product count and content |
| 🔹 Remove Product From Cart | Ensure selected item is removed |
| 🔹 Sort Products (Low → High) | Validate sorting functionality |
| 🔹 Checkout Flow | End-to-end order placement |
| 🔹 Logout Test | Verify successful logout and redirection |

---

## 📁 Project Structure

ShoppingAutomation/
├─ pom.xml
├─ README.md
├─ src
│ ├─ main
│ │ ├─ java
│ │ │ ├─ base
│ │ │ │ └─ BaseTest.java
│ │ │ ├─ pages
│ │ │ │ ├─ LoginPage.java
│ │ │ │ ├─ ProductsPage.java
│ │ │ │ ├─ CartPage.java
│ │ │ │ ├─ CheckoutStepOnePage.java
│ │ │ │ ├─ CheckoutStepTwoPage.java
│ │ │ │ └─ CheckoutCompletePage.java
│ │ └─ resources
│ │ └─ config.properties
│ └─ test
│ ├─ java
│ │ └─ tests
│ │ ├─ LoginTest.java
│ │ ├─ InvalidLoginTest.java
│ │ ├─ MultipleItemsCartTest.java
│ │ ├─ RemoveItemFromCartTest.java
│ │ ├─ SortAndLogoutTest.java
│ │ └─ OrderFlowTest.java
