import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParamTest {

    private final String name;
    private final float price;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0},{1},{2},{3},{4}")
    public static Object[][] bunParameters() {
        return new Object[][]{
                {null, 12.5f},
                {"#$^*$!", 12.5f},
                {"pancake", 0.0f},
                {"pancake", -12.5f},
                {"panQke", -12.5f},
                {"pancake", 1000000000000000000000.0f}
        };
    }
    @Test
    public void getNameBun() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBun() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0.1f);
    }
}