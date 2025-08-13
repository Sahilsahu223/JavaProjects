import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepCalculating = true;

        System.out.println("--- Simple Console Calculator ---");

        while (keepCalculating) {
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            double result = 0.0;
            boolean validOperation = true;
            switch (operator) {
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = divide(num1, num2);
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator. Please use +, -, *, or /.");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("The result is: " + num1 + " " + operator + " " + num2 + " = " + result);
            }


            System.out.print("\nPerform another calculation? (yes/no): ");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                keepCalculating = false;
            }
            System.out.println("---------------------------------");
        }

        System.out.println("Calculator closed. Thank you!");
        scanner.close();
    }
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}