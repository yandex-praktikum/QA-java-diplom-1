import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import praktikum.IngredientType;
import praktikum.Ingredient;
@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {Mockito.mock(IngredientType.class), "Tomato Sauce", 1.5f},
                {Mockito.mock(IngredientType.class), "Cheese Filling", 2.0f},
                {Mockito.mock(IngredientType.class), "Meat", 5.0f}
        };
    }
    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void testGetPrice() {
        assertEquals(price, ingredient.getPrice(), 0);
    }
    @Test
    public void testGetName() {
        assertEquals(name, ingredient.getName());
    }
    @Test
    public void testGetType() {
        assertEquals(type, ingredient.getType());
    }
}