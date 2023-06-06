import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import praktikum.Bun;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

public class BunTest {
    private static Random random = new Random();
    private static Stream<Arguments> provideDataForBuns() {
        return Stream.of(
                of(RandomStringUtils.randomAlphabetic(1), random.nextFloat()),
                of(RandomStringUtils.randomAlphabetic(1000), random.nextFloat()),
                of("Миллион калорий", 1),
                of(RandomStringUtils.randomAlphabetic(999), random.nextFloat()),
                of(RandomStringUtils.randomAlphabetic(1000), random.nextFloat()),
                of(RandomStringUtils.randomAlphabetic(100), 0.01F),
                of(RandomStringUtils.randomAlphabetic(99), 999_999.99F)
        );
    }

    @ParameterizedTest(name = "Проверка получения названия булки: название {0}, цена {1}")
    @MethodSource("provideDataForBuns")
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

    private static Stream<Arguments> provideInvalidDataForBuns(){
        String validName = RandomStringUtils.randomAlphabetic(10);
        float validPrice = 1;
        return Stream.of(
                of("", validPrice),
                of(RandomStringUtils.randomAlphabetic(1001), validPrice),
                of("*", validPrice),
                of("<script>alert('XSS')</script>", validPrice),
                of("1", validPrice),
                of("A", validPrice),
                of(validName, -1),
                of(validName, 0)
        );
    }

    @ParameterizedTest(name = "Проверка выброса исключений на невалидные данные")
    @MethodSource("provideInvalidDataForBuns")
    public void checkThrowsExceptionsOnInvalidParameters(String name, float price){
        assertThrows(IllegalArgumentException.class, ()-> new Bun (name, price));
    }

    @ParameterizedTest(name = "Проверка выброса исключений на невалидные данные")
    @NullSource
    public void checkThrowsExceptionsOnInvalidParameters(String name){
        assertThrows(IllegalArgumentException.class, ()-> new Bun (name, 100));
    }
}
