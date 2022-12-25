import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public BunParameterizedTest(String name, float price, String expectedName, float expectedPrice) {
        this.name=name;
        this.expectedName=expectedName;
        this.price=price;
        this.expectedPrice=expectedPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][] {
                {"black bun", 100, "black bun", 100},
                {"", 99999, "", 99999},
                {"sooooooolooooongnaaaaame", -100, "sooooooolooooongnaaaaame", -100},
                {"         ", 0, "         ", 0}
        };
    }
    @Test
    public void shouldBeName() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }
    @Test
    public void shouldBePrice() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
