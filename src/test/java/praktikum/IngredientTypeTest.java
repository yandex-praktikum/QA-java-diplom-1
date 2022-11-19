package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkFirstValue() {
        IngredientType ingredientType = IngredientType.valueOf("SAUCE");
        assertEquals(0, ingredientType.ordinal());
    }

    @Test
    public void checkSecondValue() {
        IngredientType ingredientType = IngredientType.valueOf("FILLING");
        assertEquals(1, ingredientType.ordinal());
    }

    @Test
    public void checkSize() {
        IngredientType[] ingredientType = IngredientType.values();
        assertEquals(2, ingredientType.length);
    }

}
