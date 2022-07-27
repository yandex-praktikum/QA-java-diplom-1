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

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100f},
                {FILLING, "cutlet", 100f},
                {null, "sour cream", 300f},
                {SAUCE, "", 100f},
                {SAUCE, null, 100f}
        };
    }

    @Test
    public void getIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        assertEquals("Актуальный результат отличается от ожидаемого", type, actual);
    }

    @Test
    public void getIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        assertEquals("Актуальный результат отличается от ожидаемого", name, actual);
    }

    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        assertEquals("Актуальный результат отличается от ожидаемого", price, actual, 0);
    }
}

