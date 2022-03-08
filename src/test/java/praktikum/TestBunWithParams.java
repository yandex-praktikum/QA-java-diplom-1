package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestBunWithParams {
    private final String passedName;
    private final float passedPrice;

    public TestBunWithParams(String passedName, float passedPrice) {
        this.passedName = passedName;
        this.passedPrice = passedPrice;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][] {
                { "Булочка 1", 100.0f },
                { "Булочка 2", 0.0f },
                { "Булочка 3", -10.0f },
                { "", 120.50f }
        };
    }

    @Test
    public void testGetNameReturnsPassedName() {
        Bun bun = new Bun(passedName, passedPrice);
        assertNotNull(bun);
        assertEquals(passedName, bun.getName());
    }

    @Test
    public void testGetPriceReturnsPassedPrice() {
        Bun bun = new Bun(passedName, passedPrice);
        assertNotNull(bun);
        assertEquals(passedPrice, bun.getPrice(), 0f);
    }
}
