package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp()  {
        bun = new Bun("test bun", 500.45f);
    }

    @Test
    public void getNameShouldReturnExpectedName() {
        String expectedResult = "test bun";
        assertEquals(String.format("Bun name should be '%s'", expectedResult), expectedResult, bun.getName());
    }

    @Test
    public void getPriceShouldReturnExpectedPrice() {
        float expectedResult = 500.45f;
        assertEquals(expectedResult, bun.getPrice(), 0.0);
    }
}
