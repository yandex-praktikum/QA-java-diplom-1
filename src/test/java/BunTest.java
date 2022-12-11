import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    private Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    @Test
    public void returnNameOfBun(){
        String result = bun.getName();
        assertEquals(name, result);
    }

    @Test
    public void returnPriceOfBun(){
        Float result1 = bun.getPrice();
        assertEquals(price, result1, 0);
    }
}
