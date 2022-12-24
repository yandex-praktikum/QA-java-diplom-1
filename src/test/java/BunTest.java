import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    private Bun bun;

    @Before
    public void createBun() {
        bun = new Bun("default_bun", 200.0f);
    }

    @Test
    public void testBunGetName() {
        String expectName = "default_bun";
        String actualName = bun.getName();

        assertEquals("Incorrect bun name value", expectName, actualName);
    }

    @Test
    public void testBunGetPrice() {
        float expectPrice = 200.0f;
        float actualPrice = bun.getPrice();

        assertEquals("Incorrect bun price value", expectPrice, actualPrice, 0.0f);
    }
}