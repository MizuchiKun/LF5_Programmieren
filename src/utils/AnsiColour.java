package utils;

/** Contains all the ANSI colour codes, as well as methods for the 256-colours and truecolors/RGB.<br/>
 *  (#AI I did use Claude to generate this, since I was too lazy to write all the codes myself.)
 */
public class AnsiColour {

    private AnsiColour() {}

    // Reset variables.
    public static final String RESET_ALL = "\u001B[0m";
    public static final String RESET_FOREGROUND = "\u001B[39m";
    public static final String RESET_BACKGROUND = "\u001B[49m";

    // Foreground (standard).
    public static final String BLACK   = "\u001B[30m";
    public static final String RED     = "\u001B[31m";
    public static final String GREEN   = "\u001B[32m";
    public static final String YELLOW  = "\u001B[33m";
    public static final String BLUE    = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN    = "\u001B[36m";
    public static final String WHITE   = "\u001B[37m";

    // Foreground (bright).
    public static final String BRIGHT_BLACK   = "\u001B[90m";
    public static final String BRIGHT_RED     = "\u001B[91m";
    public static final String BRIGHT_GREEN   = "\u001B[92m";
    public static final String BRIGHT_YELLOW  = "\u001B[93m";
    public static final String BRIGHT_BLUE    = "\u001B[94m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN    = "\u001B[96m";
    public static final String BRIGHT_WHITE   = "\u001B[97m";

    // Background (standard).
    public static final String BLACK_BACKGROUND   = "\u001B[40m";
    public static final String RED_BACKGROUND     = "\u001B[41m";
    public static final String GREEN_BACKGROUND   = "\u001B[42m";
    public static final String YELLOW_BACKGROUND  = "\u001B[43m";
    public static final String BLUE_BACKGROUND    = "\u001B[44m";
    public static final String MAGENTA_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND    = "\u001B[46m";
    public static final String WHITE_BACKGROUND   = "\u001B[47m";

    // Background (bright).
    public static final String BRIGHT_BLACK_BACKGROUND   = "\u001B[100m";
    public static final String BRIGHT_RED_BACKGROUND     = "\u001B[101m";
    public static final String BRIGHT_GREEN_BACKGROUND   = "\u001B[102m";
    public static final String BRIGHT_YELLOW_BACKGROUND  = "\u001B[103m";
    public static final String BRIGHT_BLUE_BACKGROUND    = "\u001B[104m";
    public static final String BRIGHT_MAGENTA_BACKGROUND = "\u001B[105m";
    public static final String BRIGHT_CYAN_BACKGROUND    = "\u001B[106m";
    public static final String BRIGHT_WHITE_BACKGROUND   = "\u001B[107m";

    // 256-colour and truecolor methods.
    public static String fg256(short n)                   { return String.format("\u001B[38;5;%dm", n); }
    public static String bg256(short n)                   { return String.format("\u001B[48;5;%dm", n); }
    public static String fgRgb(short r, short g, short b) { return String.format("\u001B[38;2;%d;%d;%dm", r, g, b); }
    public static String bgRgb(short r, short g, short b) { return String.format("\u001B[48;2;%d;%d;%dm", r, g, b); }

    /** Colours text via ANSI codes.<br/>
     *  The text colour will return to normal after the given text.
     *
     * @param text The text to colour.
     * @param ansiColour The colour to use.
     * @return The coloured text.
     */
    public static String colour(String text, String ansiColour) {
        return ansiColour + text + RESET_ALL;
    }
}
