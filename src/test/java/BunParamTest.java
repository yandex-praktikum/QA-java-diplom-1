import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String bunName;
    private final float bunPrice;


    public BunParamTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }
    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][] {
                {"С корицей", 11f},
                {"", 1f},
                {"aASD@#Q!", 14f},
                {"Black", 123f},
                {null, 0},
                {" ", 0},
                {"НууууОчччченьДлллллииннноеИмя", Float.MAX_VALUE}
        };
    }
    @Test
    public void getBunName() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }
    @Test
    public void getBunPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(),11);
    }
}
