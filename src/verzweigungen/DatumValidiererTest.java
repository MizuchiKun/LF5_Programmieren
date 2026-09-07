package verzweigungen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DatumValidiererTest {

    @ParameterizedTest
    @MethodSource("data_GivenDate_DateValidOrNot")
    void givenDate_DateValidOrNot(int tag, int monat, int jahr, boolean ok) {
        assertEquals(ok, DatumValidierer.validiereDatum(tag, monat, jahr));
    }

    static Stream<Arguments> data_GivenDate_DateValidOrNot() {
        return Stream.of(
                // Allgemeine Tages- und Monatsgrenzen pr�fen
                Arguments.of(0, 1, 2019, false),
                Arguments.of(32, 1, 2019, false),
                Arguments.of(1, 0, 2019, false),
                Arguments.of(1, 13, 2019, false),
                Arguments.of(-1, 1, 2019, false),
                Arguments.of(1, -1, 2019, false),
                Arguments.of(1, 1, -2019, true),
                // Monate mit 31 Tagen pr�fen
                Arguments.of(31, 1, 2019, true),
                Arguments.of(31, 3, 2019, true),
                Arguments.of(31, 5, 2019, true),
                Arguments.of(31, 7, 2019, true),
                Arguments.of(31, 8, 2019, true),
                // Monate mit 30 Tagen pr�fen
                Arguments.of(31, 4, 2019, false),
                Arguments.of(31, 6, 2019, false),
                Arguments.of(31, 9, 2019, false),
                Arguments.of(31, 11, 2019, false),
                Arguments.of(30, 4, 2019, true),
                Arguments.of(30, 6, 2019, true),
                Arguments.of(30, 9, 2019, true),
                Arguments.of(30, 11, 2019, true),
                // Schaltjahr und Februar �berpr�fen
                // Jahr weder durch 4 noch durch 100 teilbar
                Arguments.of(31, 2, 2023, false),
                Arguments.of(30, 2, 2023, false),
                Arguments.of(29, 2, 2023, false),
                Arguments.of(28, 2, 2023, true),
                // Jahr teilbar durch 4 aber nicht durch 100
                Arguments.of(31, 2, 2024, false),
                Arguments.of(30, 2, 2024, false),
                Arguments.of(29, 2, 2024, true),
                Arguments.of(28, 2, 2024, true),
                // Jahr teilbar durch 4 aber nicht durch 100
                Arguments.of(31, 2, 1900, false),
                Arguments.of(30, 2, 1900, false),
                Arguments.of(29, 2, 1900, false),
                Arguments.of(28, 2, 1900, true),
                // Jahr teilbar durch 4 und durch 400
                Arguments.of(31, 2, 2000, false),
                Arguments.of(30, 2, 2000, false),
                Arguments.of(29, 2, 2000, true),
                Arguments.of(28, 2, 2000, true)
        );
    }

    /*

    private static Supplier<Stream<Arguments>> streamSupplier;

    @BeforeAll
    public static void setUp(){
        streamSupplier = () -> Stream.of(
                // Allgemeine Tages- und Monatsgrenzen pr�fen
                Arguments.of(0, 1, 2019, false),
                Arguments.of(32, 1, 2019, false),
                Arguments.of(1, 0, 2019, false),
                Arguments.of(1, 13, 2019, false),
                // Monate mit 31 Tagen pr�fen
                Arguments.of(31, 1, 2019, true),
                Arguments.of(31, 3, 2019, true),
                Arguments.of(31, 5, 2019, true),
                Arguments.of(31, 7, 2019, true),
                Arguments.of(31, 8, 2019, true),
                // Monate mit 30 Tagen pr�fen
                Arguments.of(31, 4, 2019, false),
                Arguments.of(31, 6, 2019, false),
                Arguments.of(31, 9, 2019, false),
                Arguments.of(31, 11, 2019, false),
                Arguments.of(30, 4, 2019, true),
                Arguments.of(30, 6, 2019, true),
                Arguments.of(30, 9, 2019, true),
                Arguments.of(30, 11, 2019, true),
                // Schaltjahr und Februar �berpr�fen
                // Jahr weder durch 4 noch durch 100 teilbar
                Arguments.of(31, 2, 2023, false),
                Arguments.of(30, 2, 2023, false),
                Arguments.of(29, 2, 2023, false),
                Arguments.of(28, 2, 2023, true),
                // Jahr teilbar durch 4 aber nicht durch 100
                Arguments.of(31, 2, 2024, false),
                Arguments.of(30, 2, 2024, false),
                Arguments.of(29, 2, 2024, true),
                Arguments.of(28, 2, 2024, true),
                // Jahr teilbar durch 4 aber nicht durch 100
                Arguments.of(31, 2, 1900, false),
                Arguments.of(30, 2, 1900, false),
                Arguments.of(29, 2, 1900, false),
                Arguments.of(28, 2, 1900, true),
                // Jahr teilbar durch 4 und durch 400
                Arguments.of(31, 2, 2000, false),
                Arguments.of(30, 2, 2000, false),
                Arguments.of(29, 2, 2000, true),
                Arguments.of(28, 2, 2000, true)
        );
    }

    static Stream<Arguments> getStreamArguments() {
        return streamSupplier.get();
    }

     */

}
