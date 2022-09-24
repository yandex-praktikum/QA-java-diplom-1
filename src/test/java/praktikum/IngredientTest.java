package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    // Тест получения цены ингредиента
    @Test
    public void getPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Hot sauce", 200);
        float expectedPrice = 200;

        float realPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, realPrice, 0);
    }

    // Тест получения названия ингредиента
    @Test
    public void getNameReturnsName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Hot sauce", 200);
        String expectedName = "Hot sauce";

        String realName = ingredient.getName();
        Assert.assertEquals(expectedName, realName);
    }

    // Тест получения типа ингредиента
    @Test
    public void getTypeReturnsType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Hot sauce", 200);
        IngredientType expectedType = IngredientType.SAUCE;

        IngredientType realType = ingredient.getType();
        Assert.assertEquals(expectedType, realType);
    }
}
