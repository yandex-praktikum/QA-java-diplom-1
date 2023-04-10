import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestParameters() {
        return new Object[][]{
                {"", 100f},
                {null, 200f},
                {"Тип float занимает в памяти компьютера 32 бита и может принимать значения " +
                        "в интервале [3.4E-38; 3.4E+38) (иными словами, в интервале от 3.4*10ˉ³⁸ " +
                        "(включительно) до 3.4 * 10³⁸ (исключая))", 300},
                {"black bun 1", 100f},
                {"white bun +-", 200f},
                {"red bun &%", 300f},
                {"black.,; bun", 100f},
                {"white bun/*", 200f},
                {"red bun", -300f},
                {"black bun", 0f},
                {"white bun", 3/5},
                {"red bun", (float)3/5},
                {"black bun", -Float.MAX_VALUE},
                {"white bun", Float.MAX_VALUE},
                {"red bun", Float.MIN_VALUE},
                {"black bun", Float.NEGATIVE_INFINITY},
                {"white bun", Float.POSITIVE_INFINITY},
                {"red bun", -Float.MIN_VALUE}
        };
    }

    @Test
    public void getNameRTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Sorry, price incorrect", price, bun.getPrice(), 0);
    }
}