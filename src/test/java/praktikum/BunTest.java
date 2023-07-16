package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getBunParams() {
        return new Object[][]{
                {"Булка с космической пылью", 100},
                {"", Float.MIN_VALUE},
                {null, 0},
                {" ", -1},
                {" bun with black dust ", Float.MAX_VALUE}
        };
    }
    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    @Test
    public void getNameReturnName(){
        assertEquals(name, bun.getName());
    }
    @Test
    public void getPriceReturnPrice(){
        assertEquals(price, bun.getPrice(), 0);
    }
}
