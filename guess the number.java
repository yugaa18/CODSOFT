import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        do {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between " + lowerBound + " and " + upperBound +
                    ". Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + generatedNumber);
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            } else {
                score += maxAttempts - attempts;
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("\nThank you for playing! Your total score is: " + score);
        scanner.close();
    }
}