package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("foo", 10.0f),
                Arguments.of("bar", 100.0f),
                Arguments.of("baz", 33.0f)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testConstructor(String name, float price) {
        Bun bun = new Bun(name, price);

        assertEquals(name, bun.name);
        assertEquals(name, bun.getName());

        assertEquals(price, bun.price);
        assertEquals(price, bun.getPrice());
    }
}
