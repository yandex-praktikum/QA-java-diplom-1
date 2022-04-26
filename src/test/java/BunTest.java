import static org.junit.Assert.*;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    Bun bun = new Bun("Краторная булка N-200i", 1255);

    @Test
    public void getName() {
        assertEquals("Неверное название булки", "Краторная булка N-200i", bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Неверная стоимость булки", 1255, bun.getPrice(), 0);
    }
}