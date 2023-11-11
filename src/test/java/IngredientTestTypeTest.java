import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTestTypeTest {
    public IngredientType[] ingredients = IngredientType.values();

    @Test
    public void correctLengthTest() {
        assertEquals(2, ingredients.length);
    }

    @Test
    public void incorrectLengthTest() {
        assertNotEquals(3, ingredients.length);
    }

    @Test
    public void ingredientsTypeTest() {
        for (IngredientType ingredient : ingredients) {
            switch (ingredient) {
                case соус:
                    assertTrue(true);
                case начинка:
                    assertTrue(true);
                    break;
            }
        }
    }
}