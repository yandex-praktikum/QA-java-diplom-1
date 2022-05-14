package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private Bun bun;
    private final String name;
    private final float price;


    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Bun`s name: {0}, price: {1}")
    public static Object[] maneParameters() {
        return new Object[][]{
                {"black bun", 100.55f},
                {"white bun", 200.4f},
                {"green bun", 300f},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void withParametersPriceTest() {
        float actual = bun.getPrice();

        assertEquals(0, Float.compare(price, actual));
    }

    @Test
    public void withParametersNameTest() {
        String actual = bun.getName();

        assertEquals(name, actual);
    }
}