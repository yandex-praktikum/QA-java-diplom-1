import org.junit.Test;
import praktikum.Bun;


import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getBunName()  {
        Bun bun = new Bun("black bun", 100);

        assertEquals("Bun is incorrect", "black bun", bun.getName());
    }

    @Test
    public void getBunPrice() {
        Bun bun = new Bun("white bun", 200);

        assertEquals("Price is incorrect", 200, bun.getPrice(), Float.NaN);
    }
}
