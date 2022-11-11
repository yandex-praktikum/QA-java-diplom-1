import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient;

    @Test
    public void getPriceTest() {
        float expected = 100F;
        ingredient = new Ingredient(IngredientType.SAUCE, "name", expected);
        Assert.assertEquals(expected, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        String expected = "name";
        ingredient = new Ingredient(IngredientType.SAUCE, expected, 100F);
        Assert.assertEquals(expected, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        ingredient = new Ingredient(expected, "name", 100F);
        Assert.assertEquals(expected, ingredient.getType());
    }
}
