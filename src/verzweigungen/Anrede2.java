package verzweigungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anrede2 {
    public static void main(String[] args) throws IOException {
        final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wie ist dein Vorname?? ");
        String firstName = READER.readLine().trim();
        System.out.print("Wie ist dein Nachname?? ");
        String lastName = READER.readLine().trim();
        System.out.print("Was ist dein Geschlecht (m/w/d)?? ");
        char genderInput = READER.readLine().trim().charAt(0);

        final char GENDER_MALE = 'm';
        final char GENDER_FEMALE = 'w';
        final char GENDER_DIVERSE = 'd';
        String anrede = switch (genderInput) {
            case GENDER_MALE -> "Herr ";
            case GENDER_FEMALE -> "Frau ";
            case GENDER_DIVERSE -> "";
            default -> "[Was bist du???] ";
        };

        System.out.printf("Moin, %s%s %s!\n", anrede, firstName, lastName);
    }
}
