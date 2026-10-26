package eindimensionaleArrays;

import utils.UserInput;

import java.util.Arrays;

public class Temperatur {
    public static void main(String[] args) {
        float[] temperatures = new float[7];
        float average = 0;
        float minTemperature = Float.POSITIVE_INFINITY;
        float maxTemperature = Float.NEGATIVE_INFINITY;
        float maxDailyDifference = 0;
        System.out.println(temperatures.length);
        for (byte i = 0; i < temperatures.length; i++) {
            float input = UserInput.readFloat(String.format("Temperatur an Tag %d? ",
                                                            i+1));
            temperatures[i] = input;
            average += input;

            minTemperature = Math.min(input, minTemperature);
            maxTemperature = Math.max(input, maxTemperature);

            if (i == 0) { continue; }
            float dailyDifference = Math.abs(input - temperatures[i-1]);
            maxDailyDifference = Math.max(dailyDifference, maxDailyDifference);
        }

        average /= temperatures.length;
        float range = maxTemperature - minTemperature;

        System.out.printf("Mittelwert\t\t\t: %.2f\n", average);
        System.out.printf("Maximale Temperatur : %.2f\n", maxTemperature);
        System.out.printf("Minimale Temperatur : %.2f\n", minTemperature);
        System.out.printf("Spannweite\t\t\t: %.2f\n", range);
        System.out.printf("Maximale Differenz  : %.2f\n", maxDailyDifference);
    }
}
