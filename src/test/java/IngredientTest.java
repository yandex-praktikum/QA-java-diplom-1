import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void checkIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals("Expected result does not match the actual", IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void checkIngredientNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals("Expected result does not match the actual", "hot sauce", ingredient.getName());
    }

    @Test
    public void checkIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals("Expected result does not match the actual", 100, ingredient.getPrice(), 0);
    }
}
