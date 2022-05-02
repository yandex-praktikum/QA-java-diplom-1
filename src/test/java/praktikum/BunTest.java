package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.github.javafaker.Faker;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    static Faker faker = new Faker();
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {faker.lorem().fixedString(1), 100},
                {faker.lorem().fixedString(100), 100},
                {faker.lorem().fixedString(50), Float.MIN_NORMAL},
                {faker.lorem().fixedString(50), Float.MAX_VALUE},
                {null, 100},
                {"", 100},
                {faker.lorem().fixedString(50), 0},
        };
    }

    @Before
    public void setUp() throws Exception {
        bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(price, bun.getPrice(), 0);
    }
}