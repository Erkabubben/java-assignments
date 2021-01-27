/**
 * Diamonds
 * 
 * @version 1.0 21 Jan 2021
 * @author Erik Lindholm
 */
package Assignment1;
import java.util.Scanner;
/**
 * Prints out a diamond of asterisks to the terminal. The user is asked to input
 * the height of the diamond to be printed (from the top to the middle, the total
 * height will be twice the input number). The user will be asked to input a new
 * number until he/she inputs a negative number.
 */
public class Diamonds {

    /* Prints out a diamond of asterisks of the given height */
    public static void PrintDiamond(int height) {
        
        if (height > 0) {
            System.out.println("");
        }

        // Print upper half of diamond
        for (int i = 0; i < height; i++) {
            int spaces = height - (i + 1);
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (1 + (i * 2)); k++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        // Print lower half of diamond
        for (int i = (height - 1); i > 0; i--) {
            int spaces = height - i;
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < ((i * 2) - 1); k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int input = 0;

        while (input >= 0) {
            // Ask user to input diamond size
            System.out.print("Give a positive number: ");
            try {
                input = in.nextInt();
                PrintDiamond(input);
            } catch (Exception e) {
                System.out.println("Only positive numbers are allowed!");
                in.next();
            }
        }

        in.close();
    }
}
