import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

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
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
                {"red bun", 6.00f},
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
