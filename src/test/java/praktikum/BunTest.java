package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;
    private final String name = "Tasty bun";
    private final float price = 18;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameOfTheBun() {
        assertEquals("Наименование булочки", name, bun.getName());
    }

    @Test
    public void getPriceOfTheBun() {
        assertEquals("Выводит цену булочки в 18 ед.", price, bun.getPrice(), 0);
    }
}
