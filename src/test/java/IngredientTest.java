import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "ingredient", 20.00f);
    }


    @Test
    public void getPriceReturnsCorrectValue() {
        Assert.assertEquals(20.00f, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        Assert.assertEquals("ingredient", ingredient.getName());
    }

    @Test
    public void getTypeReturnsCorrectValue() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
