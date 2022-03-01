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
        assertEquals("Ingredient back prise in getPrice method", INGREDIENT_PRISE, resultGetPrice);
    }

    @Test
    public void getNameIngredient() {
        String resultGetName = ingredient.getName();
        assertEquals("Ingredient back name in getName method", INGREDIENT_NAME, resultGetName);
    }

    @Test
    public void getTypeIngredient() {
        IngredientType resultGetType = ingredient.getType();
        assertEquals("Ingredient back type in getType method", INGREDIENT_TYPE, resultGetType);
    }
}
