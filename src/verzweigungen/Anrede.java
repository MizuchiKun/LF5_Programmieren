package verzweigungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anrede {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Wie ist dein Vorname?? ");
        String firstName = reader.readLine().trim();
        System.out.print("Wie ist dein Nachname?? ");
        String lastName = reader.readLine().trim();
        System.out.print("Was ist dein Geschlecht (1=männlich, 2=weiblich, 3=divers)?? ");
        int genderInput = Integer.parseInt(reader.readLine().trim());

        final int GENDER_MALE = 1;
        final int GENDER_FEMALE = 2;
        final int GENDER_DIVERSE = 3;
        String anrede = switch (genderInput)
        {
            case GENDER_MALE -> "Herr ";
            case GENDER_FEMALE -> "Frau ";
            case GENDER_DIVERSE -> "";
            default -> "[Was bist du???] ";
        };

        System.out.printf("Moin, %s%s %s!\n", anrede, firstName, lastName);
    }
}
