import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {
    private String name;
    private float price;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{0} : {1}")
    public static Object[][] getBuns() {
        return new Object[][] {
                {"black bun", 100F},
                {"white bun", 200F},
                {"red bun", 300F}
        };
    }

    @Test
    public void getNameReturnBunsName() {
        Bun bun = new Bun(name,price);
        assertEquals(name, bun.getName());
    }
    @Test
    public void getPriceReturnBunsPrice() {
        Bun bun = new Bun(name,price);
        assertEquals(price, bun.getPrice(), 0);
    }

}
