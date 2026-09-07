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
            int xSquared = x * x;
            System.out.printf("%d^2 = %d\n", x, xSquared);
        }
    }
}
