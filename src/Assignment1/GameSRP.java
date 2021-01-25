/**
 * 
 */
package Assignment1;
import java.util.Scanner;
import java.util.Random;

/**
 * @author Erik Lindholm
 *
 */
public class GameSRP {
    /**
     * Returns the given scissors-rock-paper choice number as a string.
     */
    public static String IntToStringSRP (int choice) {
        if (choice == 1) {
            return "scissor";
        } else if (choice == 2) {
            return "rock";
        } else if (choice == 3) {
            return "paper";
        } else {
            return "";
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rn = new Random();

        int playerChoice = 0;
        int playerScore = 0;
        int computerScore = 0;
        int draws = 0;

        do {
            System.out.println("Scissor (1), rock (2), paper (3) or 0 to quit: ");
            playerChoice = in.nextInt();
            
            if (playerChoice != 0) {

                int computerChoice = rn.nextInt(3) + 1;
                int winOrLoss = 0;

                /* Determine winner */
                if (playerChoice == 1) { // Player chose scissor
                    if (computerChoice == 1) { // Computer chose scissor = Tie
                        winOrLoss = 0;
                    } else if (computerChoice == 2) { // Computer chose rock = Loss
                        winOrLoss = -1;
                    } else if (computerChoice == 3) { // Computer chose scissor = Win
                        winOrLoss = 1;
                    }
                } else if (playerChoice == 2) { // Player chose rock
                    if (computerChoice == 1) { // Computer chose scissor = Win
                        winOrLoss = 1;
                    } else if (computerChoice == 2) { // Computer chose rock = Tie
                        winOrLoss = 0;
                    } else if (computerChoice == 3) { // Computer chose paper = Loss
                        winOrLoss = -1;
                    }
                } else if (playerChoice == 3) { // Player chose paper
                    if (computerChoice == 1) { // Computer chose scissor = Loss
                        winOrLoss = -1;
                    } else if (computerChoice == 2) { // Computer chose rock = Win
                        winOrLoss = 1;
                    } else if (computerChoice == 3) { // Computer chose paper = Tie
                        winOrLoss = 0;
                    }
                }

                /* Announce winner (or tie). */
                if (winOrLoss == -1) {
                    System.out.println("You lost, computer had " + IntToStringSRP(computerChoice) + "!");
                    computerScore++;
                } else if (winOrLoss == 0) {
                    System.out.println("It's a draw!");
                    draws++;
                } else if (winOrLoss == 1) {
                    System.out.println("You won, computer had " + IntToStringSRP(computerChoice) + "!");
                    playerScore++;
                }
            }

        } while (playerChoice != 0);

        System.out.println("Score: " + playerScore + " (you) " + computerScore + " (computer) " + draws + " (draw).");
    }
}
