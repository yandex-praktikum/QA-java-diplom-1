package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    String bunName = "Булочка с кунжутом";
    float bunPrice = 0.2f;
    Bun bun = new Bun(bunName, bunPrice);

    @Test
    public void getName() {
        String actual = bun.getName();
        assertEquals(bunName, actual);
    }

    @Test
    public void getPrice() {
        float actual = bun.getPrice();
        assertEquals(bunPrice, actual, 0);
    }
}