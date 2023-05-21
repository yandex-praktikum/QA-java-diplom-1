import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Bun;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class BunTest {
    private static Random random = new Random();
    private static Stream<Arguments> getDataForBuns() {
        return Stream.of(
                of(RandomStringUtils.randomAlphabetic(1), random.nextFloat()),
                of(RandomStringUtils.randomAlphabetic(99), random.nextFloat()),
                of("Миллион калорий", 1)
        );
    }

    @ParameterizedTest(name = "Проверка получения названия булки: название {0}, цена {1}")
    @MethodSource("getDataForBuns")
    public void checkBunName(String name, float price) {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @ParameterizedTest(name = "Проверка получения цены булки: название {0}, цена {1}")
    @MethodSource("getDataForBuns")
    public void checkBunPrice(String name, float price) {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice());
    }
}
