import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParametrizedTests {
    private Bun bun;
    private final String expectedName;
    private final float expectedPrice;

    public BunParametrizedTests(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Параметры булочки: {0}, {1}")
    public static Object[][] bunParameters() {
        return new Object[][]{
                {"rue", 45.34F},
                {"strange and rather long long name for bun", 999.99F},
                {"", Float.MAX_VALUE}
        };
    }

    @Test
    public void getBunNameTest() {
        bun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals("Имя булочки должно соответсвовать заданным параметрам", expectedName, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        bun = new Bun(expectedName, expectedPrice);
        Assert.assertEquals("Цена булочки должна соответсвовать заданным параметрам", expectedPrice, bun.getPrice(), 0.0);
    }
}
