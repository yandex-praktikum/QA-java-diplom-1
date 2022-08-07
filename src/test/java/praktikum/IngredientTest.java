package praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final float price;
    private final String name;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters (name = "index: {0} {1} {2}")
    public static Object[][] getIngredients() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100f},
                {SAUCE, "sour cream", 200f},
                {SAUCE, "chili sauce", 300f},
                {FILLING, "cutlet", 100f},
                {FILLING, "dinosaur", 200f},
                {FILLING, "sausage", 300f},
        };
    }
    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
    @Test
    public void getIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }
    @Test
    public void getIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(type, actualType);
    }
}
