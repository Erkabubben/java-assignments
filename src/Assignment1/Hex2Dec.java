/**
 *
 */
package Assignment1;
import java.util.Scanner;
import java.lang.Math;

/**
 * @author Erik Lindholm
 *
 */
public class Hex2Dec {

    public static int hexCharToInt(char c) {
        int cAscii = (int)c;
        if (cAscii >= 48 && cAscii <= 57 ) {
            return c - 48;
        } else if (cAscii >= 65 && cAscii <= 70 ) {
            return c - 65 + 10;
        } else if (cAscii >= 97 && cAscii <= 102 ) {
            return c - 97 + 10;
        } else {
            return -1;
        }
    }

    public static int hexToDecimal(String hex) {
        int total = 0;
        for (int i = 0; i < hex.length(); i++) {
            total += hexCharToInt(hex.charAt(i)) * Math.pow(16, (hex.length() - 1 - i));
        }
        return total;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a hex number: ");
        String enteredHex = in.nextLine();
        System.out.println("The decimal value for " + enteredHex + " is " + hexToDecimal(enteredHex) + ".");
    }
}
