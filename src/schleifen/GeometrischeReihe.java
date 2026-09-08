package schleifen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeometrischeReihe {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Geometrische Reihe bis zu welchem n berechnen? ");
        int n = Integer.parseInt(reader.readLine().trim());

        float geometricSeries = 0;
        for (int i = 1 ; i <= n; i++)
        {
            geometricSeries += (float)(1 / Math.pow(2, i));
        }

        System.out.printf("Geometrische Reihe bis %d = %f\n", n, geometricSeries);
    }
}
