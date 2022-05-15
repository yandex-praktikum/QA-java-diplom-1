import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {

    Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);

    @Test
    public void getName() {
        assertEquals("Название булочки не совпадает.", "Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Цена булочки не совпадает.", 988, bun.getPrice(), 0);
    }
}