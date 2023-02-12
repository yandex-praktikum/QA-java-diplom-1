import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Набор параметров {index}, , параметры: {0} - {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"черная булочка", 100},
                {"Булка", 30},
                {"", 0},
                {null, -10},
                {"Плююююююююююююююююююююююююююююююююююююююююююююшка", 30},
                {"булочка1", 20},
                {":?*())__)((**", 2},
                {"Плюшка", (float) 0.7689500498789050987489},

        };
    }
    @Before
    public void setBun() {
        bun = new Bun(name, price);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Неверное имя булочки для бургера", name, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals("Неверное цена булочки для бургера", price, bun.getPrice(), 0);
    }
}