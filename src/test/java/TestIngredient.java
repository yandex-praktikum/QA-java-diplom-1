import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestIngredient {

    private String name = "имя";
    private float price = 100;
    private final IngredientType ingredientType;

    public TestIngredient(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    Ingredient createIngredient() {
        return new Ingredient(ingredientType, name, price);
    }

    @Parameterized.Parameters(name = "Test data: {0}")
            public static Object[][] getIngredientType() {
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void checkIngredientGetPrice() {
        Assert.assertEquals(price, createIngredient().getPrice(), 0);
    }

    @Test
    public void checkIngredientGetName() {
        Assert.assertEquals(name, createIngredient().getName());
    }

    @Test
    public void checkIngredientGetIngredientType() {
        Assert.assertEquals(ingredientType, createIngredient().getType());
    }
}
