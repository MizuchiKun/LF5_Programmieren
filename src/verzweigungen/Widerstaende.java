package verzweigungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Widerstaende {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Widerstand 1? ");
        float resistance1 = Float.parseFloat(reader.readLine().trim());
        System.out.print("Widerstand 2? ");
        float resistance2 = Float.parseFloat(reader.readLine().trim());
        System.out.print("Schaltungsart (P=Parallel, R=Reihe)? ");
        char circuitType = reader.readLine().trim().toUpperCase().charAt(0);

        final char CIRCUIT_PARALLEL = 'P';
        final char CIRCUIT_SERIES = 'R';
        switch (circuitType)
        {
            case CIRCUIT_PARALLEL:
                float totalResistanceParallel = (resistance1 * resistance2) / (resistance1 + resistance2);
                System.out.printf("Gesamtwiderstand: %.2f\n", totalResistanceParallel);
                break;
            case CIRCUIT_SERIES:
                float totalResistanceSeries = resistance1 + resistance2;
                System.out.printf("Gesamtwiderstand: %.2f\n", totalResistanceSeries);
                break;
            default:
                System.out.println("Schaltungsart existiert nicht.");
        }
    }
}
