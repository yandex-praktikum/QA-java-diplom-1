import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String name;
    public final float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType ingredientType, String name, float price, Ingredient ingredient) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "соус", 2.00F, new Ingredient(IngredientType.SAUCE, "соус", 2.00F)},
                {IngredientType.FILLING, "не соус", 4.00F, new Ingredient(IngredientType.FILLING, "не соус", 4.00F)},
        };
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }
}
