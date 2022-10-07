import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {

    private Bun bun;
    private String bunName = "Random bun";
    private float bunPrice = 123.45f;

    @Before
    public void createBun() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void shouldGetName() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void shouldGetPrice() {
        assertEquals(bunPrice, bun.getPrice(), 0.0);
    }
}
