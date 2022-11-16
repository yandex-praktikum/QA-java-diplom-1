import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test name", 1);

    @Test
    public void testGetPrice(){
        Assert.assertEquals(1, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("test name", ingredient.getName());
    }

    @Test
    public void testGetType(){
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
