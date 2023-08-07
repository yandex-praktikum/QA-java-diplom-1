import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
public class BunTest {
    Bun bun = new Bun("black bun", 100);
    @Test
    public void getNameTest() {
        assertEquals(bun.getName(), "black bun");
    }
    @Test
    public void getPriseTest() {
        assertEquals(bun.getPrice(), 100, 1);
    }
    }
