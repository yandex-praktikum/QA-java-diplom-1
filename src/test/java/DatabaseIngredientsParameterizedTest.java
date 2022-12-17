import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class DatabaseIngredientsParameterizedTest {

    private final Database database = new Database();
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public DatabaseIngredientsParameterizedTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] setTestData() {
        return new Object[][] {
            {IngredientType.SAUCE, "hot sauce", 100f},
            {IngredientType.SAUCE, "sour cream", 200f},
            {IngredientType.SAUCE, "chili sauce", 300f},
            {IngredientType.FILLING, "cutlet", 100f},
            {IngredientType.FILLING, "dinosaur", 200f},
            {IngredientType.FILLING, "sausage", 300f}
        };
    }

    @Test
    public void availableIngredientsAvailableIngredientsChecked() throws Exception {
        int ingredientsTotalCount = 6;
        int count = 0;
        for (Ingredient ingredient : database.availableIngredients()) {
            if (ingredient.name.equals(ingredientName)) {
                Assert.assertEquals("Ingredient type isn't correct", ingredient.getType(), ingredientType);
                Assert.assertEquals("Ingredient price isn't correct", ingredient.getPrice(), ingredientPrice, 0.01f);
            } else {
                count++;
            }
            if (count == ingredientsTotalCount) {
                throw new Exception("Ingredient isn't available");
            }
        }
    }

}
