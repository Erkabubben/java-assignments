/**
 * 
 */
package Assignment1;
import java.util.Scanner;

/**
 * @author Erik Lindholm
 *
 */
public class DangerousWork {
    
    /**
	 * @param args
	 */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("How much would you like to earn? ");
        int endSalary = in.nextInt();
        
        double salary = 0.01;
        int days = 0;

        while (salary < endSalary && days < 30) {
            salary = salary * 2;
            days++;
        }

        System.out.println("You will have your money in " + days + " days.");

        in.close();
    }
}
