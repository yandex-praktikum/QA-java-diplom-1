package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE,"тест",1.0F);
    @Test
    public void getPrice() {
        assertEquals(1,ingredient.getPrice(),0);
    }

    @Test
    public void getName() {
        assertEquals("тест",ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(SAUCE,ingredient.getType());
    }
}