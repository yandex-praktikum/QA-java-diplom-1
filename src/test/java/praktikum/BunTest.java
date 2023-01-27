package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunParams(){
        return new Object[][] {
                {"Бургер", 2550000},
                {"", 19.888E-3f},
        };
    }
    @Before
    public void setUp(){
        bun = new Bun(name,price);
    }

    @Test
    public void shouldBunReturnsItName() {

        String actualResult = bun.getName();
        String expected = name;
        assertEquals(expected,actualResult);
    }

    @Test
    public void shouldBunReturnsItPrice() {
        float actualResult = bun.getPrice();
        float expected = price;
        assertEquals(expected,actualResult,0);
    }
}