package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

public class BunTest {

    String bunName = "tasty bun";
    float bunPrice = 109;

    Bun bun = new Bun(bunName, bunPrice);

   @Test
    public void testGetBunsName() {
    String actualName = bun.getName();
       assertEquals("wrong bun's name", bunName, actualName);
    }

    @Test
    public void testGetBunsPrice() {
        float actualPrice = bun.getPrice();
        assertEquals("wrong bun's price", bunPrice, actualPrice, 0);
    }
}