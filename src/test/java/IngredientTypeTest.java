import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTypeTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{0},{1},{2}")
    public static Object[][] getType() {
        return new Object[][]{
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "dinosaur", 200f},
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Test
    public void getFillingTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals("Type is incorrect", type, ingredient.getType());
    }
}
