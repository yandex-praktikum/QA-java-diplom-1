import praktikum.Bun;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameters
    public static Collection<Object[]> setData() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100f},
                {"пшеничная булочка", -10f},
                {"", 0f},
                {"10.5", 10.5f},
        });
    }

    @Before
    public void startTest(){
        bun = new Bun(name,price);

    }
    @Test
    public void testGetValidName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetValidPrice() {
        assertEquals(price, bun.getPrice(), 0.001f);
    }
}