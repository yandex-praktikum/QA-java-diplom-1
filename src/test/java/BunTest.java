import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun = new Bun("Имя", 2.3F);

    @Test
    public void getBunNameTest() {
        assertEquals("Название не совпадает", "Имя" ,bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        assertEquals("Цена не совпадает",2.3F, bun.getPrice(),  0);
    }

}
