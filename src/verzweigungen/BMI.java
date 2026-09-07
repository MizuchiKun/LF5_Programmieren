package verzweigungen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BMI {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Gewicht (in kg)? ");
        float weight = Float.parseFloat(reader.readLine().trim());
        System.out.print("Körpergröße (in cm)? ");
        float height = Integer.parseInt(reader.readLine().trim()) / 100f;
        System.out.print("Geschlecht (m/w)? ");
        char sex = Character.toLowerCase(reader.readLine().charAt(0));

        final char SEX_MALE = 'm';
        final char SEX_FEMALE = 'w';
        final float BMI_LOWER_LIMIT_MALE_NORMAL_WEIGHT = 20f;
        final float BMI_LOWER_LIMIT_FEMALE_NORMAL_WEIGHT = 19f;
        final float BMI_LOWER_LIMIT_MALE_OBESITY1 = 25f;  // Aka. overweight.
        final float BMI_LOWER_LIMIT_FEMALE_OBESITY1 = 24f; // Aka. overweight.
        final float BMI_LOWER_LIMIT_OBESITY2 = 30f;
        final float BMI_LOWER_LIMIT_OBESITY3 = 40f;
        float bmi = weight / (height * height);
        boolean isMale = sex == SEX_MALE;
        boolean isFemale = sex == SEX_FEMALE;

        if ((isMale && bmi < BMI_LOWER_LIMIT_MALE_NORMAL_WEIGHT)
            || (isFemale && bmi < BMI_LOWER_LIMIT_FEMALE_NORMAL_WEIGHT))
        {
            System.out.printf("BMI %.2f: %s\n", bmi, "Untergewicht");
        }
        else if ((isMale && bmi < BMI_LOWER_LIMIT_MALE_OBESITY1)
                || (isFemale && bmi < BMI_LOWER_LIMIT_FEMALE_OBESITY1))
        {
            System.out.printf("BMI %.2f: %s\n", bmi, "Normalgewicht");
        }
        else if (bmi < BMI_LOWER_LIMIT_OBESITY2)
        {
            System.out.printf("BMI %.2f: %s\n", bmi, "Übergewicht");
        }
        else if (bmi < BMI_LOWER_LIMIT_OBESITY3)
        {
            System.out.printf("BMI %.2f: %s\n", bmi, "Adipositas");
        }
        else
        {
            System.out.printf("BMI %.2f: %s\n", bmi, "Starke Adipositas");
        }
    }
}
