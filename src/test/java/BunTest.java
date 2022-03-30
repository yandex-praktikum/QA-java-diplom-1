import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest() {
        String expected = "Булочка";
        Bun bun = new Bun("Булочка", 100);

        String actual = bun.getName();

        assertEquals("Имена не совпадают", expected, actual);
    }

    @Test
    public void getPriceTest() {
        float expected = (float) 100.00;
        Bun bun = new Bun("Булочка", (float) 100.00);

        float actual = bun.getPrice();

        assertEquals("Цены не совпадают", expected, actual, 0);
    }
}
