package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class IngredientTest {
    private Ingredient ingredient;

    private final IngredientType ingredientTypeExpected;
    private final String nameExpected;
    private final float priceExpected;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientTypeExpected = ingredientType;
        this.nameExpected = name;
        this.priceExpected = price;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getKittensCountData() {
        return new Object[][]{
                {IngredientType.FILLING, "cutlet", 343.0f},
                {IngredientType.SAUCE, "white sauce", 45322.3f},
                {IngredientType.FILLING, "grilled meat", 0f},
                {IngredientType.SAUCE, "bolognese", 349878987.1f},
        };
    }

    @Test
    public void createAnIngredientSetAndGetCheckPositive() {
        ingredient = new Ingredient(ingredientTypeExpected, nameExpected, priceExpected);
        String ingredientTypeActual = String.valueOf(ingredient.getType());
        String nameActual = ingredient.getName();
        float priceActual = ingredient.getPrice();
        Assert.assertEquals(String.valueOf(ingredientTypeExpected), ingredientTypeActual);
        Assert.assertEquals(nameExpected, nameActual);
        Assert.assertTrue(priceExpected == priceActual);
        ;
    }

}

