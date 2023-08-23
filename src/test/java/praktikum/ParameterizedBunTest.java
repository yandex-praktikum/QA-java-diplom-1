package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedBunTest {
    private String bunName;
    private float bunPrice;

    public ParameterizedBunTest(String name, float price) {
        this.bunName = name;
        this.bunPrice = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Test Bun 1", 500f},
                {"Test Bun 2", 194f},
                // Add more test cases here
        });
    }

    @Test
    public void testBunGetName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0.01);
    }
}
