package schleifen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fakultaet {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Gebe n ein um n! zu berechnen (n <= 20): ");
        int n = Integer.parseInt(reader.readLine().trim());

        long factorial = 1;
        for (long i = 1; i <= n; i++)
        {
            factorial *= i;
            System.out.printf("%d! = %d\n", i, factorial);
        }
        System.out.println(Long.MAX_VALUE);
    }
}
