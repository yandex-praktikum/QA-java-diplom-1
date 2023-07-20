import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunVariants() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988f},
                {"Краторная булка N-200i", 1255},
                {"!@#$%^&*()_-=", 988},
                {"16425802", 2.063f},
                {"Black hole", -3.4E+38f},
                {null, 0f},
                {"THE SUN BUN", 3.4E+38f},
                {"", 1.9885E30f},
        };
    }
    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    @Test
    public void bunNameTest(){
        Assert.assertEquals("Неправильное название булочки!", name, bun.getName());
    }

    @Test
    public void bunPriceTest(){
        Assert.assertEquals("Неправильная стоимость булочки!", price, bun.getPrice(), 0);
    }
}
