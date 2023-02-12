import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;

    public BunTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerName() {
        return new Object[][]{
                {"KFC"},
                {"Mac"}
        };
    }

    Bun bun;

    @Before
    public void setBun() {
        bun = new Bun(name, 50);
    }

    @Test
    public void checkCanGetBunName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void checkErrorWhenIncorrectBunName() {
        assertNotEquals("bunBun", bun.getName());
    }

    @Test
    public void checkCanGetBunPrice() {
        assertEquals(50, bun.getPrice(), 0);
    }

    @Test
    public void checkErrorWhenIncorrectPrice() {
        assertNotEquals(10, bun.getPrice(), 0);
    }
}
