import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Random random = new Random();
    private final String testName = "Test Name";
    private final float testPrice = 0 + random.nextFloat() * 100;
    float comparisonDelta = testPrice / 100;
    String errorMessageConstructorNameTest = "Значение переменной bun.name не соответствует переданному в конструктор класса";
    String errorMessageConstructorPriceTest = String.format("Значение переменной bun.price не соответствует переданному в конструктор класса, погрешность превышает 1 процент (%f)", comparisonDelta);
    String errorMessageGetNameTest = "getName возвращает некорректное значение переменной name";
    String errorMessageGetPriceTest = "getPrice возвращает некорректное значение переменной price";

    @Test
    public void isBunClassConstructorSetNameAndPriceTest() {
        String expectedName = testName;
        float expectedPrice = testPrice;
        Bun bun = new Bun(testName, testPrice);
        assertEquals(errorMessageConstructorNameTest, expectedName, bun.name);
        assertEquals(errorMessageConstructorPriceTest, expectedPrice, bun.price, comparisonDelta);
    }
    @Test
    public void isBunClassGetNameReturnNameTest() {
        Bun bun = new Bun(testName, testPrice);
        assertEquals(errorMessageGetNameTest, bun.name, bun.getName());
    }

    @Test
    public void isBunClassGetPriceReturnPriceTest() {
        Bun bun = new Bun(testName, testPrice);
        assertEquals(errorMessageGetPriceTest, bun.price, bun.getPrice(), comparisonDelta);
    }
}
