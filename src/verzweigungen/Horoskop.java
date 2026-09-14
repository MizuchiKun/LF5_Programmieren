package verzweigungen;

public class Horoskop {
    private static String TensOfDayMessage(int day) {
        int tensOfDay = day / 10;
        return switch (tensOfDay) {
            case 0 -> "Im Berufsleben";
            case 1 -> "In der Partnerschaft";
            case 2 -> "In der Familie";
            case 3 -> "In der Liebe";
            default -> "ERROR";
        };
    }

    private static String OnesOfDayMessage(int day) {
        return "";
    }

    private static String MonthMessage(int month) {
        return "";
    }

    public static void main(String[] args) {
        ;;
    }
}
