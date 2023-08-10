import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


public class TestBun {
    @Test
    public void testBun(){
        Bun bun = new Bun("Ржаная", 10f);
        assertEquals("Ржаная", bun.getName());
        assertEquals(10f, bun.getPrice(), 0f);
    }

}
