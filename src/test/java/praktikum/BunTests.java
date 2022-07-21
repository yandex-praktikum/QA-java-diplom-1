package praktikum;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

//тут можно и параметризированный, использую его в тестировании класса Ingredient для разнообразия
public class BunTests {

    private Bun bun;

    @Before
    public void setup(){
      bun = new Bun("булка", 200f);
    }

    @Test
    public void shouldReturnCorrectNameOfBun(){
        final String expectedName = "булка";
        assertEquals("Наименования не совпадают!", expectedName, bun.getName());
    }

    @Test
    public void shouldReturnCorrectPriceOfBun(){
        final float expectedPrice = 200f;
        assertEquals("Цены не совпадают!", expectedPrice, bun.getPrice(), 0);
    }
}
