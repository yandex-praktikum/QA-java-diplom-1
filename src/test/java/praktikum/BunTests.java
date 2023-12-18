package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {

    public final String nameExpected;
    public final float priceExpected;


    public BunTests (String nameExpected, float priceExpected) {
        this.nameExpected = nameExpected;
        this.priceExpected = priceExpected;
    }

        @Parameterized.Parameters
        public static Object[][] testBunData() {
            return new Object[][] {
                    {"Флюоресцентная булка", 3.14f},
                    {"Краторная булка", 1.23e-4f},
                    {"Вкусная булка 123", -777f},
                    {"987654", 0f},
            };
        }

    @Test
    public void getNameBunTest() {
        Bun bun = new Bun(nameExpected,priceExpected);
        assertEquals(nameExpected, bun.getName());
        }

    @Test
    public void getPriceBunTest() {
        Bun bun = new Bun(nameExpected,priceExpected);
        assertEquals(priceExpected, bun.getPrice(), 0);
    }

}
