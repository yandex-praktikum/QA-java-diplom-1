package practikumtest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;

    @Parameterized.Parameter
    public String name;
    @Parameterized.Parameter(1)
    public float price;
    @Parameterized.Parameter(2)
    public IngredientType type;

    @Parameterized.Parameters
    public static Object[][] params() throws Exception {
        return new Object[][]{
                {"Соус Spicy-X", 199.99f, SAUCE},
                {"Мини-салат Экзо-Плантаго", 99.99f, FILLING},
        };
    }

    @Before
    public void setUp() throws Exception {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Assert.assertEquals(ingredient.getName(), name);
    }

    @Test
    public void getType() {
        Assert.assertEquals(ingredient.getType(), type);
    }
}