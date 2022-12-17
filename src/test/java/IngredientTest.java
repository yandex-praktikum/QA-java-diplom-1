import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {
    IngredientType ingredientType = IngredientType.SAUCE;
    String ingredientName = "Test bun name";
    float ingredientPrice = 1234.56f;
    Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);

    @Test
    public void getIngredientPricePriceGet() {
        Assert.assertEquals("Price is not correct", ingredientPrice, ingredient.getPrice(), 0.001);
    }

    @Test
    public void getIngredientNameNameGet() {
        Assert.assertEquals("Name is not correct", ingredientName, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTypeGet() {
        Assert.assertEquals("Type is not correct", ingredientType, ingredient.getType());
    }

}
