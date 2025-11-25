import java.util.Scanner; // Tool to read user input
import java.util.Random;  // Tool to generate random numbers

public class NumberGuessingGame {

    public static void main(String[] args) {
        // 1. Setup our tools
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 2. Generate the secret number (0 to 99) + 1 -> (1 to 100)
        int secretNumber = random.nextInt(100) + 1;
        
        // 3. Initialize variables to track the game state
        int userGuess = 0;
        int attempts = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("Can you guess what it is?");

        // 4. The Game Loop: Keep asking until they get it right
        while (userGuess != secretNumber) {
            System.out.print("Enter your guess: ");
            
            // Validation: Check if the user actually entered a number
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                attempts++; // Increment attempt counter

                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("CORRECT! You won!");
                    System.out.println("It took you " + attempts + " tries.");
                }
            } else {
                // Handle invalid input (like letters)
                System.out.println("That's not a valid number! Please enter an integer.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        // 5. Cleanup
        scanner.close();
    }
}