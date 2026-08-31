package aufgabenMitEingabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zaehlmass {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Geben Sie die Zahl ein: ");
        int inputNumber = Integer.parseInt(reader.readLine().trim());

        final int GROS = 144;
        final int SCHOCK = 60;
        final int DUTZEND = 12;
        final int STUECK = 1;
        int remainder = inputNumber;
        int grosAmount = remainder / GROS;
        remainder %= GROS;
        int schockAmount = remainder / SCHOCK;
        remainder %= SCHOCK;
        int dutzendAmount = remainder / DUTZEND;
        remainder %= DUTZEND;
        int stueckAmount = remainder / STUECK; // Just to keep it modifiable.
        remainder %= STUECK;

        System.out.printf("%d Gros\n", grosAmount);
        System.out.printf("%d Schock\n", schockAmount);
        System.out.printf("%d Dutzend\n", dutzendAmount);
        System.out.printf("%d Stück\n", stueckAmount);
    }
}
