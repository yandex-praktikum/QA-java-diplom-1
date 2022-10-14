package praktikum;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Юнит-тесты класса Bun
 */
public class BunTest {
    // Создаем тестовые данные со случайными значениями
    public float actualPrice = new Random().nextFloat();
    public String actualName = "KolyaevBun" + new Random().nextInt(10);

    // Проверяем, что геттер getName возвращает название булки
    @Test
    public void checkGetNameReturnsStringFromParameters() {
        Bun bun = new Bun(actualName, actualPrice);
        String expectedName = bun.getName();
        assertEquals(expectedName,actualName);
    }

    // Проверяем, что геттер getPrice возвращает цену булки
    @Test
    public void checkGetPriceReturnsFloatFromParameters() {
        Bun bun = new Bun(actualName, actualPrice);
        float expectedPrice = bun.getPrice();
        assertEquals(expectedPrice,actualPrice, 0);
    }
}