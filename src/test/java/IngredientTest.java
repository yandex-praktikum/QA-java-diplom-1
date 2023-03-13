import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private final String NAME = "Кошка";
    private final float PRICE = 3.14f;
    @Mock
    IngredientType type;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, NAME, PRICE);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(NAME, ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(type, ingredient.getType());
    }
}
