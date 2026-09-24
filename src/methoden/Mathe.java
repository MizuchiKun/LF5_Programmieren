package methoden;

public class Mathe {
    /** Round the given double to the given number of decimal places.
     *
     * @param value The double to be rounded.
     * @param decimalPlaces The number of decimal places to round to.<br/>
     *                      Supports negative values to round to 1s, 10s, 100s, etc.
     * @return The result of the rounding.
     */
    public static double runden(double value, int decimalPlaces) {
        double helperPower = Math.pow(10, decimalPlaces);
        return Math.round(helperPower * value) / helperPower;
    }
}
