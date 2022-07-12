package praktikum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BunTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "test string", "test string @_%ч,."})
    void getBunNameTest(String name) {
        Bun bun = new Bun(name, 0);
        String actual = bun.getName();
        Assertions.assertEquals(name, actual);
    }

    @ParameterizedTest
    @ValueSource(floats = {0, -100.34f, 300.79f})
    void getBunPriceTest(float price) {
        Bun bun = new Bun("string", price);
        float actual = bun.getPrice();
        Assertions.assertEquals(price, actual);
    }
}