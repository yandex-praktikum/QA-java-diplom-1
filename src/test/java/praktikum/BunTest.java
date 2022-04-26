package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun;

    @Before
    public void createBun() {
        bun = new Bun ("bunName", 1f);
    }

    @Test
    public void testGetName() {
        String expectedName = "bunName";
        assertEquals ("Bun's title doesn't match to expected one.", "bunName", bun.getName ());

    }

    @Test
    public void testGetPrice() {
        assertEquals ("Bun's price doesn't equal to expected one.", 1f, bun.getPrice (), 0.0);
    }
}