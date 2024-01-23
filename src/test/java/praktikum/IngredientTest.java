package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String name;
    private final float price;
    private final IngredientType ingredientType;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.name = name;
        this.price = price;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[] getIngredientData() {
        return new Object[][]{
                {IngredientType.FILLING, "firstfilling", 100.50f},
                {IngredientType.SAUCE, "firstsauce", 200.00f},
                {IngredientType.FILLING, "second_filling", 0.25f},
                {IngredientType.SAUCE, "second_sauce", 1000},
                {IngredientType.FILLING, "test", 0},
        };
    }


    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals(price, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String actualName = ingredient.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals(ingredientType, actualType);
    }
}