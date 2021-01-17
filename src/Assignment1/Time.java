/**
 * 
 */
package Assignment1;
import java.util.Scanner;

/**
 * @author Erik Lindholm
 *
 */
public class Time {

    /**
	 * @param args
	 */
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
