import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTests {

    @Test
    public void getIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "BBQ", 70f);

        float expectedPrice = 70;
        float actualPrice = ingredient.getPrice();

        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getIngredientNameTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "BBQ", 90f);

        String expectedName = "BBQ";
        String actualName = ingredient.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "BBQ", 110f);

        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();

        Assert.assertEquals(expectedType, actualType);
    }
}