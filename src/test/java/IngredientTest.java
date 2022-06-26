import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setup() {
        ingredient = new Ingredient(type, name, price);
    }

    public final IngredientType type;
    public final String name;
    public final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Different ingredients")
    public static Object[][] getDifferentIngredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "Чили", 2},
                {IngredientType.FILLING, "Котлета", 10},
        };
    }

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();

        Assert.assertEquals(price, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();

        assertEquals(name, actualName);
    }

    @Test
    public void getTypeTest() {
        String expectedType = String.valueOf(type);
        String actualType = ingredient.getType().toString();

        assertEquals(expectedType, actualType);
    }
}
