# Simple Console Calculator

A straightforward, console-based calculator built with Java. This project is designed to demonstrate basic Java syntax, control flow, user input handling, and error checking.

## ✨ Features

* **Basic Arithmetic**: Performs addition (+), subtraction (-), multiplication (*), and division (/).
* **Continuous Calculations**: A loop allows you to perform multiple calculations without restarting the program.
* **Error Handling**: Includes a check to prevent division by zero.

## 🚀 How to Run

You must have the Java Development Kit (JDK) installed.

1.  **Save the Code**: Save the code above into a file named `SimpleCalculator.java`.

2.  **Compile the Code**: Open a terminal or command prompt, navigate to the directory where you saved the file, and run the following command:
    ```sh
    javac SimpleCalculator.java
    ```

3.  **Run the Application**: Once compiled, run the application with this command:
    ```sh
    java SimpleCalculator
    ```

## Sample Interaction

Here is an example of what you'll see when you run the calculator:

```
--- Simple Console Calculator ---
Enter the first number: 50
Enter the operator (+, -, *, /): *
Enter the second number: 4
The result is: 50.0 * 4.0 = 200.0

Perform another calculation? (yes/no): yes
---------------------------------
Enter the first number: 10
Enter the operator (+, -, *, /): /
Enter the second number: 0
Error: Division by zero is not allowed.

Perform another calculation? (yes/no): no
---------------------------------
Calculator closed. Thank you!
```
