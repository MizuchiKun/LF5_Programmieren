package schleifen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quadratsummen {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Quadratsumme bis zu welchem n? ");
        int n = Integer.parseInt(reader.readLine().trim());

        int sum = 0;
        for (int i = 1; i <= n; i++)
        {
            sum += i * i;
        }

        System.out.printf("Quadratsumme von [1, %d] = %d\n", n, sum);
    }
}
