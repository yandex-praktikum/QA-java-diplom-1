import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBun {

    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;
    private Bun bun;

    public TestBun(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", 100.5f, "black bun", 100.5f},
                {"white bun", 200.7f, "white bun", 200.7f},
                {"red bun", 300.8f, "red bun", 300.8f}
        };
    }

   @Before
   public void preparationBons() {
        bun = new Bun(name, price);
   }

    @Test
    public void TestReturnCorrectBunsName() {
        String actualBunName = bun.getName();
        assertEquals(expectedName, actualBunName);
    }

    @Test
    public void TestReturnCorrectBunsPrice() {
        float actualBunPrice = bun.getPrice();
        int delta = 2;
        assertEquals(expectedPrice, actualBunPrice, delta);
    }
}
