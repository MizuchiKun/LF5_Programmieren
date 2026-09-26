package trainingslager;

import utils.UserInput;

import java.util.function.Predicate;

public class Dreiecksungleichung {
    public static boolean isTrianglePossible(double a, double b, double c) {
        boolean aLtBC = a < b + c; // (a less-than b and c)
        boolean bLtCA = b < c + a;
        boolean cLtAB = c < a + b;
        return aLtBC && bLtCA && cLtAB;
    }

    public static double calcTrianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double calcTriangleArea(double a, double b, double c) {
        // Heron's Formula.
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s-a) * (s-b) * (s-c));

        return area;
    }

    public static void main(String[] args) {
        final Predicate<Double> GREATER_THAN_ZERO = (Double d) -> d > 0;
        final String SIDE_LENGTH_ERROR = "Side length must be greater than 0!\n";
        double sideA = UserInput.readDouble("Length of side a? ", GREATER_THAN_ZERO, SIDE_LENGTH_ERROR);
        double sideB = UserInput.readDouble("Length of side b? ", GREATER_THAN_ZERO, SIDE_LENGTH_ERROR);
        double sideC = UserInput.readDouble("Length of side c? ", GREATER_THAN_ZERO, SIDE_LENGTH_ERROR);

        if (isTrianglePossible(sideA, sideB, sideC)) {
            System.out.println("Triangle is possible!");
            double perimeter = calcTrianglePerimeter(sideA, sideB, sideC);
            double area = calcTriangleArea(sideA, sideB, sideC);
            System.out.printf("Its perimeter is %.3f.\n", perimeter);
            System.out.printf("Its area is %.3f.\n", area);
        } else {
            System.out.println("Triangle is not possible!");
        }
    }
}
