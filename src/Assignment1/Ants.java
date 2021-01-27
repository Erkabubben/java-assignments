/**
 * Ants
 * 
 * @version 1.0 21 Jan 2021
 * @author Erik Lindholm
 */
package Assignment1;
import java.util.Random;
/**
 * Simulation of the movements of an ant over a chessboard. The simulation ends when
 * all squares have been visited. Will run a specified amount of times, and then
 * print out the average amount of steps that it took for the ant to finish.
 */
public class Ants {

    /* Runs the Ant simulator a specified amount of times and then displays the average amount of
       steps that it took for the ant to finish */
    public static void RunMultipleSimulationsAndDisplayAverage(int timesToRunSimulation, int boardSizeX, int boardSizeY) {

        int totalSteps = 0;

        /* Run simulation the specified amount of times */
        for (int i = 1; i < (timesToRunSimulation + 1); i++) {
            int simulationResult = RunSimulation(boardSizeX, boardSizeY);
            System.out.println("Number of steps in simulation " + i + ": " + simulationResult);
            totalSteps += simulationResult;
        }

        /* Calculate and print average amount of steps */
        System.out.println("Average amount of steps: " + ((totalSteps * 1.0) / timesToRunSimulation));
    }

    /* Simulates an ant's random movements over a chessboard, and returns the amount of steps it
       takes the ant to cover all the squares of the board ("steps" here refers to moving from one
       square to another - not actual ant steps.) */
    public static int RunSimulation(int boardSizeX, int boardSizeY) {

        Random rn = new Random();

        boolean[][] chessBoard = new boolean[boardSizeX][boardSizeY];

        int antX = rn.nextInt(boardSizeX) + 1;
        int antY = rn.nextInt(boardSizeY) + 1;

        int steps = 0;
        int squaresVisited = 0;

        while(squaresVisited < (boardSizeX * boardSizeY)) {
            /* Check if square is visited */
            if (chessBoard[antX - 1][antY - 1] == false) {
                chessBoard[antX - 1][antY - 1] = true;
                squaresVisited++;
            }
            /* Determine direction for next move */
            while(true) {
                int newDirection = rn.nextInt(4);
                if (newDirection == 0 && antX != boardSizeX) {   // Right
                    antX++;
                    break;
                } else if (newDirection == 1 && antX != 1) {    // Left
                    antX--;
                    break;
                } else if (newDirection == 2 && antY != boardSizeY) {    // Down
                    antY++;
                    break;
                } else if (newDirection == 3 && antY != 1) {    // Up
                    antY--;
                    break;
                }
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {

        System.out.println("Ants");
        System.out.println("====");
        System.out.println("");

        RunMultipleSimulationsAndDisplayAverage(10, 8, 8);
    }
}
