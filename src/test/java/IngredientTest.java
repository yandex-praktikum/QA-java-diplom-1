import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    String ingredientName;
    float ingredientPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] allIngredients() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100F},
                {IngredientType.SAUCE, "sour cream", 200F},
                {IngredientType.SAUCE, "chili sauce", 300F},
                {IngredientType.FILLING, "cutlet", 100F},
                {IngredientType.FILLING, "dinosaur", 200F},
                {IngredientType.FILLING, "sausage", 300F},
        };
    }

    /**
     * Проверка, что метод возвращает цену ингредиента
     */
    @Test
    public void getPriceSomeIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        float actual = ingredient.getPrice();
        Assert.assertEquals(ingredientPrice, actual, 0.05);
    }

    /**
     * Проверка, что метод возвращает название ингредиента
     */
    @Test
    public void getNameSomeIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        String actual = ingredient.getName();
        Assert.assertEquals(ingredientName, actual);
    }

    /**
     * Проверка, что метод возвращает тип ингредиента
     */
    @Test
    public void getTypeSomeIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(ingredientType, actual);
    }
}
