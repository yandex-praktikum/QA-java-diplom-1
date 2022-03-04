package praktikum;

import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class BunTest {
    private Bun bun;

    // Dummy class parameters
    private final String name;
    private final float price;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        String actualName = bun.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getPrice() {
        float delta = 0.0f;
        float actualPrice = bun.getPrice();
        assertEquals(price, actualPrice, delta);
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }
}