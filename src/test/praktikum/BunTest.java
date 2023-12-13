package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class  BunTest {
    Bun bun;
    @Before
    public void setBun() {
        bun = new Bun("name",50.0f);
    }
    @Test
    public void getNameEqual(){
        assertEquals("name",bun.getName());
    }
    @Test
    public void getPriceEqual(){
        assertEquals(50.0f,bun.getPrice(),0);
    }

}