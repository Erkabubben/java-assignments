/**
 * 
 */
package Assignment1;
import java.util.Scanner;

/**
 * @author Erik Lindholm
 *
 */
public class Diamonds {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int height = 0;

        while (height >= 0) {
            // Ask user to input diamond size
            System.out.print("Give a positive number: ");
            height = in.nextInt();

            System.out.println("");
        
            if (height > 0) {
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
        }

        in.close();
    }
}
