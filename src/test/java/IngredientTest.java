import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void verifyCreateIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100.01f);
        Assert.assertEquals("hot sauce", ingredient.getName());//
        Assert.assertEquals(100.01, ingredient.getPrice(), 0.00001);//
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());//
    }
}
