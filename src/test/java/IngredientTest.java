import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private static final String INGREDIENT_NAME = "Булочка с кунжутом";
    private static final float INGREDIENT_PRICE = 20;
    private static final IngredientType INGREDIENT_TYPE = IngredientType.SAUCE;
    Ingredient ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);

    @Test
    public void getNameCorrectValue() {
        String expectedValue = INGREDIENT_NAME;
        String actualValue = ingredient.getName();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPriceCorrectValue() {
        float expectedValue = INGREDIENT_PRICE;
        float actualValue = ingredient.getPrice();
        assertEquals(expectedValue, actualValue, 0.00);
    }

    @Test
    public void getTypeCorrectValue() {
        IngredientType expectedValue = INGREDIENT_TYPE;
        IngredientType actualValue = ingredient.getType();
        assertEquals(expectedValue, actualValue);
    }


}
