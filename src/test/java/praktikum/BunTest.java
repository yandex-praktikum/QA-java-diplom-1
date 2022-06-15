package praktikum;

import org.junit.Assert;

import org.junit.Ignore;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameReturnExpectedName() {
        String nameExpected = "Белая булочка";
        Bun bun = new Bun(nameExpected, 12.50f);

        String actual = bun.getName();

        String message = String.format("Фактическое значение названия не соответсвует ожидаемому значению. \nОжидаемое значение:\"%s\";\nФактическое значение:\"%s\";\n", nameExpected, actual);
        Assert.assertEquals(message, nameExpected, actual);
    }

    @Test
    public void getPriceReturnExpectedPrice() {
        float priceExpected = 100;
        Bun bun = new Bun("Белая булочка", priceExpected);

        float actual = bun.getPrice();

        String message = String.format("Фактическое значение цены не соответсвует ожидаемому значению. \nОжидаемое значение:\"%s\";\nФактическое значение:\"%s\";\n", priceExpected, actual);
        Assert.assertEquals(message, priceExpected, actual, 0.00f);
    }

    @Ignore
    @Test
    public void constructorBunNameEmptyExpectedException() {
        Assert.assertThrows("Название пустое. Объект класса Bun создан.Ожидаемая ошибка отсутствует.", Exception.class, () -> new Bun("", 150));
    }

    @Ignore
    @Test
    public void constructorBunNameNullExpectedException() {
        Assert.assertThrows("Название отсутствует. Объект класса Bun создан.Ожидаемая ошибка отсутствует.", Exception.class, () -> new Bun(null, 100));
    }

    @Ignore
    @Test
    public void constructorBunPriceNegativeNumberExpectedException() {
        Assert.assertThrows("Цена отрицательная. Объект класса Bun создан. Ошибка отсутствует.", Exception.class, () -> new Bun("Булочка с кунжутом", -100));
    }
}
