import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getNameCorrectMethodTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        String expectedName = "hot sauce";
        String actualName = ingredient.getName();
        assertEquals("Method incorrect", expectedName, actualName);
    }

    @Test
    public void getPriceCorrectMethodTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        float expectedPrice = 100;
        float actualPrice = ingredient.getPrice();
        assertEquals("Method incorrect", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getTypeCorrectMethodTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "hot sauce", 100);
        IngredientType expectedType = IngredientType.FILLING;
        IngredientType actualType = ingredient.getType();
        assertEquals("Method incorrect", expectedType, actualType);
    }
}
