package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Format {
    /** Formats the given number based on the arguments.<br/>
     *  (Uses the German decimal format symbols.)
     *
     * @param number The number to format.
     * @param floatDigits How many floating-point digits to show.
     * @param separateThousands Whether to show thousands' separators.
     * @return A String of the formatted German number.
     */
    public static String toGermanNumber(double number, int floatDigits, boolean separateThousands) {
        return toNumber(number, floatDigits, separateThousands, Locale.GERMANY);
    }

    /** Formats the given number based on the arguments.<br/>
     *  (Uses the German decimal format symbols.)<br/>
     *  (Shows thousands' separators.)
     *
     * @param number The number to format.
     * @param floatDigits How many floating-point digits to show.
     * @return A String of the formatted German number.
     */
    public static String toGermanNumber(double number, int floatDigits) {
        return toNumber(number, floatDigits, Locale.GERMANY);
    }

    /** Formats the given number based on the arguments.<br/>
     *  (Uses the German decimal format symbols.)<br/>
     *  (Shows 2 floating-point digits and thousands' separators.)
     *
     * @param number The number to format.
     * @return A String of the formatted German number.
     */
    public static String toGermanNumber(double number) {
        return toNumber(number, Locale.GERMANY);
    }

    /** Formats the given number based on the arguments.
     *
     * @param number The number to format.
     * @param floatDigits How many floating-point digits to show.
     * @param separateThousands Whether to show a thousands' separator.
     * @param locale The country-locale to use for the decimal format symbols.
     * @return A String of the formatted number.
     */
    public static String toNumber(double number,
                                  int floatDigits,
                                  boolean separateThousands,
                                  Locale locale) {
        String formatString = buildNumberFormatString(floatDigits, separateThousands);

        var format = new DecimalFormat(formatString, new DecimalFormatSymbols(locale));

        return format.format(number);
    }

    /** Formats the given number based on the arguments.<br/>
     *  (Shows thousands' separators.)
     *
     * @param number The number to format.
     * @param floatDigits How many floating-point digits to show.
     * @param locale The country-locale to use for the decimal format symbols.
     * @return A String of the formatted number.
     */
    public static String toNumber(double number, int floatDigits, Locale locale) {
        return toNumber(number, floatDigits, true, locale);
    }

    /** Formats the given number based on the arguments.<br/>
     *  (Shows 2 floating-point digits and thousands' separators.)
     *
     * @param number The number to format.
     * @param locale The country-locale to use for the decimal format symbols.
     * @return A String of the formatted number.
     */
    public static String toNumber(double number, Locale locale) {
        return toNumber(number, 2, true, locale);
    }

    private static String buildNumberFormatString(int floatDigits, boolean separateThousands) {
        var formatBuilder = new StringBuilder();

        if (separateThousands) {
            formatBuilder.append("#,##");
        }

        if (floatDigits > 0) {
            formatBuilder.append("0.");
        } else {
            formatBuilder.append("0");
        }

        for (byte i = 0; i < floatDigits; i++) {
            formatBuilder.append("0");
        }

        return formatBuilder.toString();
    }
}
