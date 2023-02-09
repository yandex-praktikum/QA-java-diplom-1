import praktikum.IngredientType;
import org.junit.Test;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final float price;
    private final String name;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ingredient {index} -> Type: {0}, Name: {1}, Price:{2} ")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {SAUCE, "sour cream", 0.0f},
                {SAUCE, "hot sauce", 100},
                {SAUCE, "chili sauce", 300},
                {FILLING, null, 200},
                {FILLING, "cutlet", 100},
                {FILLING, "sausage", 300},
                {null, "sausage", 300},
        };
    }
    @Test
    public void getTypeReturnCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Sorry, type incorrect", type, ingredient.getType());
    }
    @Test
    public void getNameReturnValidName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Sorry, name incorrect", name, ingredient.getName());
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Sorry, price incorrect", price, ingredient.getPrice(), 0.0f);
    }
}
