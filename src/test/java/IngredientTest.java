import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "name", 39f);

    @Test
    public void testGetName() {
        Assert.assertEquals("name", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(39f, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
