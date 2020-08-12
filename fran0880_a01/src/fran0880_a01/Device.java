package fran0880_a01;
import java.util.Scanner;

public class Device {
    
    public static final int ORIGINYEAR = 1980;

    public static void main(String args[]) {
        // test code here
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter year: ");
        
        int userName = myObj.nextInt();  // Read user input
        int result = badCode(userName); 
        int result2 = goodCode(userName); 
        
        System.out.println("badcode - Days: " + userName + " = Year: " + result);
        System.out.println("goodCode - Days: " + userName + " = Year: " + result2);

        
        
    }

    /**
     * Supposedly calculates the year given days since ORIGINYEAR. Fails on a
     * leap year.
     * 
     * @param days
     *            number of days since January 1, 1980 (int >= 0)
     * @return the year given days
     */
    public static int badCode(int days) {
        int year = ORIGINYEAR; /* = 1980 */
        
        while( days > 365 ) {
          if(LeapYear.isLeapYear(year) ) {
            if( days > 366 ) {
              days -= 366;
              year += 1;
            }
          } else {
            days -= 365;
            year += 1;
          }
        }
        return year;
    }

    /**
     * Correctly calculates the year given days since ORIGINYEAR.
     * 
     * @param days
     *            number of days since January 1, 1980 (int >= 0)
     * @return the year
     */
    public static int goodCode(int days) {
        // method code here
        int year = ORIGINYEAR;
        
        while (days > 365) {
            if (LeapYear.isLeapYear(year)){
                if(days > 366) {
                    days -= 366;
                    year += 1;
                }
            }
            else {
                days -= 365;
                year += 1;
                
            }
        }
           
        return year;
    }
}