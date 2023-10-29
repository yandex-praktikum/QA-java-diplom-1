package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    public final static Double delta = 0.001;
    Bun bun;

    public BunTest(String name,float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getBunData(){
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun",300},
                {"",0},
                {null,1}
        };
    }
    @Before
    public void setUP() {
        bun = new Bun(name,price);
    }
    @Test
    public void getNameTest() {
        String actualResult = bun.getName();
        assertEquals(name,actualResult);
    }
    @Test
    public void getPriceTest() {
        float actualResult = bun.getPrice();
        assertEquals(price,actualResult,delta);
    }
}