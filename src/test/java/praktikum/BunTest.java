package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.Сonstants.*;


public class BunTest {
    private Bun bun;


    @Before
    public void createNewBun() {
        bun = new Bun(NAME_BUN_WITH_SESAME, PRICE_20_1F);
    }

    @Test
    public void getName() {
        assertEquals("Проверяем соответствие названия булочки", NAME_BUN_WITH_SESAME, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Проверяем соответствие цены", PRICE_20_1F, bun.getPrice(), DELTA_0);
    }
}
