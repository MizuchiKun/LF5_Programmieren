package utils;

@SuppressWarnings("unused")
public class Maths {
    /** Sums the given values. */
    public static double sum(double[] values) {
        double acc = 0;
        for (double value : values) {
            acc += value;
        }
        return acc;
    }

    /** Sums the given values. */
    public static long sum(long[] values) {
        long acc = 0;
        for (long value : values) {
            acc += value;
        }
        return acc;
    }

    /** Calculates the arithmetic mean of the given values. */
    public static double mean (double[] values) {
        return sum(values) / values.length;
    }

    /** Calculates the arithmetic mean of the given values. */
    public static double mean (long[] values) {
        return (double)sum(values) / values.length;
    }

    // TODO: Add any other functions, which are missing in java.lang.Math, here.
}
