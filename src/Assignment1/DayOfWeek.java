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

        /* Determine which day to print based on dayOfWeek number */
        String dayOfWeekString = "";
        switch (dayOfWeek) {
            case 0:
                dayOfWeekString = "Saturday";
                break;
            case 1:
                dayOfWeekString = "Sunday";
                break;
            case 2:
                dayOfWeekString = "Monday";
                break;
            case 3:
                dayOfWeekString = "Tuesday";
                break;
            case 4:
                dayOfWeekString = "Wednesday";
                break;
            case 5:
                dayOfWeekString = "Thursday";
                break;
            case 6:
                dayOfWeekString = "Friday";
                break;
            default:
                break;
        }

        /* Print day of week */
        System.out.println("Day of week is " + dayOfWeekString);
        in.close();
    }
}
