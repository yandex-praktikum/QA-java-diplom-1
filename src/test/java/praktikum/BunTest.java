package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BunTest {
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(" BLACK", -111011,4),
                Arguments.of("GRE Y766", 0),
                Arguments.of("GR EY6", 336888),
                Arguments.of("G Eоо067", 5543)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void checkNameAndPrice(String name, float price) {
        Bun bun = new Bun(name, price);
        Assertions.assertEquals(name, bun.getName());
        Assertions.assertEquals(price, bun.getPrice());
    }
}