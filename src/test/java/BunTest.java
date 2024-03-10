import org.junit.Test;
import praktikum.Bun;

import static junit.framework.TestCase.assertEquals;
// Покрой тестами классы Bun, Burger, Ingredient, IngredientType.
public class BunTest {
    @Test
    public void testGetName() {
        Bun bun = new Bun("FluBun", 1.50f);
        assertEquals("FluBun", bun.getName());
    }

    @Test
    public void testGetPrice(){
        Bun bun = new Bun("KratorsBun", 2.10f);
        assertEquals(2.10f, bun.getPrice());
    }


}
