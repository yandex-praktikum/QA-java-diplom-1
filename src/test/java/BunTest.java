import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;


    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Просто булочка", 100},
                {"Beautiful bun", 0.000001F},
                {"ÂD$KΔYÂ 6ȳLKÂ 0T ϢɇȹȀ! ҉", 300},
                {"", 0},
                {null, -1},
                {"Космическая булка - метавселенная, она очень огроооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооомная", 9999999999.99F}
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), TestConstants.DELTA);
    }
}
