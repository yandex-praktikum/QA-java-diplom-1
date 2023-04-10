import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {null, 2F},
                {"", Float.MIN_VALUE},
                {"loooooooooooooooooooooooooooooooooong", -Float.MAX_VALUE},
                {"#^$#@*", Float.MAX_VALUE},
                {"б", 20F},
                {"free булочка", 0}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
