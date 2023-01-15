package bun;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String name = "Вкусняшка";
    private final float price = 666;
    Bun bun = new Bun(name, price);

    @Test
    public void getNameReturnName() {
        assertEquals("Вкусняшка", bun.getName());
    }

    @Test
    public void getPriceReturnPrice() {
        assertEquals(666.0, bun.getPrice(), 0.01);
    }
}
