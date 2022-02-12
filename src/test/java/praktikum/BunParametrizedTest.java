package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunParametrizedTest {

    @ParameterizedTest
    @MethodSource("nameDataProvider")
    public void getNameCorrectValueReturned(String expected, String name, float price) {
        Bun bun = new Bun(name, price);
        assertEquals(expected, bun.getName(), "Incorrect Name value returned");
    }

    private static Stream<Arguments> nameDataProvider() {
        return Stream.of(
                Arguments.of("Test", "Test", 0.01f),
                Arguments.of("Test name", "Test name", 0.01f),
                Arguments.of("Test", " Test", 0.01f),
                Arguments.of("Test", "Test ", 0.01f)
        );
    }

    @ParameterizedTest
    @MethodSource("priceDataProvider")
    public void getPriceCorrectValueReturned(float expected, String name, float price) {
        Bun bun = new Bun(name, price);
        assertEquals(expected, bun.getPrice(), "Incorrect Price value returned");
    }

    @MethodSource("priceDataProvider")
    private static Stream<Arguments> priceDataProvider() {
        return Stream.of(
                Arguments.of(0f, "Test", 0),
                Arguments.of(0.01f, "Test", 0.01f),
                Arguments.of(1f, "Test", 1),
                Arguments.of(12.23f, "Test", 12.23f),
                Arguments.of(0f, "Test", -12.23f)
        );
    }
}
