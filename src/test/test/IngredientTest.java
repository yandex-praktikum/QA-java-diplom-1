import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest extends BaseTest {

    private static IngredientType expectedIngredientType;

    private static Ingredient ingredient;

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {IngredientType.FILLING, expectedIngredientName, expectedPrice},
                {IngredientType.SAUCE, expectedIngredientName, expectedPrice}
        };
    }

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        expectedIngredientType = ingredientType;
        ingredient = new Ingredient(expectedIngredientType, name, price);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), testDelta);
    }

    @Test
    public void getName() {
        Assert.assertEquals(expectedIngredientName, ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(expectedIngredientType, ingredient.getType());
    }
}
