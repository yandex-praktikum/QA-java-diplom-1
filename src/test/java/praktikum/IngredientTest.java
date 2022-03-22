package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

public class IngredientTest {

    @Test
    public void checkGetPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "Железобетонная булочка", 393F);
        float actual = ingredient.getPrice();
        assertEquals(393F, actual, 0F);
    }

    @Test
    public void checkGetName() {
        Ingredient ingredient = new Ingredient(SAUCE, "Железобетонная булочка", 393F);
        String actual = ingredient.getName();
        assertEquals("Железобетонная булочка", actual);
    }

    @Test
    public void checkGetType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Железобетонная булочка", 393F);
        IngredientType actual = ingredient.getType();
        assertEquals(SAUCE, actual);
    }
}