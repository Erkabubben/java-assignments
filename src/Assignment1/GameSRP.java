/**
 * GameSRP
 * 
 * @version 1.0 21 Jan 2021
 * @author Erik Lindholm
 */
package Assignment1;
import java.util.Scanner;
import java.util.Random;
/**
 * Simulates a game of scissors-rock-paper between the user and the computer.
 * The game will repeat until the player inputs 0, at which point the total
 * score will be presented and the game will close.
 */
public class GameSRP {

    /* Returns the given scissors-rock-paper choice number as a string.*/
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

    /* Determines winner the winner of a session of scissors-rock-paper. Will return -1
       on a player loss, 0 on a tie and 1 on a player win. */
    public static int DetermineSRPWinner(int playerChoice, int computerChoice) {
        if (playerChoice == 1) { // Player chose scissor
            if (computerChoice == 1) { // Computer chose scissor = Tie
                return 0;
            } else if (computerChoice == 2) { // Computer chose rock = Loss
                return -1;
            } else if (computerChoice == 3) { // Computer chose scissor = Win
                return 1;
            } else {
                return 0;
            }
        } else if (playerChoice == 2) { // Player chose rock
            if (computerChoice == 1) { // Computer chose scissor = Win
                return 1;
            } else if (computerChoice == 2) { // Computer chose rock = Tie
                return 0;
            } else if (computerChoice == 3) { // Computer chose paper = Loss
                return -1;
            } else {
                return 0;
            }
        } else if (playerChoice == 3) { // Player chose paper
            if (computerChoice == 1) { // Computer chose scissor = Loss
                return -1;
            } else if (computerChoice == 2) { // Computer chose rock = Win
                return 1;
            } else if (computerChoice == 3) { // Computer chose paper = Tie
                return 0;
            } else {
                return 0;
            }
        } else {
            return 0;
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
            System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");
            playerChoice = in.nextInt();
            
            if (playerChoice != 0) {

                int computerChoice = rn.nextInt(3) + 1;

                int winOrLoss = DetermineSRPWinner(playerChoice, computerChoice);

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
        in.close();
    }
}
