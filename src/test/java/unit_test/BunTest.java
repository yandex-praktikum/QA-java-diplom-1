package unit_test;
import date.CreateRandomBun;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;


public class BunTest {
    private CreateRandomBun randomBun = new CreateRandomBun();
    Bun bun;

    String bunName = randomBun.getRandomBun().getName();
    float bunPrice = randomBun.getRandomBun().getPrice();

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getNameTest() {
        String actual = bun.getName();
        assertEquals(bunName, actual);
    }

    @Test
    public void getPriceTest() {
        float actual = bun.getPrice();
        assertEquals(bunPrice, actual, 0);
    }
}
