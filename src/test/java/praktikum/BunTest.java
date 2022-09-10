package praktikum;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BunTest {
    public Float actualPrice = new Random().nextFloat();
    public String actualName = "KolyaevBun" + new Random().nextInt(10);

    @Test
    public void checkGetNameReturnsStringFromParameters() {
        Bun bun = new Bun(actualName, actualPrice);
        String expectedName = bun.getName();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void checkGetPriceReturnsFloatFromParameters() {
        Bun bun = new Bun(actualName, actualPrice);
        Float expectedPrice = bun.getPrice();
        assertEquals(expectedPrice,actualPrice);
    }
}