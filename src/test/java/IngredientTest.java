import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "name", 39f);

    @Test
    public void checkGetName() {
        Assert.assertEquals("name", ingredient.getName());
    }

    @Test
    public void checkGetPrice() {
        Assert.assertEquals(39f, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetType() {
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
