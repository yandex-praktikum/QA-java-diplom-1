import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][]{
                {"Булочка", 10, "Булочка", 10},
                {"black bun", 10000, "black bun", 10000}
        };
    }

    @Test
    public void getPriceReturnsValidParametrs(){
        Bun bun = new Bun(name, price);

        String actualName = bun.getName();
        float actualPrice = bun.getPrice();

        assertEquals(expectedName, actualName);
        assertEquals(expectedPrice, actualPrice, 0);
    }
}