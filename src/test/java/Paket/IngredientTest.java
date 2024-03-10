package Paket;

import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void checkGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        float expectedPrice = 200;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void checkGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300);
        String expectedName = "sausage";
        String actualName = ingredient.getName();
        Assert.assertEquals("Ошибка в названии ингредиента", expectedName, actualName);
    }

    @Test
    public void checkGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        String expectedType = "SAUCE";
        String actualType = ingredient.getType().toString();
        Assert.assertEquals("Ошибка в типе ингредиента", expectedType, actualType);
    }
}
