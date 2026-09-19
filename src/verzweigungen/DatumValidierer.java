package verzweigungen;

public class DatumValidierer {
    private static final byte JANUARY = 1, FEBRUARY = 2, MARCH = 3,
                              APRIL = 4, MAY = 5, JUNE = 6,
                              JULY = 7, AUGUST = 8, SEPTEMBER = 9,
                              OCTOBER = 10, NOVEMBER = 11, DECEMBER = 12;

    private static boolean isLeapYear(int year) {
        return year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0);
    }

    /** Checks if the given date is a valid date.
     *
     * @param day   The day of the date.
     * @param month The month of the date.
     * @param year  The year of the date.
     * @return  True if the date is valid, false otherwise.
     */
    public static boolean validiereDatum(int day, int month, int year) {
        boolean isALeapYear = isLeapYear(year);
        boolean isValidMonth = 1 <= month && month <= 12;
        if (!isValidMonth) {
            return false;
        }

        return switch (month) {
            case FEBRUARY -> isALeapYear ? 1 <= day && day <= 29
                                         : 1 <= day && day <= 28;
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 1 <= day && day <= 31;
            default -> 1 <= day && day <= 30;
        };
    }
}
