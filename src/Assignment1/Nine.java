/**
 * 
 */
package Assignment1;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

/**
 * @author Erik Lindholm
 *
 */
public class Nine {

    static Random random = new Random();
    
    /**
	 * @param args
	 */
    public static void main(String[] args) {

        int playerDie1 = 0;
        int playerDie2 = 0;
        int computerDie1 = 0;
        int computerDie2 = 0;
        int playerTotal = 0;
        int computerTotal = 0;

        Scanner in = new Scanner(System.in);
        
        System.out.println("Playing a game");
        System.out.println("=================");
        System.out.println("");
        System.out.print("Ready to play? (Y/N) ");
        String ready = in.nextLine();

        // Ask if player is ready to play
        if (ready.toLowerCase().equals("y") || ready.toLowerCase().equals("yes")) {
            playerDie1 = random.nextInt(6) + 1;
            System.out.println("You rolled " + playerDie1);
            System.out.print("Would you like to roll again? (Y/N) ");
            String rollAgain = in.nextLine();

            // Ask if player wants to roll another die
            if (rollAgain.toLowerCase().equals("y") || rollAgain.toLowerCase().equals("yes")) {
                playerDie2 = random.nextInt(6) + 1;
                System.out.println("You rolled " + playerDie2 + " and in total you have " + (playerDie1 + playerDie2));
            }

            // Computer rolls first die
            computerDie1 = random.nextInt(6) + 1;
            System.out.println("The computer rolled " + computerDie1);

            // Computer decides wether to roll second die
            if (computerDie1 <= 4) {
                computerDie2 = random.nextInt(6) + 1;
                System.out.println("The computer rolls again and gets " + computerDie2 + " in total " + (computerDie1 + computerDie2));
            }

            // Caluclate total
            playerTotal = playerDie1 + playerDie2;
            computerTotal = computerDie1 + computerDie2;

            String winner = "";

            // Check if player is fat
            if (playerTotal >= 10) {
                System.out.println("Player is fat!");
                winner = "Computer";
                // Check if computer is also fat
                if (computerTotal >= 10) {
                    System.out.println("Computer is fat!");
                    winner = "Tie";
                }
            }

            // Check if computer is fat
            if (winner.equals("") && computerTotal >= 10) {
                System.out.println("Computer is fat!");
                winner = "Player";
            }

            // Otherwise, compare score and determine winner
            if (winner.equals("")) {
                int playerScore = Math.abs(9 - playerTotal);
                int computerScore = Math.abs(9 - computerTotal);
                if (playerScore < computerScore) {
                    winner = "Player";
                } else if (playerScore > computerScore) {
                    winner = "Computer";
                } else if (playerScore == computerScore) {
                    winner = "Tie";
                }
            }

            // Announce winner (or tie)
            if (winner.equals("Player")) {
                System.out.println("You won!");
            } else if (winner.equals("Computer")) {
                System.out.println("You lost!");
            } else if (winner.equals("Tie")) {
                System.out.println("It's a tie!");
            }
        }
    }
}
