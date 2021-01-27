package Assignment1;
import java.util.Scanner;
import Assignment1.DayOfWeek;

public class PrintCalendar {

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
                    while (s.length() < 4) {
                        s = " " + s;
                    }
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

        int dayOfWeekOf1st = ((DayOfWeek.CalculateDayOfWeek(year, month, 1) - 2) + 7) % 7;
        int amountOfDaysOfMonth = AmountOfDaysOfMonth(year, month);

        int[][] calendar = CreateCalendarArray(dayOfWeekOf1st, amountOfDaysOfMonth);

        System.out.println(MonthIntToString(month) + " " + year);
        PrintCalendarArray(calendar);
    }
}
