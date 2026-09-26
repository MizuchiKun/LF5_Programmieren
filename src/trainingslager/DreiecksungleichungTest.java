package trainingslager;


import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DreiecksungleichungTest {
    @ParameterizedTest
    @MethodSource("data_test_isTrianglePossible")
    void test_isTrianglePossible(float a, float b, float c, boolean expected) {
        assertEquals(expected, Dreiecksungleichung.isTrianglePossible(a, b, c));
    }

    @ParameterizedTest
    @MethodSource("data_test_calcTriangleCircumference")
    void test_calcTriangleCircumference(float a, float b, float c, float expected) {
        assertEquals(expected, Dreiecksungleichung.calcTriangleCircumference(a, b, c));
    }

    @ParameterizedTest
    @MethodSource("data_test_calcTriangleArea")
    void test_calcTriangleArea(float a, float b, float c, float expected) {
        assertEquals(expected, Dreiecksungleichung.calcTriangleArea(a, b, c));
    }

    private static Stream<Arguments> data_test_isTrianglePossible() {
        return Stream.of(
                Arguments.of(1, 1, 1, true),
                Arguments.of(1, 1, 2, false),
                Arguments.of(1, 1, 3, false),
                Arguments.of(1, 1, 4, false),
                Arguments.of(1, 1, 5, false),
                Arguments.of(1, 1, 6, false),
                Arguments.of(1, 2, 2, true),
                Arguments.of(1, 2, 3, false),
                Arguments.of(1, 2, 4, false),
                Arguments.of(1, 2, 5, false),
                Arguments.of(1, 2, 6, false),
                Arguments.of(1, 3, 3, true),
                Arguments.of(1, 3, 4, false),
                Arguments.of(1, 3, 5, false),
                Arguments.of(1, 3, 6, false),
                Arguments.of(1, 4, 4, true),
                Arguments.of(1, 4, 5, false),
                Arguments.of(1, 4, 6, false),
                Arguments.of(1, 5, 5, true),
                Arguments.of(1, 5, 6, false),
                Arguments.of(1, 6, 6, true),
                Arguments.of(2, 2, 2, true),
                Arguments.of(2, 2, 3, true),
                Arguments.of(2, 2, 4, false),
                Arguments.of(2, 2, 5, false),
                Arguments.of(2, 2, 6, false),
                Arguments.of(2, 3, 3, true),
                Arguments.of(2, 3, 4, true),
                Arguments.of(2, 3, 5, false),
                Arguments.of(2, 3, 6, false),
                Arguments.of(2, 4, 4, true),
                Arguments.of(2, 4, 5, true),
                Arguments.of(2, 4, 6, false),
                Arguments.of(2, 5, 5, true),
                Arguments.of(2, 5, 6, true),
                Arguments.of(2, 6, 6, true),
                Arguments.of(3, 3, 3, true),
                Arguments.of(3, 3, 4, true),
                Arguments.of(3, 3, 5, true),
                Arguments.of(3, 3, 6, false),
                Arguments.of(3, 4, 4, true),
                Arguments.of(3, 4, 5, true),
                Arguments.of(3, 4, 6, true),
                Arguments.of(3, 5, 5, true),
                Arguments.of(3, 5, 6, true),
                Arguments.of(3, 6, 6, true),
                Arguments.of(4, 4, 4, true),
                Arguments.of(4, 4, 5, true),
                Arguments.of(4, 4, 6, true),
                Arguments.of(4, 5, 5, true),
                Arguments.of(4, 5, 6, true),
                Arguments.of(4, 6, 6, true),
                Arguments.of(5, 5, 5, true),
                Arguments.of(5, 5, 6, true),
                Arguments.of(5, 6, 6, true),
                Arguments.of(6, 6, 6, true)
        );
    }

    private static Stream<Arguments> data_test_calcTriangleCircumference() {
        return Stream.of(
                Arguments.of(1, 1, 1, 3),
                Arguments.of(1, 1, 2, 4),
                Arguments.of(1, 1, 3, 5),
                Arguments.of(1, 1, 4, 6),
                Arguments.of(1, 1, 5, 7),
                Arguments.of(1, 1, 6, 8),
                Arguments.of(1, 2, 2, 5),
                Arguments.of(1, 2, 3, 6),
                Arguments.of(1, 2, 4, 7),
                Arguments.of(1, 2, 5, 8),
                Arguments.of(1, 2, 6, 9),
                Arguments.of(1, 3, 3, 7),
                Arguments.of(1, 3, 4, 8),
                Arguments.of(1, 3, 5, 9),
                Arguments.of(1, 3, 6, 10),
                Arguments.of(1, 4, 4, 9),
                Arguments.of(1, 4, 5, 10),
                Arguments.of(1, 4, 6, 11),
                Arguments.of(1, 5, 5, 11),
                Arguments.of(1, 5, 6, 12),
                Arguments.of(1, 6, 6, 13),
                Arguments.of(2, 2, 2, 6),
                Arguments.of(2, 2, 3, 7),
                Arguments.of(2, 2, 4, 8),
                Arguments.of(2, 2, 5, 9),
                Arguments.of(2, 2, 6, 10),
                Arguments.of(2, 3, 3, 8),
                Arguments.of(2, 3, 4, 9),
                Arguments.of(2, 3, 5, 10),
                Arguments.of(2, 3, 6, 11),
                Arguments.of(2, 4, 4, 10),
                Arguments.of(2, 4, 5, 11),
                Arguments.of(2, 4, 6, 12),
                Arguments.of(2, 5, 5, 12),
                Arguments.of(2, 5, 6, 13),
                Arguments.of(2, 6, 6, 14),
                Arguments.of(3, 3, 3, 9),
                Arguments.of(3, 3, 4, 10),
                Arguments.of(3, 3, 5, 11),
                Arguments.of(3, 3, 6, 12),
                Arguments.of(3, 4, 4, 11),
                Arguments.of(3, 4, 5, 12),
                Arguments.of(3, 4, 6, 13),
                Arguments.of(3, 5, 5, 13),
                Arguments.of(3, 5, 6, 14),
                Arguments.of(3, 6, 6, 15),
                Arguments.of(4, 4, 4, 12),
                Arguments.of(4, 4, 5, 13),
                Arguments.of(4, 4, 6, 14),
                Arguments.of(4, 5, 5, 14),
                Arguments.of(4, 5, 6, 15),
                Arguments.of(4, 6, 6, 16),
                Arguments.of(5, 5, 5, 15),
                Arguments.of(5, 5, 6, 16),
                Arguments.of(5, 6, 6, 17),
                Arguments.of(6, 6, 6, 18)
        );
    }

    private static Stream<Arguments> data_test_calcTriangleArea() {
        return Stream.of(
                Arguments.of(1, 1, 1, 0.433),
                Arguments.of(1, 1, 2, 0.0),
                Arguments.of(1, 1, 3, 0.0),
                Arguments.of(1, 1, 4, 0.0),
                Arguments.of(1, 1, 5, 0.0),
                Arguments.of(1, 1, 6, 0.0),
                Arguments.of(1, 2, 2, 0.9682),
                Arguments.of(1, 2, 3, 0.0),
                Arguments.of(1, 2, 4, 0.0),
                Arguments.of(1, 2, 5, 0.0),
                Arguments.of(1, 2, 6, 0.0),
                Arguments.of(1, 3, 3, 1.479),
                Arguments.of(1, 3, 4, 0.0),
                Arguments.of(1, 3, 5, 0.0),
                Arguments.of(1, 3, 6, 0.0),
                Arguments.of(1, 4, 4, 1.9843),
                Arguments.of(1, 4, 5, 0.0),
                Arguments.of(1, 4, 6, 0.0),
                Arguments.of(1, 5, 5, 2.4875),
                Arguments.of(1, 5, 6, 0.0),
                Arguments.of(1, 6, 6, 2.9896),
                Arguments.of(2, 2, 2, 1.7321),
                Arguments.of(2, 2, 3, 1.9843),
                Arguments.of(2, 2, 4, 0.0),
                Arguments.of(2, 2, 5, 0.0),
                Arguments.of(2, 2, 6, 0.0),
                Arguments.of(2, 3, 3, 2.8284),
                Arguments.of(2, 3, 4, 2.9047),
                Arguments.of(2, 3, 5, 0.0),
                Arguments.of(2, 3, 6, 0.0),
                Arguments.of(2, 4, 4, 3.873),
                Arguments.of(2, 4, 5, 3.7997),
                Arguments.of(2, 4, 6, 0.0),
                Arguments.of(2, 5, 5, 4.899),
                Arguments.of(2, 5, 6, 4.6837),
                Arguments.of(2, 6, 6, 5.9161),
                Arguments.of(3, 3, 3, 3.8971),
                Arguments.of(3, 3, 4, 4.4721),
                Arguments.of(3, 3, 5, 4.1458),
                Arguments.of(3, 3, 6, 0.0),
                Arguments.of(3, 4, 4, 5.5621),
                Arguments.of(3, 4, 5, 6.0),
                Arguments.of(3, 4, 6, 5.3327),
                Arguments.of(3, 5, 5, 7.1545),
                Arguments.of(3, 5, 6, 7.4833),
                Arguments.of(3, 6, 6, 8.7142),
                Arguments.of(4, 4, 4, 6.9282),
                Arguments.of(4, 4, 5, 7.8062),
                Arguments.of(4, 4, 6, 7.9373),
                Arguments.of(4, 5, 5, 9.1652),
                Arguments.of(4, 5, 6, 9.9216),
                Arguments.of(4, 6, 6, 11.3137),
                Arguments.of(5, 5, 5, 10.8253),
                Arguments.of(5, 5, 6, 12.0),
                Arguments.of(5, 6, 6, 13.6359),
                Arguments.of(6, 6, 6, 15.5885)
        );
    }
}
