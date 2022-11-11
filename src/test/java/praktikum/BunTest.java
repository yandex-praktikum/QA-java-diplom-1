package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String nameExpected;
    private final float priceExpected;

    public BunTest(String nameExpected, float priceExpected) {
        this.nameExpected = nameExpected;
        this.priceExpected = priceExpected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getKittensCountData() {
        return new Object[][]{
                {"cutlet", 45.3f},
                {"minced meat", 0f},
                {"sfgdvjeroiferf", 90.3f},
                {"234234234", 345.5f},
                {"sdf435FEF", 1f},
                {"0", 0f},
        };
    }

    @Test
    public void createABunSetAndGetCheckPositive() {
        bun = new Bun(nameExpected, priceExpected);
        String nameActual = bun.getName();
        float priceActual = bun.getPrice();
        Assert.assertEquals(nameExpected, nameActual);
        Assert.assertTrue(priceActual == priceExpected);
    }
}
