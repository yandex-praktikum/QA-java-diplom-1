import net.bytebuddy.utility.RandomString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {"black bun", 100f},
                {RandomString.make(75), Float.MAX_VALUE}, // Роберт Брингхерст в книге «Основы стиля в типографике» - оптимальное значение длины строки составляет от 45 до 75 знаков.
                {RandomString.make(1), Float.MIN_VALUE},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void shouldReturnName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void shouldReturnPrice() {
        assertEquals(price, bun.getPrice(), 0);
    }
}
