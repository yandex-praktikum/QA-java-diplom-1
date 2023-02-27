package praktikum.tests;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {
    @Test
    public void checkGetTypeOfIngredientsReturnsIngredientSource() {
        String expectedIngredient = "SAUCE";
        String actualIngredient = String.valueOf(IngredientType.SAUCE);
        assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    public void checkGetTypeOfIngredientsReturnsIngredientFilling() {
        String expectedIngredient = "FILLING";
        String actualIngredient = String.valueOf(IngredientType.FILLING);
        assertEquals(expectedIngredient, actualIngredient);
    }
}
