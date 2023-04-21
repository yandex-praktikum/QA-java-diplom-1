import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void start() {
        bun = new Bun("Флюоресцентная булка R2-D3", 988);
    }

    @Test
    public void getName() {
        String actualName = bun.getName();
        String expectedName = "Флюоресцентная булка R2-D3";
        assertEquals("Ошибка при получении имени", expectedName, actualName);
    }

    @Test
    public void getPrice() {
        float expectedPrice = 988f;
        float actualPrice = bun.getPrice();
        assertEquals("Ошибка при получении имени", expectedPrice, actualPrice, 0.01f);
    }
}
