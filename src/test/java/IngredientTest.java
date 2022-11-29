import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void checkGetPriceIngredient() {
        Assert.assertEquals(100, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetNameIngredient() {
        Assert.assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void checkGetTypeIngredient() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
