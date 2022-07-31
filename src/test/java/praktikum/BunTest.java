package praktikum;

import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private static final String INCORRECT_NAME_MESSAGE = "Название указано не правильно";
    private static final String INCORRECT_PRICE_MESSAGE = "Цена указана не правильно";

    private Bun bun;
    private final String expectedName = "Плюшка";
    private final float expectedPrice = 100f;
    float delta = 0;

    @Before
    public void setUp() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    @Description("Проверяем название")
    public void testGetBunName() {
        String actualName = bun.getName();
        assertEquals(INCORRECT_NAME_MESSAGE, expectedName, actualName);
    }

    @Test
    @Description("Проверяем цену")
    public void testGetBunPrice() {
        float actualPrice = bun.getPrice();
        assertEquals(INCORRECT_PRICE_MESSAGE, expectedPrice, actualPrice, delta);
    }
}