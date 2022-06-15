package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String nameExpected;
    private final float priceExpected;

    public BunParameterizedTest(String name, float price) {
        this.nameExpected = name;
        this.priceExpected = price;
    }

    @Parameterized.Parameters
    public static Object[][] createBun() {
        return new Object[][]{
                {"Белая булочка", 100},
                {"White bun", 150f},
                {"Булочка с кунжутом", 150.50f},
                {"Белая булочка", 1245001264454545451L},
                {"test", 0},
        };
    }

    @Test
    public void constructorBunBunNotNull() {
        Bun bun = new Bun(nameExpected, priceExpected);

        Assert.assertNotNull("Объект пустой", bun);
        Assert.assertEquals("Фактическое значение названия отличается от ожидаемого", nameExpected, bun.name);
        Assert.assertEquals("Фактическое значение цены отличается от ожидаемого", priceExpected, bun.price, 0.00f);
    }
}
