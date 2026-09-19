package verzweigungen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SBahnTest {

    @ParameterizedTest
    @MethodSource("data_givenStartEnd_PriceOk")
    void givenStartEnd_PriceOk(int stationA, int stationB, double price) {
        assertEquals(price, SBahn.berechnePreis(stationA, stationB));
        assertEquals(price, SBahn.berechnePreis(stationB, stationA));
    }

    static Stream<Arguments> data_givenStartEnd_PriceOk() {
        int anzahlLinien = 5;
        return Stream.of(
                Arguments.of(11, 12, 1.0),
                Arguments.of(13, 14, 1.0),
                Arguments.of(13, 23, 1.0),
                Arguments.of(13, anzahlLinien * 10 + 3, 1.0),
                Arguments.of(00, 11, 1.0),

                Arguments.of(11, 13, 2.0),
                Arguments.of(11, 21, 2.0),
                Arguments.of(13, 33, 2.0),

                Arguments.of(11, 15, 3.0),
                Arguments.of(11, 25, 3.0),
                Arguments.of(14, 25, 3.0),
                Arguments.of(15, 25, 3.0),

                Arguments.of(00, 12, 3.0),
                Arguments.of(14, 16, 3.0),

                Arguments.of(11, 16, 4.0),
                Arguments.of(13, 16, 4.0),
                Arguments.of(11, 26, 4.0),
                Arguments.of(13, 26, 4.0),

                Arguments.of(00, 16, 5.0),
                Arguments.of(00, 26, 5.0),
                Arguments.of(16, 26, 5.0)
        );
    }

    /*
        private static Supplier<Stream<Arguments>> streamSupplier;

    @BeforeAll
    public static void setUp(){
        int anzahlLinien = 5;
        streamSupplier = () -> Stream.of(
                Arguments.of(11, 12, 1.0),
                Arguments.of(13, 14, 1.0),
                Arguments.of(13, 23, 1.0),
                Arguments.of(13, anzahlLinien * 10 + 3, 1.0),
                Arguments.of(00, 11, 1.0),

                Arguments.of(11, 13, 2.0),
                Arguments.of(11, 21, 2.0),
                Arguments.of(13, 33, 2.0),

                Arguments.of(11, 15, 3.0),
                Arguments.of(11, 25, 3.0),
                Arguments.of(14, 25, 3.0),
                Arguments.of(15, 25, 3.0),

                Arguments.of(00, 12, 3.0),
                Arguments.of(14, 16, 3.0),

                Arguments.of(11, 16, 4.0),
                Arguments.of(13, 16, 4.0),
                Arguments.of(11, 26, 4.0),
                Arguments.of(13, 26, 4.0),

                Arguments.of(00, 16, 5.0),
                Arguments.of(00, 26, 5.0),
                Arguments.of(16, 26, 5.0)
                );
    }

    static Stream<Arguments> getStreamArguments() {
        return streamSupplier.get();
    }

     */

}
