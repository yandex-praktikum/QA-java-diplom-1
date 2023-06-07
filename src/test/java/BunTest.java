import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import praktikum.Bun;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

public class BunTest {
    private static Random random = new Random();
    private static Stream<Arguments> provideDataForBuns() {
        return Stream.of(
                of(RandomStringUtils.randomAlphabetic(3), random.nextFloat()),
                of(RandomStringUtils.randomAlphabetic(4), random.nextFloat()),
                of(RandomStringUtils.randomAlphabetic(999), random.nextFloat()),
                of(RandomStringUtils.randomAlphabetic(1000), random.nextFloat()),
                of("Миллион калорий", random.nextFloat()),
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
    @MethodSource("provideDataForBuns")
    public void checkBunPrice(String name, float price) {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice());
    }

    private static Stream<Arguments> provideInvalidDataForBuns(){
        String validName = RandomStringUtils.randomAlphabetic(10);
        float validPrice = 1;
        return Stream.of(
                of(RandomStringUtils.randomAlphabetic(2),validPrice),
                of(RandomStringUtils.randomAlphabetic(1001), validPrice),
                of("SELECT*", validPrice),
                of("<script>alert('XSS')</script>", validPrice),
                of("123", validPrice),
                of(validName, -0.01F),
                of(validName, 0),
                of(validName, 1_000_000),
                of(validName, 1_000_000.01F)
        );
    }

    @ParameterizedTest(name = "Проверка выброса исключений на невалидные данные")
    @MethodSource("provideInvalidDataForBuns")
    public void checkThrowsExceptionsOnInvalidParameters(String name, float price){
        assertThrows(IllegalArgumentException.class, ()-> new Bun (name, price));
    }

    @ParameterizedTest(name = "Проверка выброса исключений на невалидные данные")
    @NullAndEmptySource
    public void checkThrowsExceptionsOnInvalidParameters(String name){
        float validPrice = random.nextFloat();
        assertThrows(IllegalArgumentException.class, ()-> new Bun (name, validPrice));
    }
}
