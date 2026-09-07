package einUndAusgabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fahrenheit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Temperatur in Grad Celsius? ");
        float tempCelsius = Float.parseFloat(reader.readLine().trim());
        float tempFahrenheit = (tempCelsius * 9/5f) + 32f;

        if (tempCelsius <= 40f)
            System.out.printf("%.2f °C sind %.2f °F.\n", tempCelsius, tempFahrenheit);
        else
            System.out.println("You call that hot??");
    }
}
