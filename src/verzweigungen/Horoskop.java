package verzweigungen;

import java.time.LocalDate;

public class Horoskop {
    private static String tensOfDayMessage(int day) {
        int tensOfDay = day / 10;
        return switch (tensOfDay) {
            case 0 -> "Im Berufsleben";
            case 1 -> "In der Partnerschaft";
            case 2 -> "In der Familie";
            case 3 -> "In der Liebe";
            default -> "<ERROR>";
        };
    }

    private static String onesOfDayMessage(int day) {
        int onesOfDay = day % 10;
        return switch (onesOfDay) {
            case 0 -> "fehlt Ihnen die Ausdauer.";
            case 1 -> "kündigen sich Veränderungen an.";
            case 2 -> "lassen Erfolge auf sich warten.";
            case 3 -> "neigen Sie zur Bequemlichkeit.";
            case 4 -> "sind Sie besonders aktiv.";
            case 5 -> "müssen Sie mit unangenehmen Überraschungen rechnen.";
            case 6 -> "befinden Sie sich in einer produktiven Phase.";
            case 7 -> "eilen Sie von Erfolg zu Erfolg.";
            case 8 -> "sind Sie besonders kreativ.";
            case 9 -> "kann es zu einer Auseinandersetzung kommen.";
            default -> "<impossible>";
        };
    }

    private static String monthMessage(int month) {
        return switch (month) {
            case  1 -> "Lassen Sie sich nicht beeinflussen!";
            case  2 -> "Hören Sie auf den Rat eines Freundes!";
            case  3 -> "Seien Sie weniger kritisch!";
            case  4 -> "Ab und zu eine Pause einlegen!";
            case  5 -> "Geldausgaben verschieben!";
            case  6 -> "Werden Sie nicht übermütig!";
            case  7 -> "Denken Sie nicht nur an sich!";
            case  8 -> "Machen Sie weiter so!";
            case  9 -> "Suchen Sie eine Aussprache!";
            case 10 -> "Nicht immer nur an andere denken!";
            case 11 -> "Achten Sie auf Ihre Gesundheit!";
            case 12 -> "Idealer Zeitpunkt für einen Neuanfang!";
            default -> "<ERROR>";
        };
    }

    public static void main(String[] args) {
        // Is this what the program is supposed to do? No funky zodiac stuff?
        LocalDate today = LocalDate.now();
        System.out.println(String.join(" ",
                                       tensOfDayMessage(today.getDayOfMonth()),
                                       onesOfDayMessage(today.getDayOfMonth()),
                                       monthMessage(today.getMonthValue())));
    }
}
