# Lab3 - Pizza Factory with Maven

This project demonstrates the Pizza Factory design pattern implemented in Java and built using Maven.

## Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

## How to Build and Run

1. Clone the repository:
   ```bash
   git clone https://github.com/viktor676/Cse2102.git
   cd Cse2102/Lab3
   ```

2. Build the project:
   ```bash
   mvn clean compile
   ```

3. Run the tests:
   ```bash
   mvn test
   ```

## Project Structure

```
Lab3/
├── src/
│   ├── main/java/           # Source files
│   │   ├── Pizza.java
│   │   ├── CheesePizza.java
│   │   ├── GlutenFreePizza.java
│   │   ├── GreekPizza.java
│   │   ├── PepperoniPizza.java
│   │   ├── PizzaFactory.java
│   │   ├── ConnecticutPizzaFactory.java
│   │   ├── PizzaStore.java
│   │   └── Main.java
│   └── test/java/           # Test files
│       └── PizzaFactoryTest.java
└── pom.xml                  # Maven configuration file
```

The project uses JUnit 4 for unit testing, which is automatically downloaded by Maven when building the project.