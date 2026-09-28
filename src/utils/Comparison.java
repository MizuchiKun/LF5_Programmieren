package utils;

public class Comparison {
    /** Checks if the two values are equal/close. <br/>
     *  They're considered close when their difference is smaller than the given relTolerance or absTolerance.
     *
     * @param a The first value to compare.
     * @param b The second value to compare.
     * @param relTolerance The relative tolerance. Relative to the larger of the two values.
     * @param absTolerance The absolute tolerance.
     * @return True if the values' difference is smaller than relTolerance or absTolerance.
     */
    public static boolean doublesAreClose(double a, double b, double relTolerance, double absTolerance) {
        double absDifference = Math.abs(a - b);
        double relDifference = absDifference / Math.max(a, b);
        return relDifference <= relTolerance || absDifference <= absTolerance;
    }

    /** Checks if the two values are equal/close. <br/>
     *  They're considered close when their difference is smaller than the given relTolerance. <br/>
     *  (By default, absTolerance is 0.0.)
     *
     * @param a The first value to compare.
     * @param b The second value to compare.
     * @param relTolerance The relative tolerance. Relative to the larger of the two values.
     * @return True if the values' difference is smaller than relTolerance.
     */
    public static boolean doublesAreClose(double a, double b, double relTolerance) {
        return doublesAreClose(a, b, relTolerance, 0.0);
    }

    /** Checks if the two values are equal/close. <br/>
     *  They're considered close when their difference is smaller than relTolerance or absTolerance. <br/>
     *  (By default, relTolerance is 1e-9, absTolerance is 0.0.)
     *
     * @param a The first value to compare.
     * @param b The second value to compare.
     * @return True if the values are close.
     */
    public static boolean doublesAreClose(double a, double b) {
        return doublesAreClose(a, b, 1e-9, 0.0);
    }
}
