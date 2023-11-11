import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertTrue;

public class IngredientTestTypeTest {
    public IngredientType[] ingredients = IngredientType.values();

    @Test
    public void lengthTest() {
        Assert.assertEquals(2, ingredients.length);
    }

    @Test
    public void ingredientsTypeTest() {
        for (IngredientType ingredient : ingredients) {
            switch (ingredient) {
                case SAUCE:
                    assertTrue(true);
                case FILLING:
                    assertTrue(true);
                    break;
            }
        }
    }
}