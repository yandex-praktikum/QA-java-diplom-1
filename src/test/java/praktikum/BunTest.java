package praktikum;
import static org.junit.Assert.*;
import org.junit.Test;

public class BunTest {

    Bun bun = new Bun("Краторная булка N-200i", 1255);

    @Test
    void getName() {
        assertEquals("Неверное название булки", "Краторная булка N-200i", bun.getName());
    }

    @Test
    void getPrice() {
        assertEquals("Неверная стоимость булки", 1255, bun.getPrice());
    }
}