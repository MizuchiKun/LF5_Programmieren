package schleifen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wurzel {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Untergrenze des Intervalls? ");
        int rangeStart = Integer.parseInt(reader.readLine().trim());
        System.out.print("Obergrenze des Intervalls? ");
        int rangeEnd = Integer.parseInt(reader.readLine().trim());

        for (int x = rangeStart; x <= rangeEnd; x++)
        {
            float xRoot = (float)Math.sqrt(x);
            System.out.printf("Root of %d = %.2f\n", x, xRoot);
        }
    }
}
