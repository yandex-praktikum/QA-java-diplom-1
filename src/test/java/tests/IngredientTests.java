package tests;

import helpers.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTests {
    private final String name;
    private final float price;
    private final float delta = TestData.DELTA;
    private final IngredientType type;
    private static final Ingredient FIRST_INGREDIENT = TestData.returnIngredientByIndex(0);
    private static final Ingredient SECOND_INGREDIENT = TestData.returnIngredientByIndex(1);
    private static final Ingredient THIRD_INGREDIENT = TestData.returnIngredientByIndex(2);
    private static final Ingredient FOURTH_INGREDIENT = TestData.returnIngredientByIndex(3);
    private static final Ingredient FIFTH_INGREDIENT = TestData.returnIngredientByIndex(4);
    private static final Ingredient SIXTH_INGREDIENT = TestData.returnIngredientByIndex(5);

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientsData() {
        return new Object[][]{
                {FIRST_INGREDIENT.getType(), FIRST_INGREDIENT.getName(), FIRST_INGREDIENT.getPrice()},
                {SECOND_INGREDIENT.getType(), SECOND_INGREDIENT.getName(), SECOND_INGREDIENT.getPrice()},
                {THIRD_INGREDIENT.getType(), THIRD_INGREDIENT.getName(), THIRD_INGREDIENT.getPrice()},
                {FOURTH_INGREDIENT.getType(), FOURTH_INGREDIENT.getName(), FOURTH_INGREDIENT.getPrice()},
                {FIFTH_INGREDIENT.getType(), FIFTH_INGREDIENT.getName(), FIFTH_INGREDIENT.getPrice()},
                {SIXTH_INGREDIENT.getType(), SIXTH_INGREDIENT.getName(), SIXTH_INGREDIENT.getPrice()}
        };
    }

    @Test
    public void getIngredientFillingTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Types should match", type, actualType);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals("Names should match", name, actualName);
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Prices should match", price, actualPrice, delta);
    }
}
