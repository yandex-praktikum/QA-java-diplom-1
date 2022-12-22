import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    public Ingredient ingredient;
    @Mock
    public IngredientType ingredientType;

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, "bacon", 5.5f);
    }

    @Test
    public void getNameIngredient() {
        Assert.assertEquals("bacon", ingredient.getName());
    }

    @Test
    public void getPriceIngredient() {
        Assert.assertEquals(5.5f, ingredient.getPrice(), 0.1f);
    }
}