/**
 * PrintCalendar
 * 
 * @version 1.0 21 Jan 2021
 * @author Erik Lindholm
 */
package Assignment1;
import java.util.Scanner;
/**
 * Prints a calendar of a specified month of a year after 1800 to the terminal.
 */
public class PrintCalendar {

    /* Returns the amount of days in a specified month of a year. Takes leap years
       into account. */
    public static int AmountOfDaysOfMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 2) {
            if (YearIsLeapYear(year)) {
                return 29;
            }
            else {
                return 28;
            }
        } else {
            return 30;
        }
    }

    /* Determines whether a given year is a leap year and returns true or false */
    public static boolean YearIsLeapYear(int year) {
        if (!(year % 4 == 0)) {
            return false;
        } else if (!(year % 100 == 0)) {
            return true;
        } else if (!(year % 400 == 0)) {
            return false;
        } else {
            return true;
        }
    }

    /* Takes a month number (1-12) and returns the name of the month */
    public static String MonthIntToString(int month) {
        String[] months = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        };
        return months[month - 1];
    }

    /* Creates a two-dimensional int array representing a calendar month. */
    public static int[][] CreateCalendarArray(int dayOfWeekOf1st, int amountOfDaysOfMonth) {

        boolean isSettingNumbersToArray = false;
        int dayCounter = 1;
        int[][] calendar = new int[7][6];

        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 7; x++) {
                if (y == 0 && x == dayOfWeekOf1st) {
                    isSettingNumbersToArray = true;
                }
                if (isSettingNumbersToArray) {
                    calendar[x][y] = dayCounter;
                    dayCounter++;
                    if (dayCounter > amountOfDaysOfMonth) {
                        isSettingNumbersToArray = false;
                    }
                }
            }
        }

        return calendar;
    }

    /* Pads a string with a specified amount of leading characters, such as spaces or zeroes. */
    public static String PadStringWithLeadingChars(String s, char c, int stringLength) {
        while (s.length() < stringLength) {
            s = c + s;
        }

        return s;
    }

    /* Takes a 2D array representing a month calendar and prints it to the console. */
    public static void PrintCalendarArray(int[][] calendar) {

        System.out.println("-----------------------------");
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");

        for (int y = 0; y < 6; y++) {
            if (y == 5 && calendar[0][y] == 0) {
                break;
            } else {
                for (int x = 0; x < 7; x++) {
                    String s = "";
                    if (calendar[x][y] != 0) {
                        s = String.valueOf(calendar[x][y]);
                    }
                    s = PadStringWithLeadingChars(s, ' ', 4);
                    System.out.print(s);
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        /* Ask user for year and month */
        System.out.print("Enter a year after 1800: ");
        int year = in.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = in.nextInt();

        /* Determine the day of week of the first day of the month, and the amount of days of the month */
        int dayOfWeekOf1st = ((DayOfWeek.CalculateDayOfWeek(year, month, 1) - 2) + 7) % 7;
        int amountOfDaysOfMonth = AmountOfDaysOfMonth(year, month);

        /* Create and print calendar month */
        int[][] calendar = CreateCalendarArray(dayOfWeekOf1st, amountOfDaysOfMonth);

        System.out.println(MonthIntToString(month) + " " + year);
        PrintCalendarArray(calendar);

        in.close();
    }
}
