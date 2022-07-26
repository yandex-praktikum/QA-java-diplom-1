package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IngredientTest {

    @Test
    public void getPrice() {
        var expected = 100f;
        var ingredient = new Ingredient(IngredientType.SAUCE, "cheese", expected);
        assertEquals(expected, ingredient.getPrice(), 0f);
    }

    @Test
    public void getName() {
        var expected = "cheese";
        var ingredient = new Ingredient(IngredientType.SAUCE, expected, 100f);
        assertEquals(expected, ingredient.getName());
    }

    private Object[] parametersForGetType() {
        return IngredientType.values();
    }

    @Test
    @Parameters
    public void getType(IngredientType expected) {
        var ingredient = new Ingredient(expected, "cheese", 100f);
        assertEquals(expected, ingredient.getType());
    }
}