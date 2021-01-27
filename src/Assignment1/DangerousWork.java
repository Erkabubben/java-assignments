/**
 * DangerousWork
 * 
 * @version 1.0 21 Jan 2021
 * @author Erik Lindholm
 */
package Assignment1;
import java.util.Scanner;
/**
 * Calculates how many days it will take to earn a certain salary on a job that
 * starts off with a pay of 0.01 and then doubles the salary every day. The maximum
 * amount of days on the job is set to 30 by default.
 */
public class DangerousWork {
    public static int CalculateDaysToEarnSalary(double startSalary, int endSalary, int dayLimit) {
        double salary = startSalary;
        int days = 0;

        while (salary < endSalary && days < dayLimit) {
            salary = salary * 2;
            days++;
        }

        return days;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("How much would you like to earn? ");
        int endSalary = in.nextInt();
        
        System.out.println("You will have your money in " + CalculateDaysToEarnSalary(0.01, endSalary, 30) + " days.");

        in.close();
    }
}
