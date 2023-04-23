package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
  private Bun bun;
    @Before
    public void createNewBunCase() {
         bun = new Bun("Флюоресцентная булка R2-D3", 1976.0f);
    }

    @Test
    public void getNameTest()
    {
        assertEquals("Проверка названия булочки","Флюоресцентная булка R2-D3", bun.getName());
    }
    @Test
    public void getPriceTest()
    {
        assertEquals("Проверка стоимости",1976.0f, bun.getPrice(), 0);

    }
}