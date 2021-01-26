package Assignment1;
import java.util.Random;

public class Ants {

    /*public static int[] DetermineNextStep(int antX, int antY) {
        int[] nextStep = new int[2];

        if (antX != 8) {
            return int{1, 0};
        } else if (antX != 1) {

        }
    }*/

    public static void main(String[] args) {



        Random rn = new Random();

        boolean[][] chessBoard = new boolean[8][8];

        int antX = rn.nextInt(8) + 1;
        int antY = rn.nextInt(8) + 1;

        int steps = 0;
        int squaresVisited = 0;

        while(squaresVisited < 64 && steps < 10000) {
            if (chessBoard[antX][antY] == false) {
                chessBoard[antX][antY] = true;
                squaresVisited++;
            }
            while(true) {
                int newDirection = rn.nextInt(4);
                if (newDirection == 0 && antX != 8) {   // Right
                    antX++;
                    break;
                } else if (newDirection == 1 && antX != 1) {    // Left
                    antX--;
                    break;
                } else if (newDirection == 2 && antY != 8) {    // Down
                    antY++;
                    break;
                } else if (newDirection == 3 && antY != 1) {    // Up
                    antY--;
                    break;
                }
            }
            steps++;
        }
    }
}
