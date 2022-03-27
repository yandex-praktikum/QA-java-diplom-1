import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class CheckNameAndPriceBunParameterizedTest {
    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public CheckNameAndPriceBunParameterizedTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] CheckNameAndPriceBun() {
        return new Object[][]{
                {"black bun", 100, "black bun", 100},
                {"white bun", 200, "white bun", 200},
                {"red bun", 300, "red bun", 300},
        };
    }

    @Test
    public void CheckBunNameTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();

        Assert.assertEquals(expectedName, actual);
    }

    @Test
    public void CheckBunPriceTest() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();

        Assert.assertEquals(expectedPrice, actual, 0.0001);
    }
}
