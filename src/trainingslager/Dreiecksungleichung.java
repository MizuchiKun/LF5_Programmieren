package trainingslager;

import utils.UserInput;

import java.util.function.Predicate;

public class Dreiecksungleichung {
    public static boolean isTrianglePossible(float a, float b, float c) {
        boolean aLtBC = a < b + c; // (a less-than b and c)
        boolean bLtCA = b < c + a;
        boolean cLtAB = c < a + b;
        return aLtBC && bLtCA && cLtAB;
    }

    public static float calcTriangleCircumference(float a, float b, float c) {
        return a + b + c;
    }

    public static float calcTriangleArea(float a, float b, float c) {
        // Calc theta between a and b.
        float theta = (float)Math.acos(a/b);  // (apparently this assumes a right-angle triangle).
        // Calc area by calculating cross product of a and b and dividing that by 2.
        float crossProduct = a * b * (float)Math.sin(theta);
        return crossProduct / 2;
    }

    public static void main(String[] args) {
        final Predicate<Double> GREATER_THAN_ZERO = (Double d) -> d > 0;
        final String SIDE_LENGTH_ERROR = "Side length must be greater than 0!\n";
        float sideA = UserInput.readFloat("Length of side a? ", GREATER_THAN_ZERO, SIDE_LENGTH_ERROR);
        float sideB = UserInput.readFloat("Length of side b? ", GREATER_THAN_ZERO, SIDE_LENGTH_ERROR);
        float sideC = UserInput.readFloat("Length of side c? ", GREATER_THAN_ZERO, SIDE_LENGTH_ERROR);

        if (isTrianglePossible(sideA, sideB, sideC)) {
            System.out.println("Triangle is possible!");
            float circumference = calcTriangleCircumference(sideA, sideB, sideC);
            float area = calcTriangleArea(sideA, sideB, sideC);
            System.out.printf("Its circumference is %.3f.\n", circumference);
            System.out.printf("Its area is %.3f.\n", area);
        } else {
            System.out.println("Triangle is not possible!");
        }
    }
}
