import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;

    private final String bunName;
    private final float bunPrice;
    private final String expectedBunName;
    private final float expectedBunPrice;

    public BunTest(String bunName, float bunPrice, String expectedBunName, float expectedBunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.expectedBunName = expectedBunName;
        this.expectedBunPrice = expectedBunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] bunTestData() {
        return new Object[][] {
                {"correctBunName", 1.0000001f, "correctBunName", 1.0000001f},
                {"", 0, "", 0},
                {"!@#$%^&*()_+", -1100.50f, "!@#$%^&*()_+", -1100.50f},
                {"Правильное название булочки", 3402823466.1059f, "Правильное название булочки", 3402823466.1059f},
        };
    }

    @Before
    public void initialize() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        Assert.assertEquals("Неверная работа метода getName", expectedBunName, bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Assert.assertEquals("Неверная работа метода getPrice", expectedBunPrice, bun.getPrice(), 0.01 );
    }
}
