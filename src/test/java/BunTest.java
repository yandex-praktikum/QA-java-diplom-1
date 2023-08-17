import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Test Bun 1", 100f},
                {"Test Bun 2", 150f},
                {"Test Bun 3", 200f}
        });
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0.01);
    }
}
