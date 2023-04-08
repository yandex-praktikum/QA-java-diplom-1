package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"black bun", 0},
                {null, 500},
                {" ", 20},
                {"&8bhg!@", 1234567891011121314151617181920f},
                {"1254563", 700},
                {"red bun", 123.00f},
                {"white bun", -52},
        };
    }
    @Test
    public void getNameTest(){
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.001);
    }
}

