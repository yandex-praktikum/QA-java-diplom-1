package part.one.test;

import org.junit.Test;
import part.one.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void bunTest() {

        String bunName = "Sesame Bun";
        float bunPrice = 2.5f;

        Bun bun = new Bun(bunName, bunPrice);

        assertEquals(bunName, bun.getName());
        assertEquals(bunPrice, bun.getPrice(), 0.001);
    }
}
