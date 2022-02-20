import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestIngredient {

    final String INGREDIENT_NAME = "Test";
    final Float INGREDIENT_PRISE = 5.5f;
    final IngredientType INGREDIENT_TYPE = IngredientType.SAUCE;
    private Ingredient ingredient;

    @Before
    public void before() {
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRISE);
    }

    @Test
    public void getPriceIngredient() {
        Float resultGetPrice = ingredient.getPrice();
        assertEquals(INGREDIENT_PRISE, resultGetPrice);
    }

    @Test
    public void getNameIngredient() {
        String resultGetName = ingredient.getName();
        assertEquals(INGREDIENT_NAME, resultGetName);
    }

    @Test
    public void getTypeIngredient() {
        IngredientType resultGetType = ingredient.getType();
        assertEquals(INGREDIENT_TYPE, resultGetType);
    }
}
