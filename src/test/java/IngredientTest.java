import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Mock
    Ingredient ingredient;
    IngredientType type = IngredientType.FILLING;
    String name = "sauce";
    float price = 54;

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(ingredient.getPrice(), price, 0.0f);
    }

    @Test
    public void testTestGetName() {
        Assert.assertEquals(ingredient.getName(), name);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(ingredient.getType(), type);
    }
}