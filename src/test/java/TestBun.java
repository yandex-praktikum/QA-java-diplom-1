import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


public class TestBun {
    @Mock
    Bun bun = new Bun("black bun", 100);
    @Test
    public void testGetName() {
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(100, bun.getPrice(), 0.001);
    }

    @Test
    public void testSetName() {
        bun.setName("Chocolate");
        assertEquals("Chocolate", bun.getName());
    }

    @Test
    public void testSetPrice() {
        bun.setPrice(200);
        assertEquals(200, bun.getPrice(), 0.001);
    }
}

