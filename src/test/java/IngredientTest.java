import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ingredient {index} -> Type: {0}, Name: {1}, Price:{2} ")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 0.0f},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, null, 200},
                {null, "sausage", 300},
                {FILLING, "sausage", 300},
        };
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Sorry, price incorrect", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameReturnValidName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Sorry, name incorrect", name, ingredient.getName());
    }

    @Test
    public void getTypeReturnCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Sorry, type incorrect", type, ingredient.getType());
    }
}