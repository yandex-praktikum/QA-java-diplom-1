import org.junit.jupiter.api.Test;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BunTest {
    @Test
    public void getNameTest() {
        Bun bun =new Bun("test",1000);
        assertEquals("test", bun.getName());
    }
    @Test
    public void getPriceTest() {
        Bun bun =new Bun("test",1000);
        assertEquals(1000.0, bun.getPrice());
    }
    //дописать параметризованный тест
}
