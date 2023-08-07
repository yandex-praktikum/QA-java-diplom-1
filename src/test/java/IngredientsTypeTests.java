import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientsTypeTests {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientsTypeTests(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.FILLING, "hot sauce", 100F},
                {IngredientType.FILLING, "sour cream", 200F},
                {IngredientType.FILLING, "chili sauce", 300F},
                {IngredientType.SAUCE, "cutlet", 100F},
                {IngredientType.SAUCE, "dinosaur", 200F},
                {IngredientType.SAUCE, "sausage", 300F}
        };
    }

    @Test
    public void typeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }

}
