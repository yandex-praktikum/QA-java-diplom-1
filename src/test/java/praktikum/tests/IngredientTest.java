package praktikum.tests;


import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {
    @Test
    public void checkGetPriceReturnsIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        float actualPrice = ingredient.getPrice();

        Assert.assertEquals(ingredient.getPrice(), actualPrice, 0);

    }

    @Test
    public void checkGetNameReturnsIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        String actualName = ingredient.getName();

        Assert.assertEquals(ingredient.getName(), actualName);
    }

    @Test
    public void checkGetTypeReturnsIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        String actualType = String.valueOf(ingredient.getType());

        Assert.assertEquals(String.valueOf(ingredient.getType()), actualType);
    }

}
