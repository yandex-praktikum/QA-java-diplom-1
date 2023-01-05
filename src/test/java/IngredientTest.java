import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    String ingredientName = "sour cream";
    float ingredientPrice = 200;

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,ingredientName,ingredientPrice);
        String actualIngredientName = ingredient.getName();
        assertEquals("In class Ingredient getName method returns incorrect value", ingredientName, actualIngredientName);
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,ingredientName,ingredientPrice);
        float actualIngredientPrice = ingredient.getPrice();
        assertEquals("In class Ingredient getPrice method returns incorrect value", ingredientPrice, actualIngredientPrice, 0);
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,ingredientName,ingredientPrice);
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals("In class Ingredient getType method returns incorrect value", IngredientType.SAUCE, actualIngredientType);
    }
}
