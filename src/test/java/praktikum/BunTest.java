package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
        this.bun = new Bun(name, price);
    }

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"", 1000000000F},
                {"redbuntestisverylongstringforparamterizedtest", -1},
                {null, 0}
        });
    }


    @Test
    public void getNameReturnsBunName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnsBunPrice() {
        assertEquals(price, bun.getPrice(), 0.01);
    }
}