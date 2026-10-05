package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Printer {
    public static final NumberFormat GERMAN_EURO_FORMAT =
            NumberFormat.getCurrencyInstance(Locale.GERMANY);
    public static final NumberFormat GERMAN_FLOAT_FORMAT =
            NumberFormat.getNumberInstance(Locale.GERMANY);

    // Add further methods.
}
