package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String nameField;
    private final float priceField;

    public BunTest(String nameField, float priceField) {
        this.nameField = nameField;
        this.priceField = priceField;
    }

    @Parameterized.Parameters
    public static Object[][] testParams() {
        return new Object[][] {
            {"Товар 1", 5.00f},
            {"Товар 2", 10.00f}
        };
    }

    @Test
    public void newBunNameCheckTest() {
        Bun bun = new Bun(nameField, priceField);
        assertEquals(nameField, bun.getName());
    }

    @Test
    public void newBunPriceCheckTest() {
        Bun bun = new Bun(nameField, priceField);
        assertEquals(priceField, bun.getPrice(), 0);
    }

}