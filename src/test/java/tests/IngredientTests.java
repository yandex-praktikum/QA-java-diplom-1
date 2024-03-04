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
    private final IngredientType type;
    private static final Ingredient firstIngredient = TestData.returnIngredientByIndex(0);
    private static final Ingredient secondIngredient = TestData.returnIngredientByIndex(1);
    private static final Ingredient thirdIngredient = TestData.returnIngredientByIndex(2);
    private static final Ingredient fourthIngredient = TestData.returnIngredientByIndex(3);
    private static final Ingredient fifthIngredient = TestData.returnIngredientByIndex(4);
    private static final Ingredient sixthIngredient = TestData.returnIngredientByIndex(5);

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {firstIngredient.getType(), firstIngredient.getName(), firstIngredient.getPrice()},
                {secondIngredient.getType(), secondIngredient.getName(), secondIngredient.getPrice()},
                {thirdIngredient.getType(), thirdIngredient.getName(), thirdIngredient.getPrice()},
                {fourthIngredient.getType(), fourthIngredient.getName(), fourthIngredient.getPrice()},
                {fifthIngredient.getType(), fifthIngredient.getName(), fifthIngredient.getPrice()},
                {sixthIngredient.getType(), sixthIngredient.getName(), sixthIngredient.getPrice()}
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
        Assert.assertEquals("Prices should match", price, actualPrice, 0.0f);
    }
}
