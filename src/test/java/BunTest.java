import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final Bun expectBun;

    public BunTest(String name, float price, Bun expectBun) {
        this.name = name;
        this.price = price;
        this.expectBun = expectBun;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Test", 100500, new Bun("Test", 100500)},
                {null, 100500, new Bun(null, 100500)},
                {"Test", 0, new Bun("Test", 0)},
                {"Test", -1, new Bun("Test", -1)}
        };
    }

    @Test
    public void bunCreateTest() {
        Bun actualBun = new Bun(name, price);
        assertEquals(expectBun.getName(), actualBun.getName());
        assertTrue(Math.abs(expectBun.getPrice() - actualBun.getPrice()) < 0.00001);
    }
}
