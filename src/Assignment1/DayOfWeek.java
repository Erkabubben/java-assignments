/**
 * 
 */
package Assignment1;
import java.util.Scanner;

/**
 * @author Erik Lindholm
 *
 */
public class DayOfWeek {
    /**
     * Determines which day to print based on dayOfWeek number.
     */
    public static String DayOfWeekString (int dayOfWeek) {
        switch (dayOfWeek) {
            case 0:
                return "Saturday";
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            default:
                return "";
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        /* Ask user for year, month and day of month */
        System.out.print("Enter year: ");
        int year = in.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = in.nextInt();
        System.out.print("Enter day of the month (1-31): ");
        int dayOfMonth = in.nextInt();

        /* Adjust month */
        if (month == 1) {
            month = 13;
            year--;
        } else if (month == 2) {
            month = 14;
            year--;
        }

        /* Calculate day of week */
        int dayOfWeek = (dayOfMonth + ((26 * (month + 1)) / 10) + (year % 100) + ((year % 100) / 4) + ((year / 100) / 4) + (5 * (year / 100))) % 7;

        /* Print day of week */
        System.out.println("Day of week is " + DayOfWeekString(dayOfWeek));
        in.close();
    }
}
