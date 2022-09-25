import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class TestBun {

    @Test
    public void testGetName(){
        Bun bun = new Bun("Wheat", 8.5F);
        assertEquals("Wheat",bun.getName());
    }

    @Test
    public void testGetPrice(){
        Bun bun = new Bun("Wheat", 8.5F);
        assertEquals(8.5F,bun.getPrice(), 0.0f);
    }
}
