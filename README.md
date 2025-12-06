🍕 Shopping Automation - Selenium Test Automation Framework

This project is a Selenium automation testing framework built using Java, TestNG, Maven, and Page Object Model (POM).
It automates functional workflows on the SauceDemo web application, performing real test scenarios like login, add to cart, product sorting, checkout, and more.

Features

✔ Page Object Model (POM)
✔ TestNG framework for test execution & grouping
✔ Maven for dependency management
✔ Parameterized test data using config.properties
✔ Reusable utility methods
✔ Multiple test scenarios (Smoke + Functional)
✔ Clean, scalable framework structure
✔ Git version-controlled project

Automated Test Scenarios
Test Case	Description
🔹 Login Test	Verifies valid login with correct credentials
🔹 Invalid Login Test	Ensures proper error validation for wrong credentials
🔹 Add Single Product to Cart	Verifies product successfully added
🔹 Add Multiple Products	Validates cart count and product names
🔹 Remove Product from Cart	Ensures item is correctly removed
🔹 Sort Products (Low → High Price)	Validates sorting functionality
🔹 Complete Checkout Flow	End-to-end test from login to order completion
🔹 Logout Test	Verifies successful logout


Project Structure
ShoppingAutomation/
 ├─ pom.xml
 ├─ src
 │  ├─ main
 │  │   ├─ java
 │  │   │   ├─ base
 │  │   │   │   └─ BaseTest.java
 │  │   │   ├─ pages
 │  │   │   │   ├─ LoginPage.java
 │  │   │   │   ├─ ProductsPage.java
 │  │   │   │   ├─ CartPage.java
 │  │   │   │   ├─ CheckoutStepOnePage.java
 │  │   │   │   ├─ CheckoutStepTwoPage.java
 │  │   │   │   └─ CheckoutCompletePage.java
 │  │   └─ resources
 │  │       └─ config.properties
 │  └─ test
 │      ├─ java
 │      │   └─ tests
 │      │       ├─ LoginTest.java
 │      │       ├─ InvalidLoginTest.java
 │      │       ├─ MultipleItemsCartTest.java
 │      │       ├─ RemoveItemFromCartTest.java
 │      │       └─ OrderFlow
