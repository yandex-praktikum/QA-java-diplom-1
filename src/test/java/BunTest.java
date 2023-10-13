import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private float delta;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверка возвращения корректного значения. Тестовые данные: {0}, {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {null, 988},
                {"", 988}
        };
    }

    @Test
    public void getNameReturnCorrectValue() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnCorrectValue() {
        Bun bun = new Bun(name, price);
        delta = 0;
        Assert.assertEquals(price, bun.getPrice(), delta);
    }
}
