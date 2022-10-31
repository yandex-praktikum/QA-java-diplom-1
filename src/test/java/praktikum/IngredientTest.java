package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest extends BaseClass {

    @Test
    public void shouldGetPriceTest() {
     assertEquals(price, ingredient1.getPrice(), 0.01);
    }

    @Test
    public void shouldGetNameTest() {
        assertEquals(nameBurger,ingredient1.getName());
    }

    @Test
    public void shouldGetTypeTest() {
        assertEquals(IngredientType.SAUCE, ingredient1.getType());
        assertEquals(IngredientType.FILLING, ingredient2.getType());
    }
}