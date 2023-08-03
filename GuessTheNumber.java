import java.util.Scanner;
import java.util.Random;

// Game class
class Game {

    int systemInput;
    int userInput;
    int noOfGuesses = 0;

    // Default constructor: Generating random number
    Game() {
        Random random = new Random();
        this.systemInput = random.nextInt(100) + 1;
    }

    // Method to take user guesses
    public boolean takeUserInput() {
        if (noOfGuesses < 10) {
            System.out.print("Guess the number : ");
            this.userInput = GuessTheNumber.takeIntegerInput(100);
            noOfGuesses++;
            return false;
        } else {
            System.out.println("Number of attempts finished... Better luck next time\n");
            return true;
        }
    }

    // Method to check user guess status
    public boolean isCorrectGuess() {

        if (systemInput == userInput) {
            System.out.println("Congratulations, you guessed the number " + systemInput +
                    " in " + noOfGuesses + " guesses");

            // Assigning scores based on the number of attempts
            switch (noOfGuesses) {
                case 1:
                    System.out.println("Your score is 100");
                    break;
                case 2:
                    System.out.println("Your score is 90");
                    break;
                case 3:
                    System.out.println("Your score is 80");
                    break;
                case 4:
                    System.out.println("Your score is 70");
                    break;
                case 5:
                    System.out.println("Your score is 60");
                    break;
                case 6:
                    System.out.println("Your score is 50");
                    break;
                case 7:
                    System.out.println("Your score is 40");
                    break;
                case 8:
                    System.out.println("Your score is 30");
                    break;
                case 9:
                    System.out.println("Your score is 20");
                    break;
                case 10:
                    System.out.println("Your score is 10");
                    break;
            }
            System.out.println();
            return true;
        } else if (noOfGuesses < 10 && userInput > systemInput) {
            if (userInput - systemInput > 10) {
                System.out.println("Too High");
            } else {
                System.out.println("Little High");
            }
        } else if (noOfGuesses < 10 && userInput < systemInput) {
            if (systemInput - userInput > 10) {
                System.out.println("Too low");
            } else {
                System.out.println("Little low");
            }
        }
        return false;
    }
}

// Main class
public class GuessTheNumber {

    // Static method to take integer input without any limit and exception error
    // Handles exception handling and input limit handling
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                // Check if the input is within the specified limit
                if (flag && (input > limit || input < 1)) {
                    System.out.println("Choose a number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only an integer value");
                flag = false;
            }
        }
        return input;
    }

    // Main method
    public static void main(String[] args) {

        // Input for starting the game
        System.out.println("1. Start the Game \n2. Exit");
        System.out.print("Enter your choice : ");
        int choice = takeIntegerInput(2);
        int nextRound = 1;
        int noOfRound = 0;

        if (choice == 1) {

            // To check if the next round is there or not
            while (nextRound == 1) {
                // Creating an object of the Game class
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound " + ++noOfRound + " starts...");

                // To check correct guess and limit cross
                while (!isMatched && !isLimitCross) {
                    isLimitCross = game.takeUserInput();
                    isMatched = game.isCorrectGuess();
                }
                // Input for the next round
                System.out.println("1. Next Round \n2. Exit");
                System.out.println("Enter your choice : ");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}