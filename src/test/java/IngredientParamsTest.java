import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)

public class IngredientParamsTest {
    private IngredientType type;
    private String name;
    private float price;

    public IngredientParamsTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                { IngredientType.SAUCE, "tomatoSouse", 130},
                { IngredientType.FILLING, "cheese", 67},
                { IngredientType.FILLING, "pork", 200},
        };
    }

    @Test
    public void createIngredientWithAnyDataTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(type, actualType);
    }

}
