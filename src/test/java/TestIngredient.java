import org.testng.Assert;
import org.testng.annotations.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class TestIngredient {

    @Test
    public void getPriceTest() {
        IngredientType type = IngredientType.SAUCE;
        float expectedPrice = 100;
        String name = "testName";
        Ingredient ingredient = new Ingredient(type, name, expectedPrice);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getNameTest() {
        IngredientType type = IngredientType.SAUCE;
        float price = 100;
        String expectedName = "testName";
        Ingredient ingredient = new Ingredient(type, expectedName, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getType() {
        IngredientType expectedType = IngredientType.SAUCE;
        float price = 100;
        String name = "testName";
        Ingredient ingredient = new Ingredient(expectedType, name, price);
        IngredientType actualType =ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }
}
