package praktikum;

import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters(name = "Ingredient with name \"{1}\" has a price \"{2}\" and ingredient type \"{0}\"")
    public static Object data() {
        return new Object[][] {
                { IngredientType.FILLING, "", 0.0f },
                { IngredientType.FILLING, "", -1 },
                { IngredientType.FILLING, "", 1.5f },
                { IngredientType.FILLING, "filling", 1 },
                { IngredientType.SAUCE, "", 0.0f},
                { IngredientType.SAUCE, "", -1.5f},
                { IngredientType.SAUCE, "", 1.5f},
                { IngredientType.SAUCE, "sauce", 1.5f}
        };
    }

    @Test
    public void getPriceCorrespondingParametrization() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0.001f);
    }

    @Test
    public void getNameCorrespondingParametrization() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals(type, actualIngredientType);
    }
}