package praktikum;
import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("Булка",100);
        String actual = bun.getName();
        assertEquals("Булка",actual);
    }
    @Test
    public void getPrice() {
        Bun bun = new Bun("Булка",100);
        float actual = bun.getPrice();
        assertEquals(100,actual,0);
    }
}