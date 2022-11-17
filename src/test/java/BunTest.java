import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import praktikum.*;

public class BunTest {

    Bun bun;

    @Before
    public void setup() {
        bun = new Bun("Булочка с кунжутом", 100);
    }

    @Test
    public void shouldGetName() {
        String actual = "Булочка с кунжутом";
        assertEquals(actual, bun.getName());
    }

    @Test
    public void shouldGetPrice() {
        float actual = 100;
        assertEquals(actual, bun.getPrice(),0);
    }
}