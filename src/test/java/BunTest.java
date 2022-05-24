import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void shouldReturnName() {
        Bun bun = new Bun("Olga", 65);
        String actual = bun.getName();
        String expected = "Olga";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPrice() {
        Bun bun = new Bun("Olga", 65);
        float actual = bun.getPrice();
        float expected = 65;
        assertEquals(expected, actual, 0);
    }
}
