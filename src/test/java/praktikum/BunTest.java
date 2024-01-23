package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;



@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bun;

    public BunTest(String name, float price) {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters
    public static Object[][] getBun(){
        return new Object[][]{
                {"FirstBun", 1000},
                {"SecondBun", 100.02f},
                {"Булочка", 0},
        };
    }

    @Test
    public void getNameTest() {
        String expectedName = bun.name;
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest() {
        int delta = 0;
        float expectedPrice = bun.price;
        float actualPrice= bun.getPrice();
        assertEquals(expectedPrice, actualPrice, delta);
    }
}