package fran0880_a01;

import java.util.Scanner;

public class LeapYear {

    public static void main(String args[]) {
        // test code here
        Scanner s = new Scanner(System.in);
        int a = 0;
        System.out.print("Enter year: ");
        a = s.nextInt();
        boolean c = isLeapYear(a);
        if (c==true) {
            System.out.println(a + " is a leap year");

        }
        else {
            System.out.println(a + " is not leap year");
        s.close();
        }
    }

    /**
     * Determines whether or not a year is a leap year.
     *
     * @param year
     *            The year to test (int > 0)
     * @return true is year is a leap year, false otherwise.
     */
    public static boolean isLeapYear(final int year) {
        // method code here
        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % 400 == 0)
                    return true;
                else
                    return false;
            }
            else
                return true;
        }
        else {
            return false;
        }

    }
}
  