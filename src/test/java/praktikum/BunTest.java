package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private String expectedName;
    private float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: creating bun with({0},{1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"white bread", 100f},
                {"black bread", 200f}
        });
    }

    @Test
    public void testCreateBun() {
        Bun bun = new Bun(expectedName, expectedPrice);

        assertEquals("Names should be the same!",
                bun.getName(),
                expectedName);

        assertEquals("Prices should be the same!",
                bun.getPrice(),
                expectedPrice,
                0);
    }

}