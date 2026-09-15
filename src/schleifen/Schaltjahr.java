package schleifen;

import utils.UserInput;

import java.util.ArrayList;

public class Schaltjahr {
    private static boolean isLeapYear(short year) {
        return year % 400 == 0
               || (year % 4 == 0 && year % 100 != 0);
    }

    /** Returns an array of all the leap years in the given range.
     *
     * @param startYear The first year of the range.
     * @param endYear The last year of the range.
     * @return An array of all leap years in the range.
     */
    public static short[] leapYearsInRange(short startYear, short endYear) {
        ArrayList<Short> leapYearsList = new ArrayList<Short>();
        for (short year = startYear; year <= endYear; year++) {
            if (isLeapYear(year)) {
                leapYearsList.add(year);
            }
        }

        short[] leapYears = new short[leapYearsList.size()];
        for (short i = 0; i < leapYearsList.size(); i++) {
            leapYears[i] = leapYearsList.get(i);
        }

        return leapYears;
    }

    public static void main(String[] args) {
        boolean repeatCalculation = false;
        do {
            short startYear = UserInput.readShort("Start year of range? ");
            short endYear = UserInput.readShort("End year of range? ");
            short[] leapYears = leapYearsInRange(startYear, endYear);
            for (short year : leapYears) {
                System.out.println(year);
            }

            String repeatInput = UserInput.readString("Do another calculation(y/n)? ");
            repeatCalculation = repeatInput.toLowerCase().startsWith("y");
        } while (repeatCalculation);
    }
}
