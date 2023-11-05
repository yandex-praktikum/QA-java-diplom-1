import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


public class TestBun {
    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 1.50f);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 1.50f);
        assertEquals(1.50f, bun.getPrice(), 0.001);
    }

    @Test
    public void testSetName() {
        Bun bun = new Bun("black bun", 1.50f);
        bun.setName("Chocolate");
        assertEquals("Chocolate", bun.getName());
    }

    @Test
    public void testSetPrice() {
        Bun bun = new Bun("black bun", 1.50f);
        bun.setPrice(2.00f);
        assertEquals(2.00f, bun.getPrice(), 0.001);
    }
}

