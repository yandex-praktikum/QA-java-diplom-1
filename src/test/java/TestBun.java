import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


public class TestBun {
    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 100);
        assertEquals(100, bun.getPrice(), 0.001);
    }

    @Test
    public void testSetName() {
        Bun bun = new Bun("black bun", 100);
        bun.setName("Chocolate");
        assertEquals("Chocolate", bun.getName());
    }

    @Test
    public void testSetPrice() {
        Bun bun = new Bun("black bun", 100);
        bun.setPrice(200);
        assertEquals(200, bun.getPrice(), 0.001);
    }
}

