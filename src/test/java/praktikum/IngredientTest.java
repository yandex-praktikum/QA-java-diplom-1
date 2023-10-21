package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);

    @Test
    public void testGetIngredientName() {
        Assert.assertEquals("sour cream", ingredient.getName());
    }

    @Test
    public void testGetIngredientPrice() {
        Assert.assertEquals(200, ingredient.getPrice(), 0);
    }

}