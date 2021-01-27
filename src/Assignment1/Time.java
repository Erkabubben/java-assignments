/**
 * Time
 * 
 * @version 1.0 21 Jan 2021
 * @author Erik Lindholm
 */
package Assignment1;
import java.util.Scanner;
/**
 * Asks the user to enter a number of seconds, then prints out the total
 * number of hours, minutes and seconds that the entered numbered equates to.
 */
public class Time {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        System.out.print("Give a number of seconds: ");
        int totalSeconds = in.nextInt();

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds - (hours * 3600) - (minutes * 60);

        System.out.print("This corresponds to: ");
        if (hours == 1) {
            System.out.print(hours + " hour, ");
        } else {
            System.out.print(hours + " hours, ");
        }
        
        if (minutes == 1) {
            System.out.print(minutes + " minute and ");
        } else {
            System.out.print(minutes + " minutes and ");
        }

        if (seconds == 1) {
            System.out.print(seconds + " second.");
        } else {
            System.out.print(seconds + " seconds.");
        }

        in.close();
    }
}
