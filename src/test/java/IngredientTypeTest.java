import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;

        Assert.assertEquals(actual, expected);
    }
}
