import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;
    private String expectedName;
    private float expectedPrice;
    private Bun bun;

    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][]getData(){
        return new Object[][]{
                {"Кунжутная", 5F, "Кунжутная", 5F},
                {"Вкусная", 10.8F, "Вкусная", 10.8F},
                {"Black", 123.09F, "Black", 123.09F}

        };
    }
    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
